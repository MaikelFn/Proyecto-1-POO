/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;
import java.io.File;
import java.io.IOException;
import org.xml.sax.SAXException;

/** Clase que maneja la persistencia en archivos XML. */
public class XMLWriter {

  /**
   * Agrega un cliente al archivo XML.
   *
   * @param pNombre Nombre del cliente.
   * @param pIdentificacion Identificación del cliente.
   * @param pTelefono Teléfono del cliente.
   * @param pCorreoElectronico Correo electrónico del cliente.
   * @param pFilePath Ruta del archivo XML.
   */
  public static void agregarCliente(
      String pNombre, String pIdentificacion, String pTelefono, 
      String pCorreoElectronico, String pFilePath) {

    try {
      File xmlFile = new File(pFilePath);
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document;

      if (xmlFile.exists() && xmlFile.length() > 0) {
        try {
          document = builder.parse(xmlFile);
          document.getDocumentElement().normalize();
        } catch (IOException | SAXException e) {
          System.out.println("El archivo XML estaba corrupto. Se creará uno nuevo.");
          document = crearNuevoDocumento(builder);
        }
      } else {
        document = crearNuevoDocumento(builder);
      }

      Element root = document.getDocumentElement();
      Element cliente = document.createElement("Cliente");

      Element nombreElem = document.createElement("NombreCompleto");
      nombreElem.appendChild(document.createTextNode(pNombre));
      cliente.appendChild(nombreElem);

      Element idElem = document.createElement("Identificacion");
      idElem.appendChild(document.createTextNode(pIdentificacion));
      cliente.appendChild(idElem);

      Element telefonoElem = document.createElement("Telefono");
      telefonoElem.appendChild(document.createTextNode(pTelefono));
      cliente.appendChild(telefonoElem);

      Element correoElem = document.createElement("CorreoElectronico");
      correoElem.appendChild(document.createTextNode(pCorreoElectronico));
      cliente.appendChild(correoElem);

      root.appendChild(cliente);
      guardarCambios(document, xmlFile);

      System.out.println("Cliente agregado con éxito al archivo XML.");
    } catch (ParserConfigurationException | TransformerException e) {
    }
  }

  /**
   * Crea un nuevo documento XML con la estructura inicial.
   *
   * @param pBuilder Constructor de documentos XML.
   * @return Nuevo documento XML.
   */
  private static Document crearNuevoDocumento(DocumentBuilder pBuilder) {
    Document document = pBuilder.newDocument();
    Element root = document.createElement("Clientes");
    document.appendChild(root);
    return document;
  }

  /**
   * Agrega una cuenta a un cliente en el archivo XML.
   *
   * @param pIdentificacion Identificación del cliente.
   * @param pNumeroCuenta Número de la cuenta.
   * @param pFechaCreacion Fecha de creación de la cuenta.
   * @param pEstatus Estado de la cuenta.
   * @param pSaldo Saldo de la cuenta.
   * @param pPin PIN de la cuenta.
   * @param pArchivoXML Ruta del archivo XML.
   */
  public static void agregarCuenta(
      String pIdentificacion, String pNumeroCuenta, String pFechaCreacion, 
      String pEstatus, double pSaldo, String pPin, String pArchivoXML) {

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new File(pArchivoXML));
      NodeList clientes = doc.getElementsByTagName("Cliente");

      for (int i = 0; i < clientes.getLength(); i++) {
        Element cliente = (Element) clientes.item(i);
        String id = cliente.getElementsByTagName("Identificacion")
                          .item(0).getTextContent();

        if (id.equals(pIdentificacion)) {
          Element cuentasElement = (Element) cliente.getElementsByTagName("Cuentas").item(0);
          if (cuentasElement == null) {
            cuentasElement = doc.createElement("Cuentas");
            cliente.appendChild(cuentasElement);
          }

          Element cuenta = doc.createElement("Cuenta");

          cuenta.appendChild(crearElemento(doc, "Numero", pNumeroCuenta));
          cuenta.appendChild(crearElemento(doc, "FechaCreacion", pFechaCreacion));
          cuenta.appendChild(crearElemento(doc, "Estatus", pEstatus));
          cuenta.appendChild(crearElemento(doc, "Saldo", String.valueOf(pSaldo)));
          cuenta.appendChild(crearElemento(doc, "Pin", pPin));

          cuentasElement.appendChild(cuenta);
          guardarCambios(doc, new File(pArchivoXML));

          System.out.println("Cuenta agregada con éxito al cliente: " + pIdentificacion);
          return;
        }
      }

      System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
    } catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
    }
  }

  /**
   * Guarda una transacción en el archivo XML.
   *
   * @param pIdentificacion Identificación del cliente.
   * @param pTipoTransaccion Tipo de transacción.
   * @param pMonto Monto de la transacción.
   * @param pFecha Fecha de la transacción.
   * @param pTieneComision Indica si tiene comisión.
   * @param pArchivoXML Ruta del archivo XML.
   */
  public static void guardarTransaccion(
      String pIdentificacion, String pTipoTransaccion, double pMonto, 
      String pFecha, boolean pTieneComision, String pArchivoXML) {

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document doc = builder.parse(new File(pArchivoXML));
      NodeList clientes = doc.getElementsByTagName("Cliente");

      for (int i = 0; i < clientes.getLength(); i++) {
        Element cliente = (Element) clientes.item(i);
        String id = cliente.getElementsByTagName("Identificacion")
                          .item(0).getTextContent();

        if (id.equals(pIdentificacion)) {
          Element cuenta = (Element) cliente.getElementsByTagName("Cuenta").item(0);
          Element transacciones = (Element) cuenta.getElementsByTagName("Transacciones").item(0);

          if (transacciones == null) {
            transacciones = doc.createElement("Transacciones");
            cuenta.appendChild(transacciones);
          }

          Element transaccion = doc.createElement("Transaccion");
          transaccion.appendChild(crearElemento(doc, "Tipo", pTipoTransaccion));
          transaccion.appendChild(crearElemento(doc, "Monto", String.valueOf(pMonto)));
          transaccion.appendChild(crearElemento(doc, "Fecha", pFecha));
          transaccion.appendChild(crearElemento(doc, "Comision", pTieneComision ? "Sí" : "No"));

          transacciones.appendChild(transaccion);
          guardarCambios(doc, new File(pArchivoXML));

          System.out.println("Transacción guardada con éxito.");
          return;
        }
      }

      System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
    } catch (IOException | ParserConfigurationException | TransformerException | DOMException | SAXException e) {
    }
  }

  // Método auxiliar para crear un elemento XML.
  private static void guardarCambios(Document pDoc, File pArchivo) throws TransformerException {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();

    // Eliminar indentación y saltos de línea.
    transformer.setOutputProperty(OutputKeys.INDENT, "no");
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

    pDoc.normalizeDocument();
    DOMSource source = new DOMSource(pDoc);
    StreamResult result = new StreamResult(pArchivo);

    transformer.transform(source, result);
}

     /**
    * Método auxiliar para crear un elemento XML.
    *
    * @param doc El documento XML en el que se creará el elemento.
    * @param tipo El nombre del elemento que se va a crear.
    * @param valor El valor de texto que se asignará al elemento.
    * @return El elemento XML creado.
    */
    private static Node crearElemento(Document doc, String tipo, String valor) {
        Element elemento = doc.createElement(tipo);
        elemento.appendChild(doc.createTextNode(valor));
        return elemento;
    }
    
    /**
    * Reemplaza el número de teléfono de un cliente en el archivo XML.
    *
    * @param pIdentificacion Identificación del cliente.
    * @param pNuevoTelefono Nuevo número de teléfono.
    * @param pArchivoXML Ruta del archivo XML.
    */
    public static void reemplazarTelefono(String pIdentificacion, String pNuevoTelefono, String pArchivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(pArchivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(pIdentificacion)) {
                    Element telefonoElem = (Element) cliente.getElementsByTagName("Telefono").item(0);
                    if (telefonoElem != null) {
                        telefonoElem.setTextContent(pNuevoTelefono);
                        guardarCambios(doc, new File(pArchivoXML));
                        System.out.println("Teléfono reemplazado con éxito para el cliente: " + pIdentificacion);
                    } else {
                        System.out.println("No se encontró el elemento Teléfono para el cliente: " + pIdentificacion);
                    }
                    return;
                }
            }

            System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
    * Reemplaza el correo electrónico de un cliente en el archivo XML.
    *
    * @param pIdentificacion Identificación del cliente.
    * @param pNuevoCorreo Nuevo correo electrónico.
    * @param pArchivoXML Ruta del archivo XML.
    */
    public static void reemplazarCorreo(String pIdentificacion, String pNuevoCorreo, String pArchivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(pArchivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(pIdentificacion)) {
                    Element correoElem = (Element) cliente.getElementsByTagName("CorreoElectronico").item(0);
                    if (correoElem != null) {
                        correoElem.setTextContent(pNuevoCorreo);
                        guardarCambios(doc, new File(pArchivoXML));
                        System.out.println("Correo reemplazado con éxito para el cliente: " + pIdentificacion);
                    } else {
                        System.out.println("No se encontró el elemento Correo Electrónico para el cliente: " + pIdentificacion);
                    }
                    return;
                }
            }

            System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }
    /**
    * Reemplaza el saldo de una cuenta de un cliente en el archivo XML.
    *
    * @param pIdentificacion Identificación del cliente.
    * @param pNumeroCuenta Número de la cuenta a modificar.
    * @param pNuevoSaldo Nuevo saldo de la cuenta.
    * @param pArchivoXML Ruta del archivo XML.
    */
    public static void reemplazarSaldo(String pIdentificacion, String pNumeroCuenta, double pNuevoSaldo, String pArchivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(pArchivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(pIdentificacion)) {
                    NodeList cuentas = cliente.getElementsByTagName("Cuenta");
                    for (int j = 0; j < cuentas.getLength(); j++) {
                        Element cuenta = (Element) cuentas.item(j);
                        String numero = cuenta.getElementsByTagName("Numero").item(0).getTextContent();

                        if (numero.equals(pNumeroCuenta)) {
                            Element saldoElem = (Element) cuenta.getElementsByTagName("Saldo").item(0);
                            if (saldoElem != null) {
                                saldoElem.setTextContent(String.valueOf(pNuevoSaldo));
                                guardarCambios(doc, new File(pArchivoXML));
                                System.out.println("Saldo reemplazado con éxito para la cuenta: " + pNumeroCuenta);
                            } else {
                                System.out.println("No se encontró el elemento Saldo para la cuenta: " + pNumeroCuenta);
                            }
                            return;
                        }
                    }
                    System.out.println("Cuenta con número " + pNumeroCuenta + " no encontrada para el cliente: " + pIdentificacion);
                    return;
                }
            }

            System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
    * Reemplaza el PIN de una cuenta de un cliente en el archivo XML.
    *
    * @param pIdentificacion Identificación del cliente.
    * @param pNumeroCuenta Número de la cuenta a modificar.
    * @param pNuevoPin Nuevo PIN de la cuenta.
    * @param pArchivoXML Ruta del archivo XML.
    */
    public static void reemplazarPin(String pIdentificacion, String pNumeroCuenta, String pNuevoPin, String pArchivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(pArchivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(pIdentificacion)) {
                    NodeList cuentas = cliente.getElementsByTagName("Cuenta");
                    for (int j = 0; j < cuentas.getLength(); j++) {
                        Element cuenta = (Element) cuentas.item(j);
                        String numero = cuenta.getElementsByTagName("Numero").item(0).getTextContent();

                        if (numero.equals(pNumeroCuenta)) {
                            Element pinElem = (Element) cuenta.getElementsByTagName("Pin").item(0);
                            if (pinElem != null) {
                                pinElem.setTextContent(pNuevoPin);
                                guardarCambios(doc, new File(pArchivoXML));
                                System.out.println("PIN reemplazado con éxito para la cuenta: " + pNumeroCuenta);
                            } else {
                                System.out.println("No se encontró el elemento Pin para la cuenta: " + pNumeroCuenta);
                            }
                            return;
                        }
                    }
                    System.out.println("Cuenta con número " + pNumeroCuenta + " no encontrada para el cliente: " + pIdentificacion);
                    return;
                }
            }

            System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

    /**
    * Reemplaza el estado de una cuenta de un cliente en el archivo XML.
    *
    * @param pIdentificacion Identificación del cliente.
    * @param pNumeroCuenta Número de la cuenta a modificar.
    * @param pNuevoEstado Nuevo estado de la cuenta.
    * @param pArchivoXML Ruta del archivo XML.
    */
    public static void reemplazarEstado(String pIdentificacion, String pNumeroCuenta, String pNuevoEstado, String pArchivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(pArchivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(pIdentificacion)) {
                    NodeList cuentas = cliente.getElementsByTagName("Cuenta");
                    for (int j = 0; j < cuentas.getLength(); j++) {
                        Element cuenta = (Element) cuentas.item(j);
                        String numero = cuenta.getElementsByTagName("Numero").item(0).getTextContent();

                        if (numero.equals(pNumeroCuenta)) {
                            Element estadoElem = (Element) cuenta.getElementsByTagName("Estatus").item(0);
                            if (estadoElem != null) {
                                estadoElem.setTextContent(pNuevoEstado);
                                guardarCambios(doc, new File(pArchivoXML));
                                System.out.println("Estado reemplazado con éxito para la cuenta: " + pNumeroCuenta);
                            } else {
                                System.out.println("No se encontró el elemento Estatus para la cuenta: " + pNumeroCuenta);
                            }
                            return;
                        }
                    }
                    System.out.println("Cuenta con número " + pNumeroCuenta + " no encontrada para el cliente: " + pIdentificacion);
                    return;
                }
            }

            System.out.println("Cliente con identificación " + pIdentificacion + " no encontrado.");
        } catch (IOException | ParserConfigurationException | SAXException | TransformerException e) {
            e.printStackTrace();
        }
    }

}