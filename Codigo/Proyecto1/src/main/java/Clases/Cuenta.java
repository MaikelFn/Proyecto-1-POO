/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
    
  private final int numeroCuenta;
  private final LocalDate fechaCreacion;
  private boolean estatus;  // Activa/Inactiva
  private double saldo;
  private String pinCifrado;  // Almacena el PIN cifrado
  private final ArrayList<Transaccion> transacciones;
  private final Comision gestionComisiones;  // Gestión de comisiones
  private int contadorTransacciones;  // Controla el número de transacciones

  private static final int LIMITE_TRANSACCIONES_GRATIS = 5;
  
  /**
   * Constructor para inicializar una cuenta bancaria.
   *
   * @param pNumeroCuenta Número de la cuenta.
   * @param pPin PIN de la cuenta (sin cifrar).
   * @param pSaldoInicial Saldo inicial de la cuenta.
   */
  public Cuenta(int pNumeroCuenta, String pPin, double pSaldoInicial) {
    this.numeroCuenta = pNumeroCuenta;
    this.pinCifrado = cifrarPin(pPin);
    this.saldo = pSaldoInicial;
    this.estatus = true;  // La cuenta comienza activa
    this.fechaCreacion = LocalDate.now();  // Fecha de creación
    this.transacciones = new ArrayList<>();
    this.gestionComisiones = new Comision();  // Nueva instancia de Comision
    this.contadorTransacciones = 0;
  }
  
  /**
   * Valida si el PIN ingresado es correcto.
   *
   * @param pPin PIN ingresado por el usuario.
   * @return true si el PIN es correcto; false en caso contrario.
   */
  public boolean validarPin(String pPin) {
    return cifrarPin(pPin).equals(pinCifrado);
  }
  
  /**
   * Cambia el PIN de la cuenta.
   *
   * @param pNuevoPin Nuevo PIN a establecer.
   */
  public void cambiarPin(String pNuevoPin) {
    this.pinCifrado = cifrarPin(pNuevoPin);
  }
  
  public void realizarDeposito(double pMonto) {}
  
  public boolean realizarRetiro(double pMonto) {}
  
  
  
  private String cifrarPin(String pPin) {}
  
  public double getSaldo() {
    return saldo;
  }

  public int getNumeroCuenta() {
    return numeroCuenta;
  }

  public List<Transaccion> getTransacciones() {
    return transacciones;
  }

  public boolean getEstatus() {
    return estatus;
  }
    
}
