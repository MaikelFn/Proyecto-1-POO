/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Banco {
    private final ArrayList<Cliente> clientes;

    public Banco() {
        clientes = new ArrayList<>();
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }
    
    public void cargarClientes(String xmlPath) {
        // Obtener la lista de clientes desde el archivo XML
        ArrayList<Cliente> clientesDesdeXML = XMLReader.leerClientesDesdeXML(xmlPath);

        // Agregar los clientes cargados al banco, evitando duplicados
        for (Cliente cliente : clientesDesdeXML) {
            boolean existeCliente = false;

            for (Cliente clienteExistente : clientes) {
                if (clienteExistente.getNombreCompleto().equalsIgnoreCase(cliente.getNombreCompleto())) {
                    existeCliente = true;
                    break;
                }
            }

            if (!existeCliente) {
                agregarCliente(cliente);
                System.out.println("Cliente " + cliente.getNombreCompleto() + " agregado.");
            } else {
                System.out.println("El cliente " + cliente.getNombreCompleto() + " ya existe y no se agregará.");
            }
        }
    }
}
