/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Estudiante
 */
public class Banco {
    private ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public Cliente buscarClientePorID(String id) {
        for (Cliente cliente : clientes) {
            if (cliente.getIdentificacion().equals(id)) {
             return cliente; // Retorna el cliente si coincide el ID.
            }
        }
        return null; // Retorna null si no encuentra el cliente.
    }
    
     public void cargarClientes(String xmlPath) {
        clientes = XMLReader.leerClientesDesdeXML("clientes.xml");
    }
}
