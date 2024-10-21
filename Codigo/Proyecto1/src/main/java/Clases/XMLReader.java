package Clases;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

public class XMLReader {

    // Método que lee clientes y sus cuentas desde el archivo XML
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

                            // Leer los datos de cada cuenta
                            int numeroCuenta = Integer.parseInt(cuentaElement.getElementsByTagName("NumeroCuenta").item(0).getTextContent());
                            String pinCifrado = cuentaElement.getElementsByTagName("PinCifrado").item(0).getTextContent();
                            double saldo = Double.parseDouble(cuentaElement.getElementsByTagName("Saldo").item(0).getTextContent());
                            boolean estatus = Boolean.parseBoolean(cuentaElement.getElementsByTagName("Estatus").item(0).getTextContent());
                            LocalDate fechaCreacion = LocalDate.parse(cuentaElement.getElementsByTagName("FechaCreacion").item(0).getTextContent());

                            // Crear la cuenta y agregarla al cliente
                            Cuenta cuenta = new Cuenta(numeroCuenta, pinCifrado, saldo, nuevoCliente);
                            cuenta.setEstatus(estatus);  // Establecer el estado de la cuenta
                            cuenta.setFechaCreacion(fechaCreacion);  // Establecer la fecha de creación

                            nuevoCliente.agregarCuenta(cuenta);  // Agregar la cuenta al cliente
                        }
                    }

                    // Agregar el cliente a la lista de clientes cargados
                    clientesCargados.add(nuevoCliente);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return clientesCargados; // Devolver la lista de clientes cargados
    }
    
    public static ArrayList<Transaccion> leerTransaccionesPorNumeroCuenta(String xmlPath, int numeroCuentaBuscado) {
        ArrayList<Transaccion> transacciones = new ArrayList<>();

        try {
            // Preparar el analizador de XML
            File inputFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            // Obtener todos los elementos "Cuenta" del archivo XML
            NodeList cuentasList = doc.getElementsByTagName("Cuenta");

            for (int i = 0; i < cuentasList.getLength(); i++) {
                Element cuentaElement = (Element) cuentasList.item(i);

                // Leer el número de cuenta y verificar si coincide con el buscado
                int numeroCuenta = Integer.parseInt(cuentaElement.getElementsByTagName("NumeroCuenta").item(0).getTextContent());
            
                if (numeroCuenta == numeroCuentaBuscado) {
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

                    break;  // Romper el bucle, ya que encontramos la cuenta buscada
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transacciones; // Devolver la lista de transacciones
    }

}

