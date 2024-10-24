/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import javax.swing.JOptionPane;
import Clases.XMLWriter;
import Clases.Banco;
import Clases.Cliente;
/**
 *
 * @author Tayle
 */
public class RegistrarCliente extends javax.swing.JFrame {

    private final MenuPrincipal menuPrincipal; // Mantener referencia a la ventana anterior
    private final Banco banco;
      
    public RegistrarCliente(MenuPrincipal menuPrincipal, Banco banco) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.menuPrincipal = menuPrincipal;
        this.banco = banco;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelIcono = new javax.swing.JLabel();
        LabelNombre = new javax.swing.JLabel();
        LabelContrasena = new javax.swing.JLabel();
        LabelIdentificacion = new javax.swing.JLabel();
        LabelCorreo = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        correo = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        Volver = new javax.swing.JButton();
        Registrar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Icono.png"))); // NOI18N
        getContentPane().add(LabelIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 200, 200));

        LabelNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        LabelNombre.setText("Nombre :");
        getContentPane().add(LabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        LabelContrasena.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelContrasena.setForeground(new java.awt.Color(255, 255, 255));
        LabelContrasena.setText("Correo :");
        getContentPane().add(LabelContrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, -1));

        LabelIdentificacion.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelIdentificacion.setForeground(new java.awt.Color(255, 255, 255));
        LabelIdentificacion.setText("Identificación :");
        getContentPane().add(LabelIdentificacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, -1));

        LabelCorreo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        LabelCorreo.setText("Telefono :");
        getContentPane().add(LabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, -1));

        nombre.setBackground(new java.awt.Color(0, 0, 102));
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        nombre.setCaretColor(new java.awt.Color(255, 255, 255));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 150, -1));

        id.setBackground(new java.awt.Color(0, 0, 102));
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        id.setCaretColor(new java.awt.Color(242, 242, 242));
        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 150, -1));

        correo.setBackground(new java.awt.Color(0, 0, 102));
        correo.setForeground(new java.awt.Color(255, 255, 255));
        correo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        correo.setCaretColor(new java.awt.Color(255, 255, 255));
        correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                correoActionPerformed(evt);
            }
        });
        getContentPane().add(correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 150, -1));

        telefono.setBackground(new java.awt.Color(0, 0, 102));
        telefono.setForeground(new java.awt.Color(255, 255, 255));
        telefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 150, 20));

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

        Registrar.setBackground(new java.awt.Color(0, 0, 51));
        Registrar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Registrar.setForeground(new java.awt.Color(255, 255, 255));
        Registrar.setText("Registrar cliente");
        Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegistrarActionPerformed(evt);
            }
        });
        getContentPane().add(Registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, -1, 20));

        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_correoActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        this.dispose(); 
        menuPrincipal.setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void RegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegistrarActionPerformed
        if (nombre.getText().isEmpty() || 
            telefono.getText().isEmpty() || 
            correo.getText().isEmpty() || 
            id.getText().isEmpty()) {
    
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos.", "Error", JOptionPane.ERROR_MESSAGE);
        
        if (telefono.getText().length() != 8) {
            JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 8 dígitos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        if (!correo.getText().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Formato de correo inválido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        } else {
            String nombreUsuario = nombre.getText();
            String telefonoUsuario = telefono.getText();
            String correoUsuario = correo.getText();
            String idUsuario = id.getText();
            
            boolean clienteExiste = false;
            for (Cliente cliente : banco.getClientes()) {
                if (cliente.getIdentificacion().equalsIgnoreCase(idUsuario)) {
                    clienteExiste = true;
                    break;
                }
            }
            
            if (clienteExiste) {
                JOptionPane.showMessageDialog(null, "El cliente ya existe.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                XMLWriter.agregarCliente(nombreUsuario, idUsuario, telefonoUsuario, correoUsuario, "clientes.xml");
                banco.cargarClientes("clientes.xml");
                JOptionPane.showMessageDialog(null, "Se ha creado un nuevo cliente en el sistema.\n" +
                                                    "Nombre completo: " + nombreUsuario + "\n" +
                                                    "Identificación: " + idUsuario + "\n" +
                                                    "Número de teléfono: " + telefonoUsuario + "\n" +
                                                    "Dirección de correo electrónico: " + correoUsuario, 
                                                    "Cliente Registrado", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                menuPrincipal.setVisible(true);
            }
        }
    }//GEN-LAST:event_RegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Banco banco = new Banco(); // Inicializar el banco
            banco.cargarClientes("clientes.xml"); // Cargar clientes desde XML
            MenuPrincipal menuPrincipal = new MenuPrincipal(banco); // Pasar el banco al MenuPrincipal
            menuPrincipal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelContrasena;
    private javax.swing.JLabel LabelCorreo;
    private javax.swing.JLabel LabelIcono;
    private javax.swing.JLabel LabelIdentificacion;
    private javax.swing.JLabel LabelNombre;
    private javax.swing.JButton Registrar;
    private javax.swing.JButton Volver;
    private javax.swing.JTextField correo;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField telefono;
    // End of variables declaration//GEN-END:variables
}
