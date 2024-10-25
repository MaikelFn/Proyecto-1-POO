package Clases;

import java.security.SecureRandom;

/**
 * Clase que genera contraseñas aleatorias de 7 caracteres alfabéticos.
 */
public class GeneradorContraseña {

  private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  /**
   * Genera una contraseña aleatoria de 7 caracteres alfabéticos.
   *
   * @return Una cadena de 7 caracteres alfabéticos.
   */
  public static String generarContraseña() {
    SecureRandom random = new SecureRandom();
    StringBuilder contraseña = new StringBuilder(7);

    // Generar la contraseña seleccionando aleatoriamente 7 caracteres
    for (int i = 0; i < 7; i++) {
      int index = random.nextInt(CARACTERES.length());
      contraseña.append(CARACTERES.charAt(index));
    }

    return contraseña.toString();
  }
}
