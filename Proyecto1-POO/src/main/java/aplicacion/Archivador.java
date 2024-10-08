/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import java.util.LinkedList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

/**
 *
 * @author Dillan
 */
public class Archivador {
  private final String tipoDato;
  private final LinkedList<String> datos;
  
  public Archivador (){
    tipoDato = "";
    datos = new LinkedList<>();
    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse("archivo.xml");
      document.getDocumentElement().normalize();
    }
    catch(Exception e){
      e.printStackTrace();
    }
  }
}
