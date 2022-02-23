
package intface;

import code.DBconnect;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class members extends javax.swing.JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public members() {
        initComponents();
        conn = DBconnect.connect();
        tableload();
        
    }

    public void tableload(){
        try {
            String sql = "SELECT Reg_Number,Name FROM member";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void getTableData(){
        int r = jTable1.getSelectedRow();
        
        int id = (int) jTable1.getValueAt(r, 0);
        
        try {
            String sql = "SELECT * FROM member WHERE Reg_Number = '"+id+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Reg_Number = rs.getString("Reg_Number");
                String name = rs.getString("Name");
                String Nic = rs.getString("NIC");
                String dob = rs.getString("Date_Of_Birth");
                String telephone = rs.getString("Telephone");
                String address = rs.getString("Address");
                
                lblRegNumber.setText(Reg_Number);
                lblName.setText(name);
                lblNic.setText(Nic);
                lblDOB.setText(dob);
                lblTelephoneNum.setText(telephone);
                lblAddress.setText(address);
                
            }
   
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void search(){
        String scrh = searchBox.getText();
        
        try {
            String sql = "SELECT Reg_Number,Name FROM member WHERE Name LIKE '%"+scrh+"%'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        searchBox = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        lblRegNumber = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblDOB = new javax.swing.JLabel();
        lblAddress = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblNic = new javax.swing.JLabel();
        lblRegNumber1 = new javax.swing.JLabel();
        lblName1 = new javax.swing.JLabel();
        lblNic2 = new javax.swing.JLabel();
        lblDOB1 = new javax.swing.JLabel();
        lblTelephoneNum1 = new javax.swing.JLabel();
        lblAddress1 = new javax.swing.JLabel();
        lblProf_Img = new javax.swing.JLabel();
        lblTelephoneNum = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Member List");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 60));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 67, -1, 563));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 102, 255))); // NOI18N

        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchBoxKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 70));

        jPanel6.setBackground(new java.awt.Color(102, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "profile", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(0, 51, 255))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRegNumber.setBackground(new java.awt.Color(0, 0, 0));
        lblRegNumber.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRegNumber.setForeground(new java.awt.Color(51, 51, 255));
        lblRegNumber.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRegNumber.setText("Reg Number");
        jPanel6.add(lblRegNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 280, -1));

        lblName.setBackground(new java.awt.Color(0, 0, 0));
        lblName.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblName.setForeground(new java.awt.Color(51, 51, 255));
        lblName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName.setText("Name");
        jPanel6.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 280, -1));

        lblDOB.setBackground(new java.awt.Color(0, 0, 0));
        lblDOB.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDOB.setForeground(new java.awt.Color(51, 51, 255));
        lblDOB.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDOB.setText("Date Of Birth");
        jPanel6.add(lblDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 280, -1));

        lblAddress.setBackground(new java.awt.Color(0, 0, 0));
        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAddress.setForeground(new java.awt.Color(51, 51, 255));
        lblAddress.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddress.setText("Address");
        lblAddress.setAutoscrolls(true);
        jPanel6.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 560, -1));

        jButton2.setBackground(new java.awt.Color(0, 204, 204));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 430, -1, -1));

        btnDelete.setBackground(new java.awt.Color(0, 204, 204));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 0, 0));
        btnDelete.setText("Edit");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel6.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 120, -1));

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 30, 240, 260));

        lblNic.setBackground(new java.awt.Color(0, 0, 0));
        lblNic.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNic.setForeground(new java.awt.Color(51, 51, 255));
        lblNic.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNic.setText("NIC");
        jPanel6.add(lblNic, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 280, -1));

        lblRegNumber1.setBackground(new java.awt.Color(0, 0, 0));
        lblRegNumber1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblRegNumber1.setForeground(new java.awt.Color(51, 51, 51));
        lblRegNumber1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRegNumber1.setText("Reg Number");
        jPanel6.add(lblRegNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, -1));

        lblName1.setBackground(new java.awt.Color(0, 0, 0));
        lblName1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblName1.setForeground(new java.awt.Color(51, 51, 51));
        lblName1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblName1.setText("Name");
        jPanel6.add(lblName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 280, -1));

        lblNic2.setBackground(new java.awt.Color(0, 0, 0));
        lblNic2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblNic2.setForeground(new java.awt.Color(51, 51, 51));
        lblNic2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNic2.setText("NIC");
        jPanel6.add(lblNic2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 280, -1));

        lblDOB1.setBackground(new java.awt.Color(0, 0, 0));
        lblDOB1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblDOB1.setForeground(new java.awt.Color(51, 51, 51));
        lblDOB1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblDOB1.setText("Date Of Birth");
        jPanel6.add(lblDOB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 280, -1));

        lblTelephoneNum1.setBackground(new java.awt.Color(0, 0, 0));
        lblTelephoneNum1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTelephoneNum1.setForeground(new java.awt.Color(51, 51, 51));
        lblTelephoneNum1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTelephoneNum1.setText("Telephone Number");
        jPanel6.add(lblTelephoneNum1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 280, -1));

        lblAddress1.setBackground(new java.awt.Color(0, 0, 0));
        lblAddress1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblAddress1.setForeground(new java.awt.Color(51, 51, 51));
        lblAddress1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAddress1.setText("Address");
        jPanel6.add(lblAddress1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 280, 110));

        lblProf_Img.setBackground(new java.awt.Color(153, 255, 153));
        lblProf_Img.setForeground(new java.awt.Color(255, 255, 255));
        jPanel6.add(lblProf_Img, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 138, 128));

        lblTelephoneNum.setBackground(new java.awt.Color(0, 0, 0));
        lblTelephoneNum.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTelephoneNum.setForeground(new java.awt.Color(51, 51, 255));
        lblTelephoneNum.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTelephoneNum.setText("Telephone Number");
        jPanel6.add(lblTelephoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 280, -1));

        jButton4.setBackground(new java.awt.Color(0, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 0, 0));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 430, 110, -1));

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 820, 500));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 600));

        jTable1.setBackground(new java.awt.Color(51, 255, 204));
        jTable1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Reg Number", "Name"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(1).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 60, 400, 600));

        setSize(new java.awt.Dimension(1248, 709));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        mainBoard mb = new mainBoard();
        mb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        getTableData();
    }//GEN-LAST:event_jTable1MouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        int reg_num;
        reg_num = Integer.parseInt(lblRegNumber.getText());
        new userForm(reg_num).setVisible(true);
        setVisible(false);
    
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void searchBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyReleased
        search();
    }//GEN-LAST:event_searchBoxKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int check = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?");
        
        if(check==0){
            
            String id = lblRegNumber.getText();
            try {
                String sql = "DELETE FROM Member WHERE Reg_num = '"+id+"'";
                pst = conn.prepareStatement(sql);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Deleted Successful");
            } catch (HeadlessException | SQLException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        
        tableload();
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new members().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAddress1;
    private javax.swing.JLabel lblDOB;
    private javax.swing.JLabel lblDOB1;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblName1;
    private javax.swing.JLabel lblNic;
    private javax.swing.JLabel lblNic2;
    private javax.swing.JLabel lblProf_Img;
    private javax.swing.JLabel lblRegNumber;
    private javax.swing.JLabel lblRegNumber1;
    private javax.swing.JLabel lblTelephoneNum;
    private javax.swing.JLabel lblTelephoneNum1;
    private javax.swing.JTextField searchBox;
    // End of variables declaration//GEN-END:variables
}
