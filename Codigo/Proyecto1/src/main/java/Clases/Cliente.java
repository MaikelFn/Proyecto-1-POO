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
public class Cliente {
    private String nombreCompleto;
    private String identificación;
    private String númeroTelefono;
    private String correo;
    private ArrayList<Cuenta> listacuentas;
    
    
    public Cliente(String pNombreCompleto, String pIdentificacion, String pTelefono, String pCorreoElectronico){
        this.nombreCompleto = pNombreCompleto;
        this.identificación = pIdentificacion;
        this.númeroTelefono = pTelefono;
        this.correo = pCorreoElectronico;
        this.listacuentas = new ArrayList<>();
    }
    
    public void agregarCuenta(Cuenta cuenta) {
        listacuentas.add(cuenta);
    }

    public ArrayList<Cuenta> getListaCuentas() {
        return listacuentas;
    }
    
      public String getNombre() {
        return nombreCompleto;
    }

    public String getIdentificacion() {
        return identificación;
    }

    public String getTelefono() {
        return númeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

}