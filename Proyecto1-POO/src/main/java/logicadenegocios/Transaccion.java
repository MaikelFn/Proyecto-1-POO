/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicadenegocios;
//import java.time.LocalDate;

/**
 *
 * @author Dillan
 */
public class Transaccion {
  private final int cantidadComisiones;
  private final String tipoTransaccion;
  private final int monto;
  //private final LocalDate fecha;
  private final int comision;
  
//La fecha debe Autogenerarse
  public Transaccion(String pTipoTransaccion,int pMonto, int pComision){
    tipoTransaccion = pTipoTransaccion;
    monto = pMonto;
    //fecha = LocalDate
    comision = pComision;
    cantidadComisiones = 0;
  }
  //Metodos Accesores
  public String getTipoTransaccion() {
    return tipoTransaccion;
  }
  public int getMonto() {
    return monto;
  }
  //public LocalDate getFecha() {
    //return fecha;
  //}
  public int getComision() {
   return comision;
  }
  public int getCantidadComisiones() {
    return cantidadComisiones;
  }
}
