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
      System.out.println("-------------------------");
      System.out.println("| >>> Menu Principal <<<|");
      System.out.println("-------------------------");
      System.out.println("1. Gestionar");
      System.out.println("2. Consultar");
      opcion = leerOpcion();
      switch(opcion) {
        case 1 -> menuGestion();
        case 2 -> menuConsulta();
        default -> System.out.println("Opción no válida");
      }
    }while(!salir);
  }
  
  public static void menuGestion() throws java.io.IOException {
    boolean salir = false;
    int opcion;
    do{
      System.out.println("\u000C");
      System.out.println("--------------------------");
      System.out.println("| >>> Menu de Gestion <<<|");
      System.out.println("--------------------------");
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
  
  public static void menuConsulta() throws java.io.IOException {
    boolean salir = false;
    int opcion;
    do{
      System.out.println("\u000C");
      System.out.println("--------------------------");
      System.out.println("| >>> Menu de Consulta <<<|");
      System.out.println("--------------------------");
      System.out.println("1. Transacciones de una cuenta");
      System.out.println("2. Tipo de cambio de compra");
      System.out.println("3. Tipo de cambio de venta");
      System.out.println("4. Saldo");
      System.out.println("5. Saldo (Dolares)");
      System.out.println("6. Estado de cuenta");
      System.out.println("7. Estado de cuenta (Dolares)");
      
      opcion = leerOpcion();
      switch(opcion) {
        case 1 -> TransaccionesCuenta();
        case 2 -> cambioCompra();
        case 3 -> cambioVenta();
        case 4 -> saldo();
        case 5 -> SaldoDolares();
        case 6 -> estadoCuenta();
        case 7 -> estadoCuentaDolares();
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
  public static void crearCliente() throws java.io.IOException {
    System.out.println("\u000C");
    System.out.print(">>> Registrar Cliente " );
    System.out.print("Nombre: " );
    String nombre = in.readLine();
    System.out.print("Apellido 1: " );
    String apellido1 = in.readLine();
    System.out.print("Apellido 2: " );
    String apellido2 = in.readLine();
    System.out.print("Identificación: " );
    int identificacion = Integer.parseInt(in.readLine());
    System.out.print("Telefono: " );
    int telefono = Integer.parseInt(in.readLine());
    System.out.print("Correo Electronico: " );
    String correo = in.readLine();
  }
  public static void crearCuenta() throws java.io.IOException {
    System.out.println("\u000C");
    System.out.print(">>> Crear Cuenta " );
    System.out.print("Identificación: " );
    int identificacion = Integer.parseInt(in.readLine());
    System.out.print("PIN: " );
    String pin = in.readLine();
    System.out.print("Confirme PIN: " );
    String confirmacionPin = in.readLine();
    System.out.print("Monto Inicial: " );
  }
  public static void cambiarPin() {
    System.out.println("\u000C");
    System.out.print(">>> Cambiar PIN " );
    System.out.print("Numero de cuenta: " );
    System.out.print("PIN actual de la cuenta: " );
    System.out.print("Nuevo PIN: " );
    System.out.print("Confirme el nuevo PIN: " );
  }
  public static void depositarColones() {
    System.out.println("\u000C");
    System.out.print(">>> Depositar " );
    System.out.print("Numero de cuenta: " );
    System.out.print("Monto a depositar: " );
    
  }
  public static void depositarDolares() {
    System.out.println("\u000C");
    System.out.print(">>> Depositar " );
    System.out.print("Numero de cuenta: " );
    System.out.print("Monto a depositar: " );
  }
  public static void retiroColones() {
    System.out.println("\u000C");
    System.out.print(">>> Retirar " );
    System.out.print("Numero de cuenta: " );
    System.out.print("Ingrese el PIN: " );
    System.out.print("Ingrese el codigo que recivió: " );
    System.out.print("Monto a Retirar: " );
  }
  public static void retiroDolares() {
    System.out.println("\u000C");
    System.out.print(">>> Retirar " );
    System.out.print("Numero de cuenta: " );
    System.out.print("Ingrese el PIN: " );
    System.out.print("Ingrese el codigo que recivió: " );
    System.out.print("Monto a Retirar: " );
  }
  public static void transferir() {
    System.out.println("\u000C");
    System.out.print(">>> Transferir " );
    System.out.print("Numero de cuenta de origen: " );
    System.out.print("Ingrese el PIN: " );
    System.out.print("Ingrese el codigo que recivió: " );
    System.out.print("Monto a Retirar: " );
    System.out.print("Numero de cuenta de Destino: " );
  }
  //Metodos de consulta
  public static void TransaccionesCuenta() {
  }
  public static void cambioCompra() {
  }
  public static void cambioVenta() {
  }
  public static void saldo() {
  }
  public static void SaldoDolares() {
  }
  public static void estadoCuenta() {
  }
  public static void estadoCuentaDolares() {
  }
}
