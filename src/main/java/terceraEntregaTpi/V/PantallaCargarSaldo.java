//CLASE EN LA QUE APLICAMOS PRINCIPIO DE RESPONSABILIDAD UNICA
package terceraEntregaTpi.V;
import javax.swing.text.AbstractDocument;
import javax.swing.JOptionPane;



public class PantallaCargarSaldo extends javax.swing.JFrame{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PantallaCargarSaldo.class.getName());


    public PantallaCargarSaldo() {
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        ((AbstractDocument) txtSaldoCargar.getDocument()).setDocumentFilter(new FiltroNumericoRecargaDeSaldo());
    }
    public javax.swing.JTextField getTxtSaldoCargar(){
        return txtSaldoCargar;
    }
    public javax.swing.JButton getBotonConfirmarRecarga(){
        return BtnConfirmarRecarga;
    }
    
    public void mostrarMensaje(String mensaje, String nuevoSaldo){
        JOptionPane.showMessageDialog(null, mensaje+nuevoSaldo);
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        BtnConfirmarRecarga = new javax.swing.JButton();
        txtSaldoCargar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 60));

        jLabel1.setText("Ingresa el monto a cargar:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        BtnConfirmarRecarga.setText("Confirmar");
        jPanel1.add(BtnConfirmarRecarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 90, -1));

        txtSaldoCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSaldoCargarActionPerformed(evt);
            }
        });
        jPanel1.add(txtSaldoCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 120, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSaldoCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSaldoCargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoCargarActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnConfirmarRecarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtSaldoCargar;
    // End of variables declaration//GEN-END:variables
}
