/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Clases.Cliente;
import Clases.Banco;
import Clases.XMLWriter;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 *
 * @author Tayle
 */
public class RellenarDatosCuenta extends javax.swing.JFrame {

    private Cliente cliente;
    private final Banco banco;
    
    /**
     * Creates new form RellenarDatosCuenta
     */
    public RellenarDatosCuenta(Cliente cliente) {
        Banco banco = new Banco();
        banco.cargarClientes("clientes.xml");
        this.banco = banco;
        this.cliente = cliente;
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelPin = new javax.swing.JLabel();
        txtPin = new javax.swing.JPasswordField();
        txtMonto = new javax.swing.JTextField();
        LabelMonto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelPin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelPin.setForeground(new java.awt.Color(255, 255, 255));
        LabelPin.setText("Pin :");
        getContentPane().add(LabelPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        txtPin.setBackground(new java.awt.Color(0, 0, 51));
        txtPin.setForeground(new java.awt.Color(255, 255, 255));
        txtPin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtPin.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPinActionPerformed(evt);
            }
        });
        getContentPane().add(txtPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 120, -1));

        txtMonto.setBackground(new java.awt.Color(0, 0, 51));
        txtMonto.setForeground(new java.awt.Color(255, 255, 255));
        txtMonto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtMonto.setCaretColor(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 120, -1));

        LabelMonto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelMonto.setForeground(new java.awt.Color(255, 255, 255));
        LabelMonto.setText("Monto inicial :");
        getContentPane().add(LabelMonto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Crear");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, 80, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPinActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String idUsuario = cliente.getIdentificacion();
        
        // Buscar cliente
        Cliente clienteEncontrado = null;
        for (Cliente cliente : banco.getClientes()) {
            if (cliente.getIdentificacion().equals(idUsuario)) {
                clienteEncontrado = cliente;
                break;
            }
        }
        
        if (clienteEncontrado != null) {
            JOptionPane.showMessageDialog(this, "Cliente encontrado:\nNombre: " 
                + clienteEncontrado.getNombreCompleto() + "\nIdentificación: " 
                + clienteEncontrado.getIdentificacion());
            
            String pin = new String(txtPin.getPassword());
            if (pin.length() < 4 || pin.length() > 6) {
                JOptionPane.showMessageDialog(this, "El PIN debe tener entre 4 y 6 caracteres.");
                return;
            }
            
            try {
                double monto = Double.parseDouble(txtMonto.getText());
                if (monto <= 0) {
                    JOptionPane.showMessageDialog(this, "El monto debe ser mayor a cero.");
                    return;
                }
                
                String numeroCuenta = "CTA" + (int)(Math.random() * 10000);
                String estatusCuenta = "Activa";
                
                DecimalFormat df = new DecimalFormat("0.00");
                String saldoFormateado = df.format(monto);
                
                JOptionPane.showMessageDialog(this, 
                    "Se ha creado una nueva cuenta en el sistema, los datos de la cuenta son:\n" +
                    "Número de cuenta: " + numeroCuenta + "\n" +
                    "Estatus de la cuenta: " + estatusCuenta + "\n" +
                    "Saldo actual: " + saldoFormateado + "\n" +
                    "Nombre del dueño de la cuenta: " + clienteEncontrado.getNombreCompleto()
                );
                
                LocalDate fechaActual = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String fechaComoString = fechaActual.format(formatter);
                XMLWriter.agregarCuenta(idUsuario, numeroCuenta, fechaComoString, estatusCuenta, monto, pin, "clientes.xml");
                banco.cargarClientes("clientes.xml");
                MenuPrincipal menu = new MenuPrincipal(banco);
                menu.setVisible(true);
                this.dispose();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "El monto debe ser un número entero.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró un cliente con esa identificación.");
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
            java.util.logging.Logger.getLogger(RellenarDatosCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RellenarDatosCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RellenarDatosCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RellenarDatosCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Banco banco = new Banco();
                banco.cargarClientes("clilentes.xml");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelMonto;
    private javax.swing.JLabel LabelPin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JPasswordField txtPin;
    // End of variables declaration//GEN-END:variables
}
