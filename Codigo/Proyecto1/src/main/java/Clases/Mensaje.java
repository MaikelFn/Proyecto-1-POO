/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Estudiante
 */
public class Mensaje {
  private final String numeroTelefono;
  private final String palabra;
  
  public Mensaje(String pNumero, String pPalabra){
    this.numeroTelefono = pNumero;
    this.palabra = pPalabra;
  }
  public void enviar(){}
  
  public boolean validarPalabra(String pPalabraIgresada){
      return pPalabraIgresada.equals(this.palabra);
  }
}
