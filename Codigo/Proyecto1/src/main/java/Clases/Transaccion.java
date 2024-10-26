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
  
  /**
 * Obtiene el tipo de transacción.
 *
 * @return Una cadena que representa el tipo de transacción (DEPOSITO o RETIRO).
 */
  public String getTipoTransaccion() {
    return tipoTransaccion;
  }

  /**
 * Obtiene el monto de la transacción.
 *
 * @return El monto de la transacción como un valor de tipo double.
 */
  public double getMonto() {
    return monto;
  }

  /**
 * Obtiene la fecha de la transacción.
 *
 * @return La fecha de la transacción como un objeto LocalDate.
 */
  public LocalDate getFecha() {
    return fecha;
  }

  /**
 * Indica si la transacción tiene una comisión asociada.
 *
 * @return Verdadero si la transacción tiene una comisión, falso en caso contrario.
 */
  public boolean tieneComision() {
    return tieneComision;
  }
  
  /**
 * Obtiene los detalles de la transacción como una cadena de texto.
 *
 * @return Una representación en formato de texto que incluye el tipo de transacción, 
 *         monto, fecha y estado de la comisión.
 */
   public String obtenerDetalle() {
    String estadoComision = tieneComision ? "Con comisión" : "Sin comisión";
    return "Transacción: " + tipoTransaccion + "\n" +
           "Monto: " + monto + " colones\n" +
           "Fecha: " + fecha + "\n" +
           "Estado: " + estadoComision;
  }
}
