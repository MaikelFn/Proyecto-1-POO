/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import Clases.Banco;
import Clases.Cliente;
import Clases.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

/**
 *
 * @author Tayle
 */
public class InterfazCliente extends javax.swing.JFrame {

    private final Banco banco;
    private final Cliente cliente;
    private final IniciarSesion iniciarSesion;
    private final String idCliente;

    public InterfazCliente(Banco banco, Cliente cliente, IniciarSesion ventana) {
        initComponents();
        this.banco = banco;
        this.cliente = cliente;
        this.iniciarSesion = ventana;
        this.idCliente = cliente.getIdentificacion();
        cargarCuentas();
        this.setLocationRelativeTo(null);
        String idUsuario  = ventana.getTexto();
    }
    
     public String getTexto() {
        String obtener = iniciarSesion.getTexto();
        return obtener;
    }
     
     public void crearVentana(Cuenta cuenta){
         this.setVisible(false);
         InterfazInfoCuenta interfaz = new InterfazInfoCuenta(cuenta, this);
         interfaz.setVisible(true);
     }

    private void cargarCuentas() {
    banco.cargarClientes("clientes.xml");
    PanelCuentas.removeAll();

    if (cliente.getCuentas().isEmpty()) {
        JLabel labelSinCuentas = new JLabel("¡No posees ninguna cuenta!");
        labelSinCuentas.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 20));
        labelSinCuentas.setForeground(java.awt.Color.BLACK);
        labelSinCuentas.setHorizontalAlignment(JLabel.CENTER);
        PanelCuentas.setLayout(new java.awt.FlowLayout(FlowLayout.CENTER));
        PanelCuentas.add(labelSinCuentas);
    } else {
        int yPosition = 20;
        int contador = 1;

        for (Cuenta cuenta : cliente.getCuentas()) {
            JButton botonCuenta = new JButton("Cuenta " + contador);
            botonCuenta.setBounds(20, yPosition, 200, 30);
            yPosition += 40;

            botonCuenta.addActionListener(new ActionListener() {
                int intentos = 0;

                @Override
                public void actionPerformed(ActionEvent e) {
                    JFrame ventanaVerificar = new JFrame("Verificar cuenta");
                    ventanaVerificar.setSize(350, 120);
                    ventanaVerificar.setLayout(new FlowLayout());
                    ventanaVerificar.setLocationRelativeTo(null);
                    
                    JLabel labelIngresarNumero = new JLabel("Ingrese el numero de cuenta:");
                    JTextField textFieldNumero = new JTextField(10);
                    JButton botonVerificar = new JButton("Verificar cuenta");
                    
                    ventanaVerificar.add(labelIngresarNumero);
                    ventanaVerificar.add(textFieldNumero);
                    ventanaVerificar.add(botonVerificar);
                    
                    ventanaVerificar.setVisible(true);
                    
                    botonVerificar.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ev) {
                            String pinIngresado = textFieldNumero.getText();
                            
                            if (cuenta.getNumeroCuenta().equals(pinIngresado)) {
                                JOptionPane.showMessageDialog(ventanaVerificar, "¡Acceso concedido!");
                                ventanaVerificar.dispose();
                                crearVentana(cuenta);
                            } else {
                                intentos++;

                                if (intentos == 1) {
                                    JOptionPane.showMessageDialog(ventanaVerificar, "Acceso denegado, 2 intentos disponibles");
                                } else if (intentos == 2) {
                                    JOptionPane.showMessageDialog(ventanaVerificar, "Acceso denegado, 1 intento disponible");
                                } else if (intentos == 3) {
                                    JOptionPane.showMessageDialog(ventanaVerificar, "La cuenta ha sido desactivada");
                                    cuenta.desactivarCuenta();
                                    ventanaVerificar.dispose();
                                }
                            }
                        }
                    });
                }
            });

            PanelCuentas.add(botonCuenta);
            contador++;
        }
    }

    PanelCuentas.revalidate();
    PanelCuentas.repaint();
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameCuentas = new javax.swing.JInternalFrame();
        PanelCuentas = new javax.swing.JPanel();
        ScrollBarCuentas = new javax.swing.JScrollBar();
        BotonVolver = new javax.swing.JButton();
        Configuracion = new javax.swing.JButton();
        LabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        FrameCuentas.setBackground(new java.awt.Color(0, 0, 0));
        FrameCuentas.setBorder(null);
        FrameCuentas.setForeground(new java.awt.Color(255, 255, 255));
        FrameCuentas.setTitle("Cuentas del cliente");
        FrameCuentas.setVisible(true);

        PanelCuentas.setPreferredSize(new java.awt.Dimension(392, 300));

        javax.swing.GroupLayout PanelCuentasLayout = new javax.swing.GroupLayout(PanelCuentas);
        PanelCuentas.setLayout(PanelCuentasLayout);
        PanelCuentasLayout.setHorizontalGroup(
            PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCuentasLayout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(ScrollBarCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        PanelCuentasLayout.setVerticalGroup(
            PanelCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ScrollBarCuentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout FrameCuentasLayout = new javax.swing.GroupLayout(FrameCuentas.getContentPane());
        FrameCuentas.getContentPane().setLayout(FrameCuentasLayout);
        FrameCuentasLayout.setHorizontalGroup(
            FrameCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FrameCuentasLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        FrameCuentasLayout.setVerticalGroup(
            FrameCuentasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FrameCuentasLayout.createSequentialGroup()
                .addComponent(PanelCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(FrameCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 560, 370));

        BotonVolver.setBackground(new java.awt.Color(0, 0, 51));
        BotonVolver.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        BotonVolver.setForeground(new java.awt.Color(255, 255, 255));
        BotonVolver.setText("Cerrar sesión");
        BotonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonVolverActionPerformed(evt);
            }
        });
        getContentPane().add(BotonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Configuracion.setBackground(new java.awt.Color(0, 0, 51));
        Configuracion.setForeground(new java.awt.Color(255, 255, 255));
        Configuracion.setText("Configuración");
        Configuracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfiguracionActionPerformed(evt);
            }
        });
        getContentPane().add(Configuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 60));

        LabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Fondo.jpeg"))); // NOI18N
        getContentPane().add(LabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfiguracionActionPerformed
        this.setVisible(false);
        new ConfigurarCliente(cliente, this).setVisible(true);
    }//GEN-LAST:event_ConfiguracionActionPerformed

    private void BotonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonVolverActionPerformed
        this.dispose();
        iniciarSesion.vaciarTexto();
        iniciarSesion.setVisible(true);
    }//GEN-LAST:event_BotonVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            Banco banco = new Banco();
            banco.cargarClientes("clientes.xml");
        }
    });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonVolver;
    private javax.swing.JButton Configuracion;
    private javax.swing.JInternalFrame FrameCuentas;
    private javax.swing.JLabel LabelFondo;
    private javax.swing.JPanel PanelCuentas;
    private javax.swing.JScrollBar ScrollBarCuentas;
    // End of variables declaration//GEN-END:variables
}
