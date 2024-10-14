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

public class XMLWriter {

    
    public static void agregarCliente(String nombre, String identificacion, String telefono, String correoElectronico, String filePath) {
        try {

            File xmlFile = new File(filePath);
            Document document;
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            if (xmlFile.exists() && xmlFile.length() > 0) {

                try {
                    document = builder.parse(xmlFile);
                    document.getDocumentElement().normalize();
                } catch (Exception e) {
                    System.out.println("El archivo XML estaba corrupto. Se creará uno nuevo.");
                    document = crearNuevoDocumento(builder);
                }
            } else {

                document = crearNuevoDocumento(builder);
            }

            Element root = document.getDocumentElement();

            Element cliente = document.createElement("Cliente");

            Element nombreElem = document.createElement("NombreCompleto");
            nombreElem.appendChild(document.createTextNode(nombre));
            cliente.appendChild(nombreElem);

            Element idElem = document.createElement("Identificacion");
            idElem.appendChild(document.createTextNode(identificacion));
            cliente.appendChild(idElem);

            Element telefonoElem = document.createElement("Telefono");
            telefonoElem.appendChild(document.createTextNode(telefono));
            cliente.appendChild(telefonoElem);

            Element correoElem = document.createElement("CorreoElectronico");
            correoElem.appendChild(document.createTextNode(correoElectronico));
            cliente.appendChild(correoElem);

            root.appendChild(cliente);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(xmlFile);
            transformer.transform(source, result);

            System.out.println("Cliente agregado con éxito al archivo XML.");

        } catch (ParserConfigurationException | TransformerException e) {
            e.printStackTrace();
        }
    }

    private static Document crearNuevoDocumento(DocumentBuilder builder) {

        Document document = builder.newDocument();
        Element root = document.createElement("Clientes");
        document.appendChild(root);
        return document;
    }

    public static void agregarCuenta(String identificacion, String numeroCuenta, String fechaCreacion, String estatus, double saldo, String pin, String archivoXML) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(archivoXML));
            NodeList clientes = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < clientes.getLength(); i++) {
                Element cliente = (Element) clientes.item(i);
                String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

                if (id.equals(identificacion)) {

                    Element cuentasElement = (Element) cliente.getElementsByTagName("Cuentas").item(0);
                    if (cuentasElement == null) {
                        cuentasElement = doc.createElement("Cuentas");
                        cliente.appendChild(cuentasElement);
                    }

                    Element cuenta = doc.createElement("Cuenta");

                    Element numero = doc.createElement("Numero");
                    numero.setTextContent(numeroCuenta);
                    cuenta.appendChild(numero);

                    Element fecha = doc.createElement("FechaCreacion");
                    fecha.setTextContent(fechaCreacion);
                    cuenta.appendChild(fecha);

                    Element tipo = doc.createElement("Estatus");
                    tipo.setTextContent(estatus);
                    cuenta.appendChild(tipo);

                    Element saldoElement = doc.createElement("Saldo");
                    saldoElement.setTextContent(String.valueOf(saldo));
                    cuenta.appendChild(saldoElement);

                    Element pinElement = doc.createElement("Pin");
                    pinElement.setTextContent(pin);
                    cuenta.appendChild(pinElement);

                    cuentasElement.appendChild(cuenta);

                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(archivoXML));
                    transformer.transform(source, result);

                    System.out.println("Cuenta agregada con éxito al cliente con identificación: " + identificacion);
                    return;
                }
            }

            System.out.println("Cliente con identificación " + identificacion + " no encontrado.");

        } catch (ParserConfigurationException | TransformerException | org.xml.sax.SAXException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void guardarTransaccion(String identificacion, String tipoTransaccion, double monto, String fecha, boolean tieneComision, String archivoXML) {
    try {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(archivoXML));
        NodeList clientes = doc.getElementsByTagName("Cliente");

        for (int i = 0; i < clientes.getLength(); i++) {
            Element cliente = (Element) clientes.item(i);
            String id = cliente.getElementsByTagName("Identificacion").item(0).getTextContent();

            if (id.equals(identificacion)) {
                // Verificar si el nodo "Transacciones" existe, si no, crearlo.
                Element cuentasElement = (Element) cliente.getElementsByTagName("Cuentas").item(0);
                if (cuentasElement != null) {
                    NodeList cuentas = cuentasElement.getElementsByTagName("Cuenta");
                    if (cuentas.getLength() > 0) {
                        Element cuenta = (Element) cuentas.item(0); // Supongamos que trabajamos con la primera cuenta
                        Element transaccionesElement = (Element) cuenta.getElementsByTagName("Transacciones").item(0);

                        if (transaccionesElement == null) {
                            transaccionesElement = doc.createElement("Transacciones");
                            cuenta.appendChild(transaccionesElement);
                        }

                        // Crear el nuevo nodo de transacción.
                        Element transaccion = doc.createElement("Transaccion");

                        Element tipoElem = doc.createElement("Tipo");
                        tipoElem.setTextContent(tipoTransaccion);
                        transaccion.appendChild(tipoElem);

                        Element montoElem = doc.createElement("Monto");
                        montoElem.setTextContent(String.valueOf(monto));
                        transaccion.appendChild(montoElem);

                        Element fechaElem = doc.createElement("Fecha");
                        fechaElem.setTextContent(fecha);
                        transaccion.appendChild(fechaElem);

                        Element comisionElem = doc.createElement("Comision");
                        comisionElem.setTextContent(tieneComision ? "Sí" : "No");
                        transaccion.appendChild(comisionElem);

                        // Añadir la nueva transacción al nodo de transacciones.
                        transaccionesElement.appendChild(transaccion);

                        // Guardar los cambios en el archivo XML.
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new File(archivoXML));
                        transformer.transform(source, result);

                        System.out.println("Transacción guardada con éxito para el cliente con identificación: " + identificacion);
                        return;
                    }
                }
            }
        }

        System.out.println("Cliente con identificación " + identificacion + " no encontrado.");

    } catch (ParserConfigurationException | TransformerException | org.xml.sax.SAXException | java.io.IOException e) {
    }
}
}