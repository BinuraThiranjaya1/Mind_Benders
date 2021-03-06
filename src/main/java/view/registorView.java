/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import model.registorModel;
import controller.registrationController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class registorView extends javax.swing.JFrame {

    registorModel objUser;
    registrationController objController;

    public registorView() {
        initComponents();
        objController = new registrationController();
        Connect();
        User_Load();
    }
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    DefaultTableModel d;

    public void Connect() {

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/StudentIssuesManager", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(registorView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void User_Load() {
        try {
            int c;

            pst = con.prepareStatement("select * from user");
            rs = pst.executeQuery();

            ResultSetMetaData rsd = (ResultSetMetaData) rs.getMetaData();
            c = rsd.getColumnCount();

            d = (DefaultTableModel) tblreg.getModel();
            d.setRowCount(0);

            while (rs.next()) {
                Vector v2 = new Vector();

                for (int i = 1; i <= c; i++) {
                    v2.add(rs.getString("name"));
                    v2.add(rs.getString("uname"));
                    v2.add(rs.getString("pass"));
                    v2.add(rs.getString("utype"));
                    v2.add(rs.getString("pnumber"));
                    v2.add(rs.getString("email"));

                }
                d.addRow(v2);

            }
        } catch (SQLException ex) {
            Logger.getLogger(registorView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtname = new javax.swing.JTextField();
        txtuname1 = new javax.swing.JTextField();
        txtpnum = new javax.swing.JTextField();
        txtemail = new javax.swing.JTextField();
        txtuname = new javax.swing.JTextField();
        cmbutype = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblreg = new javax.swing.JTable();
        txtpass = new javax.swing.JPasswordField();
        txtpass1 = new javax.swing.JPasswordField();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Registration");

        jPanel2.setBackground(new java.awt.Color(90, 90, 90));

        txtname.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        txtuname1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        txtpnum.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        txtemail.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        txtuname.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        cmbutype.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N
        cmbutype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Lecturer", "Admin" }));

        jLabel1.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel1.setText("Name");

        jLabel2.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel2.setText("NIC");

        jLabel3.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel3.setText("Re-enter NIC");

        jLabel4.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel5.setText("Re-enter Password");

        jLabel6.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel7.setText("E-mail");

        jLabel8.setFont(new java.awt.Font("Courier New", 1, 14)); // NOI18N
        jLabel8.setText("User Type");

        btnEdit.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnadd.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnClose.setBackground(new java.awt.Color(255, 51, 51));
        btnClose.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnClose.setText("Back");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 0, 0));
        btnDelete.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        tblreg.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "NIC", "Password", "UserType", "Phone Number", "E-mail"
            }
        ));
        tblreg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblregMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblreg);

        txtpass.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        txtpass1.setFont(new java.awt.Font("Dialog", 2, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClose))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtpass, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                            .addComponent(txtname)
                            .addComponent(txtuname)
                            .addComponent(txtuname1)
                            .addComponent(cmbutype, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtpass1)
                            .addComponent(txtpnum)
                            .addComponent(txtemail))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnDelete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnadd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtuname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtuname1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnadd)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(btnEdit))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(13, 13, 13)
                .addComponent(btnClear)
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpnum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbutype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnClose)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        String name = txtname.getText();
        String uname = txtuname.getText();
        String uname1 = txtuname1.getText();

        String pass = txtpass.getText();
        String pass1 = txtpass1.getText();

        String pnumber = txtpnum.getText();
        String email = txtemail.getText();
        String utype = cmbutype.getSelectedItem().toString();

        if (uname.equalsIgnoreCase(uname1) && pass.equalsIgnoreCase(pass1)) {
            objUser = objController.addUser(uname, pass, name, pnumber, email, utype);
            boolean result = objController.insertUserToDB(objUser);
            if (result) {
                JOptionPane.showMessageDialog(rootPane, "User added successfully", "Registration", 1);
                txtname.setText("");
                txtuname.setText("");
                txtuname1.setText("");
                txtpass.setText("");
                txtpass1.setText("");
                txtpnum.setText("");
                cmbutype.setSelectedIndex(-1);
                txtemail.setText("");

                txtname.requestFocus();
                btnadd.setEnabled(true);

                txtuname.setEnabled(true);
                txtuname1.setEnabled(true);

                User_Load();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error in editing to db", "Error", 0);
                txtname.setText("");
                txtuname.setText("");
                txtuname1.setText("");
                txtpass.setText("");
                txtpass1.setText("");
                txtpnum.setText("");
                cmbutype.setSelectedIndex(-1);
                txtemail.setText("");
                txtname.requestFocus();
                btnadd.setEnabled(true);

                txtuname.setEnabled(true);
                txtuname1.setEnabled(true);

            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Incorrect informations Please Check Again", "Error", 0);

        }

    }//GEN-LAST:event_btnaddActionPerformed

    private void tblregMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblregMouseClicked
        d = (DefaultTableModel) tblreg.getModel();
        int selectIndex = tblreg.getSelectedRow();

        txtname.setText(d.getValueAt(selectIndex, 0).toString());
        txtuname.setText(d.getValueAt(selectIndex, 1).toString());
        txtuname1.setText(d.getValueAt(selectIndex, 1).toString());
        txtpass.setText(d.getValueAt(selectIndex, 2).toString());
        txtpass1.setText(d.getValueAt(selectIndex, 2).toString());
        cmbutype.setSelectedItem(d.getValueAt(selectIndex, 3).toString());

        txtpnum.setText(d.getValueAt(selectIndex, 4).toString());
        txtemail.setText(d.getValueAt(selectIndex, 5).toString());

        btnadd.setEnabled(false);
        txtuname.setEnabled(false);
        txtuname1.setEnabled(false);

    }//GEN-LAST:event_tblregMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        String uname = txtuname.getText();
        String uname1 = txtuname1.getText();

        String pass = txtpass.getText();
        String pass1 = txtpass1.getText();

        String name = txtname.getText();
        String pnumber = txtpnum.getText();
        String email = txtemail.getText();
        String utype = cmbutype.getSelectedItem().toString();

        if (uname.equalsIgnoreCase(uname1) && pass.equalsIgnoreCase(pass1)) {
            boolean result = objController.updateUserToDB(uname, pass, name, pnumber, email, utype);
            if (result) {
                JOptionPane.showMessageDialog(rootPane, " User EDITED", "Registration", 1);
                txtname.setText("");
                txtuname.setText("");
                txtuname1.setText("");
                txtpass.setText("");
                txtpass1.setText("");
                txtpnum.setText("");
                cmbutype.setSelectedIndex(-1);
                txtemail.setText("");

                txtname.requestFocus();
                btnadd.setEnabled(true);

                txtuname.setEnabled(true);
                txtuname1.setEnabled(true);

                User_Load();
            } else {
                JOptionPane.showMessageDialog(rootPane, "Error in editing to db", "Error", 0);
                txtname.setText("");
                txtuname.setText("");
                txtuname1.setText("");
                txtpass.setText("");
                txtpass1.setText("");
                txtpnum.setText("");
                cmbutype.setSelectedIndex(-1);
                txtemail.setText("");
                txtname.requestFocus();
                btnadd.setEnabled(true);

                txtuname.setEnabled(true);
                txtuname1.setEnabled(true);

            
            }
        }else {
            JOptionPane.showMessageDialog(rootPane, "Incorrect informations Please Check Again", "Error", 0);

        
    }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtname.setText("");
        txtuname.setText("");
        txtuname1.setText("");
        txtpass.setText("");
        txtpass1.setText("");
        txtpnum.setText("");
        cmbutype.setSelectedIndex(-1);
        txtemail.setText("");
        btnadd.setEnabled(true);

        txtuname.setEnabled(true);
        txtuname1.setEnabled(true);
        txtname.requestFocus();

    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String uname = txtuname.getText();
        boolean result = objController.deleteUserToDB(uname);

        if (result) {
            JOptionPane.showMessageDialog(rootPane, " User has been Deleted Successfully", "Registration", 1);
            txtname.setText("");
            txtuname.setText("");
            txtuname1.setText("");
            txtpass.setText("");
            txtpass1.setText("");
            txtpnum.setText("");
            cmbutype.setSelectedIndex(-1);
            txtemail.setText("");
            txtname.requestFocus();
            btnadd.setEnabled(true);

            txtuname.setEnabled(true);
            txtuname1.setEnabled(true);
           
            User_Load();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error deleting to db", "Error", 0);
            txtname.setText("");
            txtuname.setText("");
            txtuname1.setText("");
            txtpass.setText("");
            txtpass1.setText("");
            txtpnum.setText("");
            cmbutype.setSelectedIndex(-1);
            txtemail.setText("");
            txtuname.setEnabled(true);
            btnadd.setEnabled(true);

            txtuname.setEnabled(true);
            txtuname1.setEnabled(true);
            

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
         adminMenuView amenu = new adminMenuView();
                amenu.setVisible(true);
                this.setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(registorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registorView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registorView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnadd;
    private javax.swing.JComboBox<String> cmbutype;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblreg;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtname;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JTextField txtpnum;
    private javax.swing.JTextField txtuname;
    private javax.swing.JTextField txtuname1;
    // End of variables declaration//GEN-END:variables
}
