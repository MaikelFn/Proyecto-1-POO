/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Clases.Cuenta;
import Clases.Transaccion;
import java.awt.FlowLayout;
import javax.swing.JLabel;
/**
 *
 * @author Maikel
 */
public class ConsultarTransacciones extends javax.swing.JFrame {

    private final Cuenta cuenta;
    private final InterfazInfoCuenta interfaz;
    /**
     * Creates new form ConsulartTrasacciones
     */
    public ConsultarTransacciones(Cuenta cuenta, InterfazInfoCuenta interfaz) {
        initComponents();
        this.cuenta = cuenta;
        this.interfaz = interfaz;
        mostrarTransacciones();
    }

    private void mostrarTransacciones() {
        Transacciones.removeAll();
        Transacciones.setLayout(new java.awt.GridLayout(0, 1, 0, 10));

        if (cuenta.getTransacciones().isEmpty()) {
            JLabel labelSinTransacciones = new JLabel("¡No has realizado ninguna transacción!");
            labelSinTransacciones.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
            labelSinTransacciones.setForeground(java.awt.Color.BLACK);
            labelSinTransacciones.setHorizontalAlignment(JLabel.CENTER);
            Transacciones.add(labelSinTransacciones);
        } else {
            for (Transaccion transaccion : cuenta.getTransacciones()) {
                JLabel labelTransaccion = new JLabel(transaccion.obtenerDetalle());
                labelTransaccion.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 16));
                labelTransaccion.setForeground(java.awt.Color.BLACK);
                Transacciones.add(labelTransaccion);
            }
        }

        Transacciones.revalidate(); 
        Transacciones.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelInfoTransacciones = new javax.swing.JLabel();
        Regresar = new javax.swing.JButton();
        InternalFrameContenedor = new javax.swing.JInternalFrame();
        Transacciones = new javax.swing.JPanel();
        jScrollBar1 = new javax.swing.JScrollBar();
        JLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelInfoTransacciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        LabelInfoTransacciones.setForeground(new java.awt.Color(255, 255, 255));
        LabelInfoTransacciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelInfoTransacciones.setText("Transacciones realizadas por esta cuenta");
        getContentPane().add(LabelInfoTransacciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 370, 40));

        Regresar.setBackground(new java.awt.Color(0, 0, 51));
        Regresar.setForeground(new java.awt.Color(255, 255, 255));
        Regresar.setText("Regresar");
        Regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegresarActionPerformed(evt);
            }
        });
        getContentPane().add(Regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        InternalFrameContenedor.setVisible(true);

        javax.swing.GroupLayout TransaccionesLayout = new javax.swing.GroupLayout(Transacciones);
        Transacciones.setLayout(TransaccionesLayout);
        TransaccionesLayout.setHorizontalGroup(
            TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TransaccionesLayout.createSequentialGroup()
                .addGap(0, 628, Short.MAX_VALUE)
                .addComponent(jScrollBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TransaccionesLayout.setVerticalGroup(
            TransaccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout InternalFrameContenedorLayout = new javax.swing.GroupLayout(InternalFrameContenedor.getContentPane());
        InternalFrameContenedor.getContentPane().setLayout(InternalFrameContenedorLayout);
        InternalFrameContenedorLayout.setHorizontalGroup(
            InternalFrameContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Transacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InternalFrameContenedorLayout.setVerticalGroup(
            InternalFrameContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Transacciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(InternalFrameContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 650, 350));

        JLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(JLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegresarActionPerformed
        this.dispose();
        interfaz.setVisible(true);
    }//GEN-LAST:event_RegresarActionPerformed

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
            java.util.logging.Logger.getLogger(ConsultarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConsultarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConsultarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConsultarTransacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame InternalFrameContenedor;
    private javax.swing.JLabel JLabelFondo;
    private javax.swing.JLabel LabelInfoTransacciones;
    private javax.swing.JButton Regresar;
    private javax.swing.JPanel Transacciones;
    private javax.swing.JScrollBar jScrollBar1;
    // End of variables declaration//GEN-END:variables
}
