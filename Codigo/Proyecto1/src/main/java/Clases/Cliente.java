package Clases;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Clase que representa un cliente del banco.
 */
public class Cliente {

  private final String nombreCompleto;
  private final String identificacion;
  private String telefono;
  private String correo;
  private final ArrayList<Cuenta> cuentas;

  private static final String REGEX_TELEFONO = "\\d{8}";  // Valida un número de 8 dígitos
  private static final String REGEX_CORREO = "^[\\w-\\.]+@[\\w-]+\\.[a-z]{2,3}$";  // Formato de correo válido

  /**
   * Constructor para inicializar un cliente.
   *
   * @param pNombreCompleto Nombre completo del cliente.
   * @param pIdentificacion Identificación del cliente.
   * @param pTelefono Número de teléfono del cliente.
   * @param pCorreo Correo electrónico del cliente.
   */
  public Cliente(String pNombreCompleto, String pIdentificacion, String pTelefono, String pCorreo) {
    if (!validarTelefono(pTelefono)) {
      throw new IllegalArgumentException("Número de teléfono inválido.");
    }
    if (!validarCorreo(pCorreo)) {
      throw new IllegalArgumentException("Correo electrónico inválido.");
    }

    this.nombreCompleto = pNombreCompleto;
    this.identificacion = pIdentificacion;
    this.telefono = pTelefono;
    this.correo = pCorreo;
    this.cuentas = new ArrayList<>();
  }

  /**
   * Cambia el número de teléfono del cliente.
   *
   * @param pNuevoTelefono Nuevo número de teléfono.
   */
  public void cambiarTelefono(String pNuevoTelefono) {
    if (validarTelefono(pNuevoTelefono)) {
      this.telefono = pNuevoTelefono;
      System.out.println("Teléfono cambiado con éxito.");
    } else {
      System.out.println("Número de teléfono inválido.");
    }
  }

  /**
   * Cambia el correo electrónico del cliente.
   *
   * @param pNuevoCorreo Nuevo correo electrónico.
   */
  public void cambiarCorreo(String pNuevoCorreo) {
    if (validarCorreo(pNuevoCorreo)) {
      this.correo = pNuevoCorreo;
      System.out.println("Correo cambiado con éxito.");
    } else {
      System.out.println("Correo electrónico inválido.");
    }
  }

  /**
   * Agrega una nueva cuenta al cliente.
   *
   * @param pCuenta Cuenta a agregar.
   */
  public void agregarCuenta(Cuenta pCuenta) {
    this.cuentas.add(pCuenta);

  }

  /**
   * Obtiene la lista de cuentas del cliente.
   *
   * @return Lista de cuentas.
   */
  public List<Cuenta> getCuentas() {
    return cuentas;
  }

  /**
   * Valida si un número de teléfono es correcto.
   *
   * @param pTelefono Número de teléfono a validar.
   * @return true si es válido; false en caso contrario.
   */
  private boolean validarTelefono(String pTelefono) {
    return Pattern.matches(REGEX_TELEFONO, pTelefono);
  }

  /**
   * Valida si un correo electrónico es correcto.
   *
   * @param pCorreo Correo a validar.
   * @return true si es válido; false en caso contrario.
   */
  private boolean validarCorreo(String pCorreo) {
    return Pattern.matches(REGEX_CORREO, pCorreo);
  }

  /**
 * Establece la dirección de correo electrónico del cliente.
 *
 * @param pCorreo la nueva dirección de correo electrónico a establecer.
 */
  public void setCorreo(String pCorreo) {
    this.correo = pCorreo;
  }
  
  /**
 * Establece el número de teléfono del cliente.
 *
 * @param pTelefono el nuevo número de teléfono a establecer.
 */
  public void setTelefono(String pTelefono) {
    this.telefono = pTelefono;
  }
  
  // Getters

  /**
 * Obtiene el nombre completo del cliente.
 *
 * @return el nombre completo del cliente.
 */
  public String getNombreCompleto() {
    return nombreCompleto;
  }

  /**
 * Obtiene la identificación del cliente.
 *
 * @return la identificación del cliente.
 */
  public String getIdentificacion() {
    return identificacion;
  }

  /**
 * Obtiene el número de teléfono del cliente.
 *
 * @return el número de teléfono del cliente.
 */
  public String getTelefono() {
    return telefono;
  }

  /**
 * Obtiene la dirección de correo electrónico del cliente.
 *
 * @return la dirección de correo electrónico del cliente.
 */
  public String getCorreo() {
    return correo;
  }
}
