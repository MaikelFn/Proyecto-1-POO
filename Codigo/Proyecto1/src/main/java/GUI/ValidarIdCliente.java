/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Clases.Cliente;
import Clases.Banco;
import javax.swing.JOptionPane;

/**
 *
 * @author Tayle
 */
public class ValidarIdCliente extends javax.swing.JFrame {

    private Cliente clienteAutenticado;
    private final MenuPrincipal ventana;
    private Banco banco;
    /**
     * Creates new form ValidarIdCliente
     */
    public ValidarIdCliente(MenuPrincipal menuPrincipal) {
        initComponents();
        this.ventana = menuPrincipal;
        Banco banco = new Banco();
        banco.cargarClientes("clientes.xml");
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

        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        Cancelar = new javax.swing.JButton();
        Verificar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Identificación :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        getContentPane().add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 190, 140, -1));

        Cancelar.setText("Cancelar");
        Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarActionPerformed(evt);
            }
        });
        getContentPane().add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Verificar.setText("Verificar");
        Verificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarActionPerformed(evt);
            }
        });
        getContentPane().add(Verificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 290));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public Cliente getClienteAutenticado() {
        return clienteAutenticado;
    }
    
    public String getTexto() {
        String texto = txtId.getText();
        return texto;
    }
    
    public void vaciarTexto() {
        txtId.setText("");
    }
    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_CancelarActionPerformed

    private void VerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarActionPerformed
        String idUsuario = txtId.getText();
        if (idUsuario.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese su identificación.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else {
            Cliente clienteEncontrado = null;

            for (Cliente cliente : banco.getClientes()) {
                if (cliente.getIdentificacion().equals(idUsuario)) {
                    clienteEncontrado = cliente;
                    break;
                }
            }
            if (clienteEncontrado != null) {
                clienteAutenticado = clienteEncontrado;
                this.setVisible(false);
                RellenarDatosCuenta redireccionar = new RellenarDatosCuenta(clienteAutenticado);
                redireccionar.setVisible(true);
                }
            else {
            JOptionPane.showMessageDialog(this, "Cliente no encontrado o no registrado", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_VerificarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

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
            java.util.logging.Logger.getLogger(ValidarIdCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ValidarIdCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ValidarIdCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ValidarIdCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Banco banco = new Banco();
                banco.cargarClientes("clientes.xml");
                MenuPrincipal menu = new MenuPrincipal(banco);
                new ValidarIdCliente(menu).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancelar;
    private javax.swing.JButton Verificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
