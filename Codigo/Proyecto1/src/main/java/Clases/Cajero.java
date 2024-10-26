package Clases;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.text.StringEscapeUtils;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Clase que representa un cajero en el sistema bancario, con funcionalidad para
 * realizar transacciones y consultar el tipo de cambio del dólar a través de un servicio externo.
 */
public class Cajero {
  
  private final Banco banco;
  private static final String URL_VENTA = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML?Indicador=317&FechaInicio=%s&FechaFinal=%s&Nombre=Profit&SubNiveles=N&CorreoElectronico=bancoprofit@gmail.com&Token=7OORAALCP0";
  private static final String URL_COMPRA = "https://gee.bccr.fi.cr/Indicadores/Suscripciones/WS/wsindicadoreseconomicos.asmx/ObtenerIndicadoresEconomicosXML?Indicador=318&FechaInicio=%s&FechaFinal=%s&Nombre=Profit&SubNiveles=N&CorreoElectronico=bancoprofit@gmail.com&Token=7OORAALCP0";
  
  /**
 * Constructor de la clase Cajero.
 *
 * @param pBanco instancia de Banco que contiene la lista de clientes y sus cuentas.
 */
  public Cajero(Banco pBanco) {
    this.banco = pBanco;
  }
  
  /**
   * Método auxiliar para buscar una cuenta en el banco por su número.
   *
   * @param pNumeroCuenta Número de la cuenta.
   * @return Un Optional con la cuenta encontrada o vacío si no se encuentra.
   */
  private Optional<Cuenta> buscarCuenta(String pNumeroCuenta) {
    for (Cliente cliente : banco.getClientes()) {
      for (Cuenta cuenta : cliente.getCuentas()) {
        if (cuenta.getNumeroCuenta().equalsIgnoreCase(pNumeroCuenta)) {
          return Optional.of(cuenta);
        }
      }
    }
    return Optional.empty();
  }
  
  /**
 * Consulta el tipo de cambio (compra o venta) del dólar mediante un servicio web.
 *
 * @param tipo tipo de cambio a consultar, puede ser "compra" o "venta".
 * @return el tipo de cambio en formato String, o null en caso de error.
 */
  public static String consultarTipoCambio(String tipo) {
    try {
      LocalDate fechaInicio = LocalDate.now();
      LocalDate fechaFinal = fechaInicio.plusDays(7);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
      
      String fechaInicioStr = fechaInicio.format(formatter);
      String fechaFinalStr = fechaFinal.format(formatter);
      
      String url = tipo.equalsIgnoreCase("compra") ? 
                   String.format(URL_COMPRA, fechaInicioStr, fechaFinalStr) :
                   String.format(URL_VENTA, fechaInicioStr, fechaFinalStr);

      HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
      connection.setRequestMethod("GET");

      StringBuilder content;
      try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
        String inputLine;
        content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
        }
      }
      connection.disconnect();
      
      String xmlEscapado = content.toString();
      String xmlDesEscapado = StringEscapeUtils.unescapeXml(xmlEscapado);

      return leerValorNumDesdeXML(xmlDesEscapado);

    } catch (IOException e) {
      System.err.println("Error al consultar el tipo de cambio: " + e.getMessage());
    }
    return null;
  }
  
  /**
 * Extrae el valor del tipo de cambio desde el XML devuelto por el servicio web.
 *
 * @param xmlString el contenido XML en formato String.
 * @return el valor del tipo de cambio en formato String, o null si ocurre algún error.
 */
  public static String leerValorNumDesdeXML(String xmlString) {
    try {
      // Preparar el analizador de XML sin manejar namespaces
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      InputSource inputSource = new InputSource(new StringReader(xmlString));
      Document doc = builder.parse(inputSource);

      // Usar XPath para encontrar el valor de NUM_VALOR
      XPath xpath = XPathFactory.newInstance().newXPath();
      String expression = "//*[local-name()='NUM_VALOR']"; // Buscar el nodo ignorando namespaces

      // Evaluar la expresión XPath
      String numValor = (String) xpath.evaluate(expression, doc, XPathConstants.STRING);

      return numValor;
    } catch (IOException | ParserConfigurationException | XPathExpressionException | SAXException e) {
      return null;
    }
  }
  
  /**
 * Verifica si el PIN ingresado por el usuario corresponde al PIN registrado para una cuenta específica.
 *
 * @param pNumeroCuenta el número de cuenta a verificar.
 * @param pPinIngresado el PIN ingresado por el usuario.
 * @return true si el PIN es correcto, false en caso contrario.
 */
  public boolean validarPin(String pNumeroCuenta, String pPinIngresado) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
      Cuenta cuenta = cuentaOpt.get();
      return cuenta.validarPin(pPinIngresado);  // Suponiendo que Cuenta tiene un método validarPin
    } else {
      System.out.println("Cuenta no encontrada.");
      return false;
    }
  }
  
  /**
 * Realiza una transacción de depósito o retiro en una cuenta específica.
 *
 * @param pNumeroCuenta el número de la cuenta en la que se realizará la transacción.
 * @param pMonto el monto de la transacción.
 * @param pTipoTransaccion el tipo de transacción, puede ser "deposito" o "retiro".
 */
  public void realizarTransaccion(String pNumeroCuenta, double pMonto, String pTipoTransaccion) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
      Cuenta cuenta = cuentaOpt.get();
      if (pTipoTransaccion.equalsIgnoreCase("deposito")) {
        cuenta.realizarDeposito(pMonto);  // Suponiendo que `Cuenta` tiene un método realizarDeposito
      } else if (pTipoTransaccion.equalsIgnoreCase("retiro")) {
        cuenta.realizarRetiro(pMonto);  // Suponiendo que `Cuenta` tiene un método realizarRetiro
      } else {
        System.out.println("Tipo de transacción no válida.");
      }
    } else {
      System.out.println("Cuenta no encontrada.");
    }
  }
  
}
