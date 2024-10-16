/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Banco;
/**
 *
 * @author Tayle
 */
public class IniciarSesion extends javax.swing.JFrame {

       private MenuPrincipal menuPrincipal;
    /**
     * Creates new form IniciarSesion
     */
    public IniciarSesion(MenuPrincipal menuPrincipal) {
        initComponents();
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
        LabelContraseña = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        contraseña = new javax.swing.JPasswordField();
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
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        LabelContraseña.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelContraseña.setForeground(new java.awt.Color(255, 255, 255));
        LabelContraseña.setText("Contraseña :");
        getContentPane().add(LabelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, -1, -1));

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/iniciarsesion.png"))); // NOI18N
        getContentPane().add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 210, 230));

        nombre.setBackground(new java.awt.Color(0, 0, 102));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 20));

        contraseña.setBackground(new java.awt.Color(0, 0, 102));
        contraseña.setForeground(new java.awt.Color(255, 255, 255));
        contraseña.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 140, 20));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Iniciar sesión");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, -1));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose(); 
        menuPrincipal.setVisible(true);
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
                MenuPrincipal menuPrincipal = new MenuPrincipal(banco); // Pasar el banco al MenuPrincipal
                IniciarSesion iniciarSesion = new IniciarSesion(menuPrincipal);
                iniciarSesion.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel LabelContraseña;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JButton Volver;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField nombre;
    // End of variables declaration//GEN-END:variables
}
