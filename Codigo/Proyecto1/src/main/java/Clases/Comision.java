/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Estudiante
 */
public class Comision {
  private double totalComisiones;
  private double comisionesRetiros;
  private double comisionesDepositos;
    
  public double calcularComision(double pMonto, String pTipoTransaccion){
    double Total;
    Total= pMonto*0.02;
    if(pTipoTransaccion.equals("D")){
      comisionesDepositos+=Total;
    }else if(pTipoTransaccion.equals("R")){
      comisionesRetiros+=Total;
    }
    totalComisiones+=Total;
    return Total;
  }
  public double getTotalComisiones(){
    return totalComisiones;
  }
  public double getComisionesRetiros(){
    return comisionesRetiros;
  }
  public double getComisionesDepositos(){
    return comisionesDepositos;
  }
}
