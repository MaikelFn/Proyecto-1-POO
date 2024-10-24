/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Optional;
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
            if (cliente.getIdentificacion().equalsIgnoreCase(id)) {
             return cliente; // Retorna el cliente si coincide el ID.
            }
        }
        return null; // Retorna null si no encuentra el cliente.
    }
    
     public void cargarClientes(String xmlPath) {
        clientes = XMLReader.leerClientesDesdeXML("clientes.xml");
    }
     
    public void depositarEnDolares(String pNumeroCuenta, double montoDolares) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
        Cuenta cuenta = cuentaOpt.get();
        String tipoCambioVenta = Cajero.consultarTipoCambio("venta");
        double numero = 0;
        try {
            numero = Double.parseDouble(tipoCambioVenta);
}       catch (NumberFormatException e) {
            System.out.println("Error: la cadena no es un número válido.");
}
        double montoEnColones = montoDolares * numero;
        cuenta.realizarDeposito(montoEnColones);
        System.out.println("Depósito realizado con éxito. Monto en colones: " + montoEnColones);
    } else {
        System.out.println("Cuenta no encontrada.");
    }
    }
    
    public void retirarEnDolares(String pNumeroCuenta, double montoDolares) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
        Cuenta cuenta = cuentaOpt.get();
        String tipoCambioVenta = Cajero.consultarTipoCambio("compra");
        double numero = 0;
        try {
            numero = Double.parseDouble(tipoCambioVenta);
        }catch (NumberFormatException e) {
            System.out.println("Error: la cadena no es un número válido.");
        }
        double montoEnColones = montoDolares * numero;
        cuenta.realizarRetiro(montoEnColones);  // Suponiendo que `realizarRetiro` ya está implementado en colones
        System.out.println("Retiro realizado con éxito. Monto en colones: " + montoEnColones);
    } else {
        System.out.println("Cuenta no encontrada.");
    }
    }
    
    public void mostrarSaldoEnDolares(String pNumeroCuenta) {
    Optional<Cuenta> cuentaOpt = buscarCuenta(pNumeroCuenta);
    if (cuentaOpt.isPresent()) {
        Cuenta cuenta = cuentaOpt.get();
        String tipoCambioVenta = Cajero.consultarTipoCambio("compra");
        double numero = 0;
        try {
            numero = Double.parseDouble(tipoCambioVenta);
        }catch (NumberFormatException e) {
            System.out.println("Error: la cadena no es un número válido.");
        }
        double saldoEnColones = cuenta.getSaldo();
        double saldoEnDolares = saldoEnColones / numero;
        System.out.println("El saldo en dólares es: " + saldoEnDolares);
    } else {
        System.out.println("Cuenta no encontrada.");
    }
}



    private Optional<Cuenta> buscarCuenta(String pNumeroCuenta) {
    for (Cliente cliente : getClientes()) {
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getNumeroCuenta().equalsIgnoreCase(pNumeroCuenta)) {
                return Optional.of(cuenta);
            }
        }
    }
    return Optional.empty();
    }
}
