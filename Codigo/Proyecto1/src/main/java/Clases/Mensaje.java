package Clases;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

import java.util.Properties;

/**
 * Clase que envía un mensaje de verificación por correo electrónico.
 */
public class Mensaje {

  private final String correoDestino;
  private final String asunto;
  private final String contenido;

  // Constantes para la autenticación
  private static final String CORREO_REMITENTE = "bancoprofit@gmail.com";
  private static final String CONTRASENA = "w z a i o c r o u m h pl m i z"; // Considera almacenar esto de forma segura

  /**
   * Constructor para inicializar el mensaje.
   *
   * @param pCorreoDestino Correo electrónico del destinatario.
   * @param pAsunto Asunto del correo.
   * @param pContenido Contenido del mensaje.
   */
  public Mensaje(String pCorreoDestino, String pAsunto, String pContenido) {
    this.correoDestino = pCorreoDestino;
    this.asunto = pAsunto;
    this.contenido = pContenido;
  }

  /**
   * Envía el correo electrónico utilizando el servidor de correo.
   */
  public void enviar() {
    // Configuración del servidor SMTP
    Properties propiedades = new Properties();
    propiedades.put("mail.smtp.host", "smtp.gmail.com");
    propiedades.put("mail.smtp.port", "587");
    propiedades.put("mail.smtp.auth", "true");
    propiedades.put("mail.smtp.starttls.enable", "true");

    // Autenticación del correo remitente
    Session sesion = Session.getInstance(propiedades, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(CORREO_REMITENTE, CONTRASENA);
      }
    });

    try {
      // Creación del mensaje
      Message mensaje = new MimeMessage(sesion);
      mensaje.setFrom(new InternetAddress(CORREO_REMITENTE));
      mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(correoDestino));
      mensaje.setSubject(asunto);
      mensaje.setText(contenido);

      // Envío del mensaje
      Transport.send(mensaje);
      System.out.println("Correo enviado exitosamente a " + correoDestino);
    } catch (MessagingException e) {
      System.err.println("Error al enviar el correo: " + e.getMessage());
    }
  }
}
