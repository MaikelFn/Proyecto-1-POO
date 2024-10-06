/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aplicacion;
import logicadenegocios.Cliente;
import logicadenegocios.Cuenta;
import logicadenegocios.Transaccion;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author Dillan, Maikel, Tayler
 */
public class AppCajero {
  private static BufferedReader in;
  private static PrintStream out;
  
  public static void main(String[]args) throws java.io.IOException {
    in = new BufferedReader(new InputStreamReader(System.in));
    menuPrincipal();
  }
  
  public static void menuPrincipal() throws java.io.IOException {
    boolean salir = false;
    int opcion;
    do{
      System.out.println("\u000C");
      System.out.println("-----------------------------");
      System.out.println("| >>> Cajero Electronico <<<|");
      System.out.println("-----------------------------");
      System.out.println("1. Crear Cliente");
      System.out.println("2. Crear Cuenta");
      System.out.println("3. Cambiar PIN");
      System.out.println("4. Depositar (Colones)");
      System.out.println("5. Depositar (Dolares)");
      System.out.println("6. Retiro (Colones)");
      System.out.println("7. Retiro (Dolares)");
      System.out.println("8. Realizar Transferencia");
      
      opcion = leerOpcion();
      switch(opcion) {
        case 1 -> crearCliente();
        case 2 -> crearCuenta();
        case 3 -> cambiarPin();
        case 4 -> depositarColones();
        case 5 -> depositarDolares();
        case 6 -> retiroColones();
        case 7 -> retiroDolares();
        case 8 -> transferir();
        default -> System.out.println("Opción no válida");
      }
    }while(!salir);
  }
  public static int leerOpcion() throws java.io.IOException {
    int opcion;
    System.out.print(" " );
    System.out.print("Seleccione una opcion: " );
    System.out.print(" " );
    opcion = Integer.parseInt(in.readLine());
    System.out.println();
    return opcion;
  }
  public static void crearCliente() {
    
  }
  public static void crearCuenta() {
  }
  public static void cambiarPin() {
  }
  public static void depositarColones() {
  }
  public static void depositarDolares() {
  }
  public static void retiroColones() {
  }
  public static void retiroDolares() {
  }
  public static void transferir() {
  }
}
