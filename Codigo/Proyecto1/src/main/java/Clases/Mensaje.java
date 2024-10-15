package Clases;

/**
 * Clase que representa un mensaje enviado al usuario para validar transacciones.
 */
public class Mensaje {

  private final String numeroTelefono;
  private final String palabra;

  /**
   * Constructor que inicializa un mensaje con un número de teléfono y una palabra.
   *
   * @param pNumero Número de teléfono del destinatario.
   * @param pPalabra Palabra secreta enviada en el mensaje.
   */
  public Mensaje(String pNumero, String pPalabra) {
    this.numeroTelefono = pNumero;
    this.palabra = pPalabra;
  }

  /**
   * Simula el envío del mensaje (implementación pendiente).
   */
  public void enviar() {
    // Implementación del envío del mensaje.
    System.out.println("Mensaje enviado a: " + numeroTelefono);
  }

  /**
   * Valida si la palabra ingresada por el usuario coincide con la enviada.
   *
   * @param pPalabraIngresada Palabra ingresada por el usuario.
   * @return true si la palabra coincide; false en caso contrario.
   */
  public boolean validarPalabra(String pPalabraIngresada) {
    return pPalabraIngresada.equals(this.palabra);
  }
}