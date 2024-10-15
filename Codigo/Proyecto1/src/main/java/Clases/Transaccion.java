/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.LocalDate;

/**
 * Clase que representa una transacción bancaria.
 */
public class Transaccion {
  // Atributos
  private final String tipoTransaccion;  // "DEPOSITO" o "RETIRO"
  private final double monto;
  private final LocalDate fecha;
  private final boolean tieneComision;

  /**
   * Constructor para inicializar una transacción.
   *
   * @param pTipoTransaccion El tipo de transacción ("DEPOSITO" o "RETIRO").
   * @param pMonto El monto de la transacción.
   * @param pTieneComision Indica si se aplicó una comisión.
   */
  public Transaccion(String pTipoTransaccion, double pMonto, boolean pTieneComision) {
    this.tipoTransaccion = pTipoTransaccion;
    this.monto = pMonto;
    this.fecha = LocalDate.now();  // Fecha de creación automática
    this.tieneComision = pTieneComision;
  }

  // Getters
  public String getTipoTransaccion() {
    return tipoTransaccion;
  }

  public double getMonto() {
    return monto;
  }

  public LocalDate getFecha() {
    return fecha;
  }

  public boolean tieneComision() {
    return tieneComision;
  }

  /**
   * Método para obtener los detalles de la transacción en formato String.
   *
   * @return Cadena con el detalle completo de la transacción.
   */
  public String obtenerDetalle() {
    String estadoComision = tieneComision ? "Con comisión" : "Sin comisión";
    return "Transacción: " + tipoTransaccion + "\n" +
           "Monto: " + monto + " colones\n" +
           "Fecha: " + fecha + "\n" +
           "Estado: " + estadoComision;
  }
}

