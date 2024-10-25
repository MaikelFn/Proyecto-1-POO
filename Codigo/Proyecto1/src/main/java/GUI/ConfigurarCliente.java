/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import javax.swing.JOptionPane;
import Clases.Cliente;
import Clases.Banco;
import Clases.XMLWriter;
/**
 *
 * @author Tayle
 */
public class ConfigurarCliente extends javax.swing.JFrame {

    private Cliente cliente;
    private InterfazCliente ventana;
    /**
     * Creates new form ConfigurarCuenta
     */
    public ConfigurarCliente(Cliente cliente, InterfazCliente interfaz) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cliente = cliente;
        this.ventana = interfaz;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Imagen = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        CambiarCorreo = new javax.swing.JButton();
        CambiarTelefono = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cogs.png"))); // NOI18N
        getContentPane().add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        Volver.setBackground(new java.awt.Color(0, 0, 51));
        Volver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        CambiarCorreo.setBackground(new java.awt.Color(0, 0, 51));
        CambiarCorreo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CambiarCorreo.setForeground(new java.awt.Color(255, 255, 255));
        CambiarCorreo.setText("Cambiar correo");
        CambiarCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarCorreoActionPerformed(evt);
            }
        });
        getContentPane().add(CambiarCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, -1, -1));

        CambiarTelefono.setBackground(new java.awt.Color(0, 0, 51));
        CambiarTelefono.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        CambiarTelefono.setForeground(new java.awt.Color(255, 255, 255));
        CambiarTelefono.setText("Cambiar teléfono");
        CambiarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarTelefonoActionPerformed(evt);
            }
        });
        getContentPane().add(CambiarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        Fondo.setPreferredSize(new java.awt.Dimension(300, 400));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CambiarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarTelefonoActionPerformed
        String nuevoTelefono;
        boolean telefonoValido = false;

        while (!telefonoValido) {
            nuevoTelefono = JOptionPane.showInputDialog(null, "Ingrese el nuevo número de teléfono:");

            if (nuevoTelefono == null) {
                return;
            }

            if (nuevoTelefono.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo de teléfono no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                continue; 
            }

            if (nuevoTelefono.length() != 8 || !nuevoTelefono.matches("\\d{8}")) {
                JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            telefonoValido = true;
            cliente.setTelefono(nuevoTelefono);
            XMLWriter.reemplazarTelefono(cliente.getIdentificacion(), nuevoTelefono, "clientes.xml");
            JOptionPane.showMessageDialog(null, "Teléfono cambiado con éxito.");
        }
    }//GEN-LAST:event_CambiarTelefonoActionPerformed

    private void CambiarCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarCorreoActionPerformed
         String nuevoCorreo;
         boolean correoValido = false;

        while (!correoValido) { 
            nuevoCorreo = JOptionPane.showInputDialog(null, "Ingrese el nuevo correo electrónico:");

            if (nuevoCorreo == null) {
                return;
            }

            if (nuevoCorreo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El campo de correo no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            if (!nuevoCorreo.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
                JOptionPane.showMessageDialog(null, "Formato de correo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            correoValido = true;
            cliente.setCorreo(nuevoCorreo);
            XMLWriter.reemplazarCorreo(cliente.getIdentificacion(), nuevoCorreo, "clientes.xml");
            JOptionPane.showMessageDialog(null, "Correo cambiado con éxito.");
        }
    }//GEN-LAST:event_CambiarCorreoActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConfigurarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConfigurarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConfigurarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigurarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Banco banco = new Banco();
                banco.cargarClientes("clientex.xml");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CambiarCorreo;
    private javax.swing.JButton CambiarTelefono;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton Volver;
    // End of variables declaration//GEN-END:variables
}