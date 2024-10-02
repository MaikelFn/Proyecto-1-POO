/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1.poo.logicadenegocios;

/**
 *
 * @author Dillan, Maikel, Tayler
 */
public class Cuenta {
  private final int numCuenta;
  private final String estatus;
  private final int saldo;
  private final int idDueno;
  
    /**
   * Método constructor de la clase cuenta
   *
   * @param pNumCuenta
   * @param pEstatus
   * @param pSaldo
   * @param pIdDueno
   */
  public Cuenta(int pIdDueno,int pNumCuenta,String pEstatus,int pSaldo){
    idDueno = pIdDueno;
    numCuenta = pNumCuenta;
    estatus = pEstatus;
    saldo = pSaldo;
  }
    public int getIdDueno() {
    return idDueno;
  }
    
}
