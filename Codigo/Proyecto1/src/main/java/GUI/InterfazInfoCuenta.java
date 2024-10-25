/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Clases.Cuenta;
import Clases.Banco;
import Clases.Comision;
import Clases.XMLWriter;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Clases.Cajero;
import Clases.Cliente;
import Clases.GeneradorContraseña;
import Clases.Mensaje;
/**
 *
 * @author Tayle
 */
public class InterfazInfoCuenta extends javax.swing.JFrame {
    private Cliente cliente;
    private Cuenta cuenta;
    private InterfazCliente ventana;
    private Banco banco;
    /**
     * Creates new form interfazInfoCuenta
     */
    public InterfazInfoCuenta(Cuenta cuenta, InterfazCliente interfaz) {
        initComponents();
        this.cuenta = cuenta;
        this.ventana = interfaz;
        this.setLocationRelativeTo(null);
        Banco banco = new Banco();
        banco.cargarClientes("clientes.xml");
        this.banco = banco;
        this.cliente = cuenta.getCliente();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Salir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        CambiarPin = new javax.swing.JButton();
        RetirarColones = new javax.swing.JButton();
        DepositarColones = new javax.swing.JButton();
        DepositarDolares = new javax.swing.JButton();
        RetirarDolares = new javax.swing.JButton();
        RealizarTransferencia = new javax.swing.JButton();
        ConsultarTransferencias = new javax.swing.JButton();
        ConsultarCompra = new javax.swing.JButton();
        ConsultarSaldo = new javax.swing.JButton();
        ConsultarEstado = new javax.swing.JButton();
        ConsultarSaldoExtranjero = new javax.swing.JButton();
        LabelContenedor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Salir.setBackground(new java.awt.Color(0, 0, 51));
        Salir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });
        getContentPane().add(Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 30));

        jPanel1.setBackground(new java.awt.Color(1, 95, 209));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 0, 330, 550));

        CambiarPin.setText("Cambiar pin");
        CambiarPin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CambiarPinActionPerformed(evt);
            }
        });
        getContentPane().add(CambiarPin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 110, -1));

        RetirarColones.setText("Retiro en colones");
        RetirarColones.setPreferredSize(new java.awt.Dimension(137, 23));
        RetirarColones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarColonesActionPerformed(evt);
            }
        });
        getContentPane().add(RetirarColones, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 70, 170, -1));

        DepositarColones.setText("Deposito en colones");
        DepositarColones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositarColonesActionPerformed(evt);
            }
        });
        getContentPane().add(DepositarColones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, -1));

        DepositarDolares.setText("Deposito en dolares");
        DepositarDolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DepositarDolaresActionPerformed(evt);
            }
        });
        getContentPane().add(DepositarDolares, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 140, -1));

        RetirarDolares.setText("Retiro en dolares");
        RetirarDolares.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetirarDolaresActionPerformed(evt);
            }
        });
        getContentPane().add(RetirarDolares, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 170, -1));

        RealizarTransferencia.setText("Realizar transferencia");
        RealizarTransferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RealizarTransferenciaActionPerformed(evt);
            }
        });
        getContentPane().add(RealizarTransferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        ConsultarTransferencias.setText("Consultar transacciones");
        ConsultarTransferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarTransferenciasActionPerformed(evt);
            }
        });
        getContentPane().add(ConsultarTransferencias, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 170, -1));

        ConsultarCompra.setText("Consultar Tipo de Cambio");
        ConsultarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ConsultarCompraMouseClicked(evt);
            }
        });
        ConsultarCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarCompraActionPerformed(evt);
            }
        });
        getContentPane().add(ConsultarCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 330, -1));

        ConsultarSaldo.setText("Consultar saldo");
        ConsultarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarSaldoActionPerformed(evt);
            }
        });
        getContentPane().add(ConsultarSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, -1, -1));

        ConsultarEstado.setText("Consultar estado de cuenta");
        ConsultarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(ConsultarEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 220, -1));

        ConsultarSaldoExtranjero.setText("Consultar saldo en divisa extranjera");
        ConsultarSaldoExtranjero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarSaldoExtranjeroActionPerformed(evt);
            }
        });
        getContentPane().add(ConsultarSaldoExtranjero, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 490, 220, -1));

        LabelContenedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo Redimensionado.jpeg"))); // NOI18N
        LabelContenedor.setPreferredSize(new java.awt.Dimension(100, 550));
        getContentPane().add(LabelContenedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarSaldoExtranjeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarSaldoExtranjeroActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        double Saldo=banco.convertirColonesADolares(cuenta.getSaldo());
        JOptionPane.showMessageDialog(null,"Su saldo actual en dolares es: " + Saldo);
    }//GEN-LAST:event_ConsultarSaldoExtranjeroActionPerformed

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        this.dispose();
        ventana.setVisible(true);
    }//GEN-LAST:event_SalirActionPerformed

    private void DepositarColonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositarColonesActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input = javax.swing.JOptionPane.showInputDialog("Ingrese el monto a depositar en colones:");
        if (input != null && !input.isEmpty()) {
            try {
                double monto = Double.parseDouble(input);
                cuenta.realizarDeposito(monto);
                javax.swing.JOptionPane.showMessageDialog(this, "Depósito realizado exitosamente.");
                
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
            }
        }
    }//GEN-LAST:event_DepositarColonesActionPerformed

    private void RetirarColonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarColonesActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input1 = javax.swing.JOptionPane.showInputDialog("Ingrese el PIN de su cuenta:");
        if (cuenta.validarPin(input1)){
            String PalabraSecreta=GeneradorContraseña.generarContraseña();
            Mensaje mensaje = new Mensaje(cliente.getCorreo(), "Codigo de verificacion", PalabraSecreta);
            mensaje.enviar();
            String input2 = javax.swing.JOptionPane.showInputDialog("Ingrese el Codigo que ha resibido por correo: ");
            if (PalabraSecreta.equals(input2)){
                String input3 = javax.swing.JOptionPane.showInputDialog("Ingrese el monto a retirar en colones:");
                if (input3 != null && !input3.isEmpty()) {
                    try {
                        double monto = Double.parseDouble(input3);
                        boolean exito = cuenta.realizarRetiro(monto);
                        if (exito) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Retiro realizado exitosamente.");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "Fondos insuficientes.");
                        }
                    } catch (NumberFormatException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
                    }
        }
            
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Codigo de verificacion Incorrecto");
            }
            }else {
                javax.swing.JOptionPane.showMessageDialog(this, "PIN Incorrecto");
            }
    }//GEN-LAST:event_RetirarColonesActionPerformed

            
    private void RetirarDolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetirarDolaresActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input1 = javax.swing.JOptionPane.showInputDialog("Ingrese el PIN de su cuenta:");
        if (cuenta.validarPin(input1)){
            String PalabraSecreta=GeneradorContraseña.generarContraseña();
            Mensaje mensaje = new Mensaje(cliente.getCorreo(), "Codigo de verificacion", PalabraSecreta);
            mensaje.enviar();
            String input2 = javax.swing.JOptionPane.showInputDialog("Ingrese el Codigo que ha resibido por correo: ");
            if (PalabraSecreta.equals(input2)){
                String input3 = javax.swing.JOptionPane.showInputDialog("Ingrese el monto a retirar en dolares:");
                try {
                    double monto = Double.parseDouble(input3);
                    Comision comision = new Comision();
                    if (monto > 0 && monto <= cuenta.getSaldo()) {
                        // Actualizar el saldo de la cuenta
                        double saldo = banco.convertirDolaresAColones(monto);
                        boolean exito = cuenta.realizarRetiro(saldo);
                        if (exito) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Retiro realizado exitosamente.");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "Fondos insuficientes.");
                            }
                    } else {
                        JOptionPane.showMessageDialog(this, "Monto inválido o insuficiente saldo.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
                    }
            
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Codigo de verificacion Incorrecto");
                    } 
        }else {
            javax.swing.JOptionPane.showMessageDialog(this, "PIN Incorrecto");
            }

    }//GEN-LAST:event_RetirarDolaresActionPerformed

    private void DepositarDolaresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DepositarDolaresActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input = javax.swing.JOptionPane.showInputDialog("Ingrese el monto a depositar en dolares:");
    
        try {
            double monto = Double.parseDouble(input);
        
            if (monto > 0) {
                double saldo = banco.convertirDolaresAColones(monto);
                cuenta.realizarDeposito(saldo);
                JOptionPane.showMessageDialog(this, "Depósito exitoso.");
            } else {
                JOptionPane.showMessageDialog(this, "Ingrese un monto mayor a 0.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un monto válido.");
        }
    }//GEN-LAST:event_DepositarDolaresActionPerformed

    private void RealizarTransferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RealizarTransferenciaActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_RealizarTransferenciaActionPerformed

    private void ConsultarTransferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarTransferenciasActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        this.setVisible(false);
        ConsultarTransacciones transacciones = new ConsultarTransacciones(cuenta, this);
        transacciones.setVisible(true);
    }//GEN-LAST:event_ConsultarTransferenciasActionPerformed

    private void ConsultarCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarCompraActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String Venta=Cajero.consultarTipoCambio("venta");
        String Compra=Cajero.consultarTipoCambio("compra");
        JOptionPane.showMessageDialog(null, """
                                            Tipo de cambio
                                            Compra de dolares: """ + Compra + "\n"
                                                + "Venta de dolares: " + Venta);
              
    }//GEN-LAST:event_ConsultarCompraActionPerformed

    private void CambiarPinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CambiarPinActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String input1 = javax.swing.JOptionPane.showInputDialog("Ingrese su PIN actual:");
        if (cuenta.validarPin(input1)){
            String input2 = javax.swing.JOptionPane.showInputDialog("Ingrese su nuevo PIN:");
            if (input2.length() < 4 || input2.length() > 6) {
                JOptionPane.showMessageDialog(this, "El PIN debe tener entre 4 y 6 caracteres.");
            }else{
            cuenta.cambiarPin(input2);
            XMLWriter.reemplazarPin(cliente.getIdentificacion(), cuenta.getNumeroCuenta(), input2, "clientes.xml");
            }
        }else{
            JOptionPane.showMessageDialog(this, "El Pin ingresado es incorrecto");
        }
        
    }//GEN-LAST:event_CambiarPinActionPerformed

    private void ConsultarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarEstadoActionPerformed
        if (cuenta.getEstatus()){
            JOptionPane.showMessageDialog(null, "El Estado de su cuenta es: Activa");
        }else{
            JOptionPane.showMessageDialog(null, "El Estado de su cuenta es: Inactiva");
    }
    }//GEN-LAST:event_ConsultarEstadoActionPerformed

    private void ConsultarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarSaldoActionPerformed
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,"Su saldo actual: "+cuenta.getSaldo());
    }//GEN-LAST:event_ConsultarSaldoActionPerformed

    private void ConsultarCompraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ConsultarCompraMouseClicked
        if (!cuenta.getEstatus()) {
            JOptionPane.showMessageDialog(this, "La cuenta está inactiva, no se puede realizar esta acción", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
    }//GEN-LAST:event_ConsultarCompraMouseClicked

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
            java.util.logging.Logger.getLogger(InterfazInfoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazInfoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazInfoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazInfoCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Banco banco = new Banco();
                banco.cargarClientes("clientes.xml");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CambiarPin;
    private javax.swing.JButton ConsultarCompra;
    private javax.swing.JButton ConsultarEstado;
    private javax.swing.JButton ConsultarSaldo;
    private javax.swing.JButton ConsultarSaldoExtranjero;
    private javax.swing.JButton ConsultarTransferencias;
    private javax.swing.JButton DepositarColones;
    private javax.swing.JButton DepositarDolares;
    private javax.swing.JLabel LabelContenedor;
    private javax.swing.JButton RealizarTransferencia;
    private javax.swing.JButton RetirarColones;
    private javax.swing.JButton RetirarDolares;
    private javax.swing.JButton Salir;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private double convertirColonesADolares(double Colones) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
