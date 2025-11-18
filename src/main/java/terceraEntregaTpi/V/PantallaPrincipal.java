package terceraEntregaTpi.V;
import javax.swing.ImageIcon;
import java.awt.Image;

/**
 *
 * @author lautaro
 */
public class PantallaPrincipal extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaPrincipal.class.getName());

    /**
     * Creates new form PantallaPrincipal
     */
    public PantallaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        

    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        botonNuevaCuenta = new javax.swing.JButton();
        BotonGestionarCuentas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 133, 29));
        jPanel1.setForeground(new java.awt.Color(255, 153, 0));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Roboto", 0, 48)); // NOI18N
        jLabel1.setText("UTN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addComponent(jLabel1)
                .addContainerGap(590, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 830, -1));

        botonNuevaCuenta.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        botonNuevaCuenta.setText("Nueva Cuenta");
        botonNuevaCuenta.setFocusPainted(false);
        botonNuevaCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonNuevaCuentaActionPerformed(evt);
            }
        });
        jPanel2.add(botonNuevaCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 140, -1));
        botonNuevaCuenta.getAccessibleContext().setAccessibleName("Jbutton2");

        BotonGestionarCuentas.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        BotonGestionarCuentas.setText("Cuentas");
        BotonGestionarCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGestionarCuentasActionPerformed(evt);
            }
        });
        jPanel2.add(BotonGestionarCuentas, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 140, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 410, 310));
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGestionarCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGestionarCuentasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGestionarCuentasActionPerformed

    private void botonNuevaCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonNuevaCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonNuevaCuentaActionPerformed

    /**
     * @param args the command line arguments
     */
    
    public javax.swing.JButton getBotonNuevaCuenta() {
        return botonNuevaCuenta;
    }
    public javax.swing.JButton getBotonGestionarCuentas(){
        return BotonGestionarCuentas;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGestionarCuentas;
    private javax.swing.JButton botonNuevaCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
