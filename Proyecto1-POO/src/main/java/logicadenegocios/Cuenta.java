/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;
//import java.time.LocalDate;
import java.util.LinkedList;

/**
 *
 * @author Dillan, Maikel, Tayler
 */
@SuppressWarnings("all") //
public class Cuenta {
  private final int numCuenta;
  //private final LocalDate fechaCreacion;
  private final String estatus;
  private final int saldo;
  private final String pin;
  private final int idDueno;
  private final LinkedList<Transaccion> transacciones;
  
    /**
   * Método constructor de la clase cuenta
   *
   * @param pNumCuenta
   * @param pPin
   * @param pSaldo
   * @param pIdDueno
   * fecha y estatus son atributos autogenerados
   */
  public Cuenta(int pIdDueno,int pNumCuenta,String pPin,int pSaldo){
    idDueno = pIdDueno;
    numCuenta = pNumCuenta;
    saldo = pSaldo;
    pin = pPin;
    estatus = "activa";
    //fechaCreacion = LocalDate;
    transacciones = new LinkedList<>(); 
  }
  public int getIdDueno() {
    return idDueno;
  }
  public int getNumCuenta(){
    return numCuenta;
  }
  public String getEstatus(){
    return estatus;
  }
  public int getSaldo(){
    return saldo;
  }
  //public LocalDate getFechaCreacion(){
    //return fechaCreacion;
  //}
  public String getPin(){
    return pin;
  }
  public Transaccion getTransacciones() {
    return null;
  }
  
}
