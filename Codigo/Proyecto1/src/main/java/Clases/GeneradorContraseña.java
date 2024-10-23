/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.security.SecureRandom;

public class GeneradorContraseña {

    private static final String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    /**
     * Método que genera una contraseña aleatoria de 7 caracteres.
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
