package Clases;

import java.time.LocalDate;

/**
 * Clase que representa una transacción bancaria.
 */
public class Transaccion {
  // Atributos
  public static final String TIPO_DEPOSITO = "DEPOSITO";
  public static final String TIPO_RETIRO = "RETIRO";

  private final String tipoTransaccion;  // "DEPOSITO" o "RETIRO"
  private final double monto;
  private final LocalDate fecha;
  private final boolean tieneComision;

  /**
   * Constructor para inicializar una transacción.
   *
   * @param pTipoTransaccion El tipo de transacción (debe ser "DEPOSITO" o "RETIRO").
   * @param pMonto El monto de la transacción.
   * @param pTieneComision Indica si se aplicó una comisión.
   * @throws IllegalArgumentException si el tipo de transacción no es válido.
   */
  public Transaccion(String pTipoTransaccion, double pMonto, boolean pTieneComision) {
    if (!pTipoTransaccion.equals(TIPO_DEPOSITO) && !pTipoTransaccion.equals(TIPO_RETIRO)) {
      throw new IllegalArgumentException("Tipo de transacción inválido. Debe ser 'DEPOSITO' o 'RETIRO'.");
    }
    
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
