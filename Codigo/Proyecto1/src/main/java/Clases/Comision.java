/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


/**
 * Clase que gestiona las comisiones generadas por depósitos y retiros.
 */
public class Comision {

  private double totalComisiones;
  private double comisionesRetiros;
  private double comisionesDepositos;

  /**
   * Calcula la comisión correspondiente según el tipo de transacción.
   *
   * @param pMonto Monto de la transacción.
   * @param pTipoTransaccion Tipo de transacción ("D" para depósito, "R" para retiro).
   * @return El monto de la comisión calculada.
   */
  public double calcularComision(double pMonto, String pTipoTransaccion) {
    double total = pMonto * 0.02;

    if (pTipoTransaccion.equals("D")) {
      comisionesDepositos += total;
    } else if (pTipoTransaccion.equals("R")) {
      comisionesRetiros += total;
    }

    totalComisiones += total;
    return total;
  }

  /**
   * Obtiene el total de comisiones generadas.
   *
   * @return El total de comisiones.
   */
  public double getTotalComisiones() {
    return totalComisiones;
  }

  /**
   * Obtiene el total de comisiones por retiros.
   *
   * @return El total de comisiones por retiros.
   */
  public double getComisionesRetiros() {
    return comisionesRetiros;
  }

  /**
   * Obtiene el total de comisiones por depósitos.
   *
   * @return El total de comisiones por depósitos.
   */
  public double getComisionesDepositos() {
    return comisionesDepositos;
  }
}
