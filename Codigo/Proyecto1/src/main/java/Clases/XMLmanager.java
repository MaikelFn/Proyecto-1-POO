/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XMLmanager {
  private List<String> datos;
  
  public XMLmanager(){
    datos = new ArrayList<>();
  }
  public Node buscarNodo(){
    Node nodoBuscar = null;
    return nodoBuscar;
  }
  public boolean existe(String nombreEtiqueta,String IDetiqueta)throws ParserConfigurationException, IOException, SAXException, TransformerException {
    boolean existe = false;
    Document baseDatos = abrirBaseDatos();
    NodeList nodos = baseDatos.getElementsByTagName(nombreEtiqueta);
    for (int numeroNodo = 0; numeroNodo < nodos.getLength(); numeroNodo++) {
      Node nodo = nodos.item(numeroNodo);
      if (nodo.getNodeType() == Node.ELEMENT_NODE) {
        Element elemento = (Element) nodo;
        if (elemento.getAttribute("id").equals(IDetiqueta)) {
          existe = true;
        }
      }
    }
    return existe;
  }
  public void estructurar(List <String> datos,List <String> etiquetas,Document baseDatos,Node nodoP,String nuevaEtiqueta,String IDnuevaEtiqueta)
  {
    Element nuevaSeccion = baseDatos.createElement(nuevaEtiqueta);
    nuevaSeccion.setAttribute("id", IDnuevaEtiqueta);
    int cont = 0;
    for (String dato : datos) {
      String etiquetaDato=etiquetas.get(cont);
      Element datoElemento = baseDatos.createElement(etiquetaDato);
      
      datoElemento.appendChild(baseDatos.createTextNode(dato));
      nuevaSeccion.appendChild(datoElemento);
      cont ++;
    }
    nodoP.appendChild(nuevaSeccion);
  }
  public void guardar(List<String> datos, List<String> etiquetas, String IDetiqueta, String IDnuevaEtiqueta, String nuevaEtiqueta)
          throws ParserConfigurationException, IOException, SAXException, TransformerException {
    
    Document baseDatos = abrirBaseDatos();
    Element nodoRaiz = baseDatos.getDocumentElement();
    // Si la raíz tiene el id especificado
    NodeList nodosClientes = baseDatos.getElementsByTagName("cliente");
    NodeList nodosCuentas = baseDatos.getElementsByTagName("cuenta");
    if (nodoRaiz.getAttribute("id").equals(IDetiqueta)) {
      estructurar(datos, etiquetas, baseDatos, nodoRaiz, nuevaEtiqueta, IDnuevaEtiqueta);
    }
    else{
      if(nuevaEtiqueta.equalsIgnoreCase("transaccion")){
      }
      else{
        System.out.print("EL elemento agregando no es una transaccion " );
        for (int numeroNodo = 0; numeroNodo < nodosClientes.getLength(); numeroNodo++) {
          Node nodo = nodosClientes.item(numeroNodo);
          if (nodo.getNodeType() == Node.ELEMENT_NODE) {
            Element elemento = (Element) nodo;
            System.out.print(elemento.getAttribute("id") );
            
            if (elemento.getAttribute("id").equals(IDetiqueta)){
              estructurar(datos, etiquetas, baseDatos, elemento, nuevaEtiqueta, IDnuevaEtiqueta);
              break;
            }
          }
        }
      }  
    }
    // Guardar los cambios en el archivo XML
    File archivo = new File("baseDatos.xml");
    guardarCambios(baseDatos, archivo);
  }
  public void eliminar(){
  }
  public static Document abrirBaseDatos() throws ParserConfigurationException, IOException, SAXException {
    File archivoXML = new File("baseDatos.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document baseDatos = dBuilder.parse(archivoXML);
    baseDatos.getDocumentElement().normalize();
    return baseDatos;
  }
  
  public static void guardarCambios(Document pDoc, File pArchivo)throws ParserConfigurationException, TransformerException{
  TransformerFactory transformerFactory = TransformerFactory.newInstance();
  Transformer transformer = transformerFactory.newTransformer();
  transformer.setOutputProperty(OutputKeys.INDENT, "yes");
  transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
  DOMSource source = new DOMSource(pDoc);
  StreamResult result = new StreamResult(pArchivo);
  transformer.transform(source, result);
  System.out.println("Archivo XML creado exitosamente ");
  
  }
  
  public static void verificarArchivo(){
    File archivoXML = new File("baseDatos.xml");
    if (archivoXML.exists()) {
      System.out.println("El archivo XML ya existe.");
    } 
    else {
      System.out.println("El archivo XML no existe. Creando el archivo...");
      try {
        crearNuevoDocumento(archivoXML);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static Document inicializarDocumento() throws ParserConfigurationException {
    Document baseDatos;
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newDefaultInstance();
    DocumentBuilder constructor = docFactory.newDocumentBuilder();
    baseDatos = constructor.newDocument();
    return baseDatos;
  }
  
    public static void crearNuevoDocumento(File pArchivoXML)throws ParserConfigurationException, TransformerException{
    Document baseDatos=inicializarDocumento();
    Element clientes = baseDatos.createElement("clientes");
    clientes.setAttribute("id", "0000");
    baseDatos.appendChild(clientes);
    guardarCambios(baseDatos,pArchivoXML);
  }
}