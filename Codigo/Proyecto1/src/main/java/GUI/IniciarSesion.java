/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Banco;
import Clases.Cliente;
import javax.swing.JOptionPane;
/**
 *
 * @author Tayle
 */
public class IniciarSesion extends javax.swing.JFrame {

    private final MenuPrincipal menuPrincipal;
    private Cliente clienteAutenticado;

    public IniciarSesion(MenuPrincipal menuPrincipal) {
        initComponents();  // Esta es generada automáticamente por NetBeans
        this.setLocationRelativeTo(null);
        this.menuPrincipal = menuPrincipal;
    }                          
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Volver = new javax.swing.JButton();
        LabelNombre = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        txtidentificacion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Volver.setBackground(new java.awt.Color(0, 0, 51));
        Volver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, -1));

        LabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombre.setText("Identificacion :");
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciarsesion.png"))); // NOI18N
        getContentPane().add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 210, 230));

        txtidentificacion.setBackground(new java.awt.Color(0, 0, 102));
        txtidentificacion.setForeground(new java.awt.Color(255, 255, 255));
        txtidentificacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(txtidentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 140, 20));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar sesión");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cliente getClienteAutenticado() {
        return clienteAutenticado;
    }
    
    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose();
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Banco banco = new Banco();
        String idUsuario = txtidentificacion.getText();
        banco.cargarClientes("clientes.xml");

        if (idUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su identificación.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteEncontrado = null;

        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getIdentificacion().equals(idUsuario)) {
                clienteEncontrado = cliente;
                break;
            }
        }

         if (clienteEncontrado != null) {
            clienteAutenticado = clienteEncontrado; // Asignar el cliente autenticado
            JOptionPane.showMessageDialog(this, "Bienvenido, " + clienteAutenticado.getNombreCompleto(), "Inicio de Sesión", JOptionPane.INFORMATION_MESSAGE);
            new InterfazCliente(banco, clienteAutenticado, idUsuario).setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado o no registrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IniciarSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Banco banco = new Banco();
                banco.cargarClientes("clientes.xml");
                MenuPrincipal menuPrincipal = new MenuPrincipal(banco);
                IniciarSesion iniciarSesion = new IniciarSesion(menuPrincipal);
                iniciarSesion.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JButton Volver;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField txtidentificacion;
    // End of variables declaration//GEN-END:variables
}
