package Clases;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.time.format.DateTimeFormatter;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Clase que maneja la lectura de datos de clientes y transacciones desde un archivo XML.
 */
public class XMLReader {

  /**
   * Lee los clientes y sus cuentas desde un archivo XML.
   *
   * @param xmlPath Ruta del archivo XML desde donde se leerán los datos.
   * @return Una lista de objetos {@link Cliente} que se han cargado desde el archivo XML.
   * @throws IllegalArgumentException Si el archivo XML no existe.
   */
  public static ArrayList<Cliente> leerClientesDesdeXML(String xmlPath) {
    ArrayList<Cliente> clientesCargados = new ArrayList<>();

    File inputFile = new File(xmlPath);
    if (!inputFile.exists()) {
      throw new IllegalArgumentException("El archivo XML no existe: " + xmlPath);
    }

    try {
      // Preparar el analizador de XML
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      // Obtener todos los elementos "Cliente" del archivo XML
      NodeList nList = doc.getElementsByTagName("Cliente");

      // Recorremos todos los nodos de Cliente
      for (int i = 0; i < nList.getLength(); i++) {
        Node node = nList.item(i);

        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) node;

          // Leer los datos del cliente desde las etiquetas del XML
          String nombreCompleto = element.getElementsByTagName("NombreCompleto").item(0).getTextContent();
          String identificacion = element.getElementsByTagName("Identificacion").item(0).getTextContent();
          String telefono = element.getElementsByTagName("Telefono").item(0).getTextContent();
          String correoElectronico = element.getElementsByTagName("CorreoElectronico").item(0).getTextContent();

          // Crear el objeto Cliente
          Cliente nuevoCliente = new Cliente(nombreCompleto, identificacion, telefono, correoElectronico);

          // Leer la etiqueta "Cuentas" del cliente
          NodeList cuentasNodeList = element.getElementsByTagName("Cuentas");

          if (cuentasNodeList.getLength() > 0) {
            Element cuentasElement = (Element) cuentasNodeList.item(0); // Etiqueta Cuentas

            // Leer las etiquetas "Cuenta" dentro de "Cuentas"
            NodeList cuentasList = cuentasElement.getElementsByTagName("Cuenta");

            for (int j = 0; j < cuentasList.getLength(); j++) {
              Element cuentaElement = (Element) cuentasList.item(j);

              // Definir el formato de fecha que estás utilizando
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

              // Leer los datos de cada cuenta
              String numeroCuenta = cuentaElement.getElementsByTagName("Numero").item(0).getTextContent();
              String pinCifrado = cuentaElement.getElementsByTagName("Pin").item(0).getTextContent();
              double saldo = Double.parseDouble(cuentaElement.getElementsByTagName("Saldo").item(0).getTextContent());
              String estado = cuentaElement.getElementsByTagName("Estatus").item(0).getTextContent();
              boolean estatus = estado.equals("Activa");
              String fechaCreacionStr = cuentaElement.getElementsByTagName("FechaCreacion").item(0).getTextContent();

              // Crear la cuenta y agregarla al cliente
              Cuenta cuenta = new Cuenta(numeroCuenta, pinCifrado, saldo, nuevoCliente);
              cuenta.setEstatus(estatus); // Establecer el estado de la cuenta
              LocalDate fechaCreacion = LocalDate.parse(fechaCreacionStr, formatter);
              cuenta.setFechaCreacion(fechaCreacion); // Establecer la fecha de creación

              nuevoCliente.agregarCuenta(cuenta);
            }
          }

          // Agregar el cliente a la lista de clientes cargados
          clientesCargados.add(nuevoCliente);
        }
      }
    } catch (Exception e) {
      System.err.println("Error al leer el archivo XML: " + e.getMessage());
      e.printStackTrace();
    }

    return clientesCargados; // Devolver la lista de clientes cargados
  }

  /**
   * Lee las transacciones de una cuenta específica desde un archivo XML.
   *
   * @param xmlPath Ruta del archivo XML desde donde se leerán los datos.
   * @param numeroCuentaBuscado Número de cuenta para buscar las transacciones.
   * @return Una lista de objetos {@link Transaccion} asociadas a la cuenta buscada.
   * @throws IllegalArgumentException Si el archivo XML no existe.
   */
  public static ArrayList<Transaccion> leerTransaccionesPorNumeroCuenta(String xmlPath, String numeroCuentaBuscado) {
    ArrayList<Transaccion> transacciones = new ArrayList<>();

    File inputFile = new File(xmlPath);
    if (!inputFile.exists()) {
      throw new IllegalArgumentException("El archivo XML no existe: " + xmlPath);
    }

    try {
      // Preparar el analizador de XML
      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
      Document doc = dBuilder.parse(inputFile);
      doc.getDocumentElement().normalize();

      // Obtener todos los elementos "Cuenta" del archivo XML
      NodeList cuentasList = doc.getElementsByTagName("Cuenta");

      for (int i = 0; i < cuentasList.getLength(); i++) {
        Element cuentaElement = (Element) cuentasList.item(i);

        // Leer el número de cuenta y verificar si coincide con el buscado
        String numeroCuenta = cuentaElement.getElementsByTagName("Numero").item(0).getTextContent();

        if (numeroCuenta.equalsIgnoreCase(numeroCuentaBuscado)) {
          // Si coincide, leer las transacciones de la cuenta
          NodeList transaccionesList = cuentaElement.getElementsByTagName("Transaccion");

          for (int j = 0; j < transaccionesList.getLength(); j++) {
            Element transaccionElement = (Element) transaccionesList.item(j);

            // Leer los datos de cada transacción
            String tipo = transaccionElement.getElementsByTagName("Tipo").item(0).getTextContent();
            double monto = Double.parseDouble(transaccionElement.getElementsByTagName("Monto").item(0).getTextContent());
            boolean tieneComision = Boolean.parseBoolean(transaccionElement.getElementsByTagName("TieneComision").item(0).getTextContent());

            // Crear y agregar la transacción a la lista
            Transaccion transaccion = new Transaccion(tipo, monto, tieneComision);
            transacciones.add(transaccion);
          }

          break; // Romper el bucle, ya que encontramos la cuenta buscada
        }
      }
    } catch (IOException | NumberFormatException | ParserConfigurationException | DOMException | SAXException e) {
      System.err.println("Error al leer las transacciones: " + e.getMessage());
    }

    return transacciones;
  }
}
