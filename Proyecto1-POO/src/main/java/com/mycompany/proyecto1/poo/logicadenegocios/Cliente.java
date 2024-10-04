/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.poo.logicadenegocios;
import java.util.LinkedList;

/**
 *
 * @author Dillan, Maikel, Tayler
 */
@SuppressWarnings("all") //
public class Cliente {
  private final int identificacion;
  private final String nombre;
  private final String apellido1;
  private final String apellido2;
  private final int telefono;
  private final String correo;
  private final LinkedList<Cuenta> cuentas;
  
  /**
   * Método constructor de la clase Cliente
   *
   * @param pIdentificacion
   * @param pNombre 
   * @param pApellido1
   * @param pApellido2
   * @param pTelefono
   * @param pCorreo
   */
  @SuppressWarnings("all") //
  public Cliente (int pIdentificacion,String pNombre,String pApellido1,String pApellido2,int pTelefono,String pCorreo) {
    identificacion = pIdentificacion;
    nombre = pNombre;
    apellido1 = pApellido1;
    apellido2 = pApellido2;
    telefono = pTelefono;
    correo = pCorreo;
    cuentas = new LinkedList<>();    
  }
  //Metodos Accesores
  public int getIdentificacion() {
    return identificacion;
  }
  public String getNombre() {
    return nombre;
  }
  public String getApellido1() {
    return apellido1;
  }
  public String getApellido2() {
    return apellido2;
  }
  public int getTelefono() {
    return telefono;
  }
  public String getCorreo() {
    return correo;
  }
  /**
   * Representación en cadena de caracteres de un objeto de tipo cliente
   *
   * @return cadena de caracteres
   */
  @Override
  public String toString(){
    String msg = "Nombre completo: "+nombre+apellido1+apellido2+"\n" +
                "Identificación: "+identificacion+"\n"+
                "Número de teléfono: "+telefono+"\n" +
                "Dirección de correo electrónico: "+correo;
    return msg;
  }
}
