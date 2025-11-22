/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package terceraEntregaTpi.V;
import terceraEntregaTpi.M.Persona;


/**
 *
 * @author lautaro
 */
public class PantallaMostrarCuenta extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaMostrarCuenta.class.getName());

    
    public PantallaMostrarCuenta(Persona pSeleccionada, String contra, String saldo) {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        txtNombreTomadoPorBoton.setColumns(10);
        txtApellidoTomadoPorBoton.setColumns(10);
        txtLegajoTomadoPorBoton.setColumns(10);
        txtDniTomadoPorBoton.setColumns(10);
        txtTelefonoTomadoPorBoton.setColumns(10);
        txtContraseña.setColumns(10);
        txtMarcaVehiculo.setColumns(10);
        txtModeloVehiculo.setColumns(10);
        txtSaldo.setColumns(10);
        txtNombreTomadoPorBoton.setText(pSeleccionada.getNombre());
        txtApellidoTomadoPorBoton.setText(pSeleccionada.getApellido());
        txtLegajoTomadoPorBoton.setText(String.valueOf(pSeleccionada.getLegajo()));
        txtDniTomadoPorBoton.setText(String.valueOf(pSeleccionada.getDNI()));
        txtTelefonoTomadoPorBoton.setText(String.valueOf(pSeleccionada.getTelefono()));
        txtContraseña.setText(contra);
        txtMarcaVehiculo.setText(pSeleccionada.getMarcaVehiculo());
        txtModeloVehiculo.setText(pSeleccionada.getModeloVehiculo());
        txtPatenteVehiculo.setText(pSeleccionada.getPatenteVehiculo());
        txtSaldo.setText(saldo); 
    }
    
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNombreTomadoPorBoton = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtApellidoTomadoPorBoton = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtLegajoTomadoPorBoton = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDniTomadoPorBoton = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtTelefonoTomadoPorBoton = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtContraseña = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMarcaVehiculo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtModeloVehiculo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        BtnCargarSaldo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtPatenteVehiculo = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();

        jLabel12.setText("jLabel12");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(310, 550));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(310, 540));
        jPanel1.setPreferredSize(new java.awt.Dimension(310, 540));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 80));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Informacion del Usuario");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(27, 27, 27))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel11)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 310, 60));

        jLabel1.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel1.setText("Nombre:");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        txtNombreTomadoPorBoton.setEditable(false);
        txtNombreTomadoPorBoton.setFocusable(false);
        txtNombreTomadoPorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreTomadoPorBotonActionPerformed(evt);
            }
        });
        jPanel1.add(txtNombreTomadoPorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 110, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel4.setText("Apellido:");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, -1, -1));

        txtApellidoTomadoPorBoton.setEditable(false);
        txtApellidoTomadoPorBoton.setFocusable(false);
        jPanel1.add(txtApellidoTomadoPorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 110, -1));

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel3.setText("Legajo:");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, -1, -1));

        txtLegajoTomadoPorBoton.setEditable(false);
        txtLegajoTomadoPorBoton.setFocusable(false);
        txtLegajoTomadoPorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLegajoTomadoPorBotonActionPerformed(evt);
            }
        });
        jPanel1.add(txtLegajoTomadoPorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 110, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel2.setText("DNI:");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        txtDniTomadoPorBoton.setEditable(false);
        txtDniTomadoPorBoton.setFocusable(false);
        txtDniTomadoPorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniTomadoPorBotonActionPerformed(evt);
            }
        });
        jPanel1.add(txtDniTomadoPorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 110, -1));

        jLabel8.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel8.setText("Telefono:");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, -1, -1));

        txtTelefonoTomadoPorBoton.setEditable(false);
        txtTelefonoTomadoPorBoton.setFocusable(false);
        txtTelefonoTomadoPorBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTelefonoTomadoPorBotonActionPerformed(evt);
            }
        });
        jPanel1.add(txtTelefonoTomadoPorBoton, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 110, -1));

        jLabel9.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel9.setText("Contraseña:");
        jLabel9.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, -1));

        txtContraseña.setEditable(false);
        txtContraseña.setFocusable(false);
        txtContraseña.setMinimumSize(new java.awt.Dimension(120, 70));
        txtContraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContraseñaActionPerformed(evt);
            }
        });
        jPanel1.add(txtContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, 110, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel6.setText("Marca:");
        jLabel6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        txtMarcaVehiculo.setEditable(false);
        txtMarcaVehiculo.setFocusable(false);
        txtMarcaVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(txtMarcaVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 110, -1));

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel7.setText("Modelo:");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        txtModeloVehiculo.setEditable(false);
        txtModeloVehiculo.setFocusable(false);
        txtModeloVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(txtModeloVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 110, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel5.setText("Saldo:");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, -1, -1));

        txtSaldo.setEditable(false);
        txtSaldo.setFocusable(false);
        txtSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 110, -1));

        BtnCargarSaldo.setBackground(new java.awt.Color(255, 153, 0));
        BtnCargarSaldo.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BtnCargarSaldo.setForeground(new java.awt.Color(255, 255, 255));
        BtnCargarSaldo.setText("Cargar Saldo");
        BtnCargarSaldo.setBorderPainted(false);
        BtnCargarSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCargarSaldoActionPerformed(evt);
            }
        });
        jPanel1.add(BtnCargarSaldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 510, 110, -1));

        jLabel10.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        jLabel10.setText("Patente:");
        jLabel10.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel10.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel10.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        txtPatenteVehiculo.setEditable(false);
        txtPatenteVehiculo.setFocusable(false);
        txtPatenteVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPatenteVehiculoActionPerformed(evt);
            }
        });
        jPanel1.add(txtPatenteVehiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 110, -1));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 208, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 210, 440));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 310, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreTomadoPorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreTomadoPorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreTomadoPorBotonActionPerformed

    private void txtLegajoTomadoPorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLegajoTomadoPorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLegajoTomadoPorBotonActionPerformed

    private void txtDniTomadoPorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniTomadoPorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDniTomadoPorBotonActionPerformed

    private void txtTelefonoTomadoPorBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTelefonoTomadoPorBotonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTelefonoTomadoPorBotonActionPerformed

    private void txtContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContraseñaActionPerformed

    private void txtMarcaVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaVehiculoActionPerformed

    private void txtModeloVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloVehiculoActionPerformed

    private void txtSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoActionPerformed

    private void BtnCargarSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCargarSaldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnCargarSaldoActionPerformed

    private void txtPatenteVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPatenteVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPatenteVehiculoActionPerformed
    public javax.swing.JButton getBotonRecargarSaldo(){
        return BtnCargarSaldo;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCargarSaldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtApellidoTomadoPorBoton;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtDniTomadoPorBoton;
    private javax.swing.JTextField txtLegajoTomadoPorBoton;
    private javax.swing.JTextField txtMarcaVehiculo;
    private javax.swing.JTextField txtModeloVehiculo;
    private javax.swing.JTextField txtNombreTomadoPorBoton;
    private javax.swing.JTextField txtPatenteVehiculo;
    private javax.swing.JTextField txtSaldo;
    private javax.swing.JTextField txtTelefonoTomadoPorBoton;
    // End of variables declaration//GEN-END:variables
}
