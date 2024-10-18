package Clases;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import Clases.Cliente;
import Clases.Cuenta;

public class XMLReader {

    // Método que lee clientes desde el archivo XML y los devuelve en un ArrayList de Clientes
    public static ArrayList<Cliente> leerClientesDesdeXML(String xmlPath) {
        ArrayList<Cliente> clientesCargados = new ArrayList<>();

        try {
            // Preparar el analizador de XML
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Obtener todos los elementos "Cliente" del archivo XML
            NodeList nList = doc.getElementsByTagName("Cliente");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Leer los datos de cada cliente desde las etiquetas del XML
                    String nombreCompleto = element.getElementsByTagName("NombreCompleto").item(0).getTextContent();
                    String identificacion = element.getElementsByTagName("Identificacion").item(0).getTextContent();
                    String telefono = element.getElementsByTagName("Telefono").item(0).getTextContent();
                    String correoElectronico = element.getElementsByTagName("CorreoElectronico").item(0).getTextContent();

                    // Crear el objeto Cliente
                    Cliente nuevoCliente = new Cliente(nombreCompleto, identificacion, telefono, correoElectronico);

                    // Agregar el cliente a la lista temporal de clientes cargados
                    clientesCargados.add(nuevoCliente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientesCargados; // Devolver la lista de clientes cargados
    }
}
