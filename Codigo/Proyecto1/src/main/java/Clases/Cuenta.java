package Clases;

import java.time.LocalDate;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una cuenta bancaria.
 */
public class Cuenta {

  private final String numeroCuenta;
  private LocalDate fechaCreacion;
  private boolean estatus;  // Activa/Inactiva
  private double saldo;
  private String pinCifrado;  // Almacena el PIN cifrado
  private final ArrayList<Transaccion> transacciones;
  private final Comision gestionComisiones;  // Gestión de comisiones
  private int contadorTransacciones;  // Controla el número de transacciones
  private final Cliente cliente;

  private static final int LIMITE_TRANSACCIONES_GRATIS = 5;

  /**
   * Constructor para inicializar una cuenta bancaria.
   *
   * @param pNumeroCuenta Número de la cuenta.
   * @param pPin PIN de la cuenta (sin cifrar).
   * @param pSaldoInicial Saldo inicial de la cuenta.
   * @param cliente Cliente dueño de la cuenta.
   */
  public Cuenta(String pNumeroCuenta, String pPin, double pSaldoInicial, Cliente cliente) {
    this.numeroCuenta = pNumeroCuenta;
    this.pinCifrado = cifrarPin(pPin);
    this.saldo = pSaldoInicial;
    this.estatus = true;  // La cuenta comienza activa
    this.fechaCreacion = LocalDate.now();  // Fecha de creación
    this.transacciones = new ArrayList<>();
    this.gestionComisiones = new Comision();  // Nueva instancia de Comision
    this.contadorTransacciones = 0;
    this.cliente = cliente;
  }

  /**
   * Valida si el PIN ingresado es correcto.
   *
   * @param pPin PIN ingresado por el usuario.
   * @return true si el PIN es correcto; false en caso contrario.
   */
  public boolean validarPin(String pPin) {
    return cifrarPin(pPin).equalsIgnoreCase(pinCifrado);
  }

  /**
   * Cambia el PIN de la cuenta.
   *
   * @param pNuevoPin Nuevo PIN a establecer.
   */
  public void cambiarPin(String pNuevoPin) {
    this.pinCifrado = cifrarPin(pNuevoPin);
    System.out.println("El PIN ha sido cambiado con éxito.");
  }
  
  /**
   * Realiza un depósito en la cuenta.
   *
   * @param pMonto Monto a depositar.
   */
  public void realizarDeposito(double pMonto) {
    if (pMonto <= 0) {
      System.out.println("El monto debe ser positivo.");
      return;
    }

    boolean tieneComision = contadorTransacciones >= LIMITE_TRANSACCIONES_GRATIS;
    double comision = tieneComision ? gestionComisiones.calcularComision(pMonto, "D") : 0;

    saldo += pMonto - comision;
    agregarTransaccion("DEPOSITO", pMonto, tieneComision);

    System.out.println("Depósito exitoso. Nuevo saldo: " + saldo + " colones.");
    XMLWriter.reemplazarSaldo(cliente.getIdentificacion(), numeroCuenta, saldo, "clientes.xml");
  }

  /**
   * Realiza un retiro si hay fondos suficientes.
   *
   * @param pMonto Monto a retirar.
   * @return true si el retiro fue exitoso; false en caso contrario.
   */
  public boolean realizarRetiro(double pMonto) {
    if (pMonto <= 0) {
      System.out.println("El monto debe ser positivo.");
      return false;
    }

    boolean tieneComision = contadorTransacciones >= LIMITE_TRANSACCIONES_GRATIS;
    double comision = tieneComision ? gestionComisiones.calcularComision(pMonto, "R") : 0;

    if (saldo < pMonto + comision) {
      System.out.println("Fondos insuficientes.");
      return false;
    }

    saldo -= pMonto + comision;
    agregarTransaccion("RETIRO", pMonto, tieneComision);
    
    System.out.println("Retiro exitoso. Nuevo saldo: " + saldo + " colones.");
    XMLWriter.reemplazarSaldo(cliente.getIdentificacion(), numeroCuenta, saldo, "clientes.xml");

    return true;
  }

  /**
   * Elimina la cuenta marcándola como inactiva.
   */
  public void desactivarCuenta() {
    XMLWriter.reemplazarEstado(this.getCliente().getIdentificacion(), this.getNumeroCuenta(), "Inactiva", "clientes.xml");
    this.estatus = false;
    System.out.println("La cuenta ha sido eliminada.");
  }

  /**
   * Agrega una nueva transacción a la lista y aumenta el contador.
   *
   * @param pTipo Tipo de transacción.
   * @param pMonto Monto de la transacción.
   * @param pTieneComision Indica si la transacción tiene comisión.
   */
  private void agregarTransaccion(String pTipo, double pMonto, boolean pTieneComision) {
    Transaccion nuevaTransaccion = new Transaccion(pTipo, pMonto, pTieneComision);
    transacciones.add(nuevaTransaccion);
    contadorTransacciones++;
  }

  /**
   * Cifra el PIN utilizando SHA-256.
   *
   * @param pPin PIN sin cifrar.
   * @return PIN cifrado en formato hexadecimal.
   */
  private String cifrarPin(String pPin) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(pPin.getBytes());
      StringBuilder hexString = new StringBuilder();

      for (byte b : hash) {
        String hex = Integer.toHexString(0xff & b);
        if (hex.length() == 1) {
          hexString.append('0');
        }
        hexString.append(hex);
      }

      return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException("Error al cifrar el PIN", e);
    }
  }

  
  // Getters

  public double getSaldo() {
    return saldo;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }
  
  public String getPin(){
      return pinCifrado;
  }

  public List<Transaccion> getTransacciones() {
    return transacciones;
  }

  public boolean getEstatus() {
    return estatus;
  }
  
  public LocalDate getFechaCreacion(){
    return fechaCreacion;
  }
  
  public Cliente getCliente() {
    return cliente;
  }
  
  //Setters
  public void setEstatus(boolean status){
    this.estatus = status;
  }
  
  public void setFechaCreacion(LocalDate fecha) {
    this.fechaCreacion = fecha;
  }
}
