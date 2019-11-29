/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author prasad
 */
public class CustomerDashboard extends javax.swing.JFrame {

    String user = "root", pass = "root";
    String cust_id;

    private CustomerDashboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Creates new form CustomerDashboard
     */
    private void Dashboard() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.ClientDriver());
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/database", user, pass);
//            String query = "insert into CUSTOMER(CUSTOMER_ID,CUSTOMER_NAME,CURRENT_ADDRESS,PASSWORD,DATE_OF_BIRTH,AGE,EMAIL,PHONE) VALUES(23,'PRANAV','HADSAR','12356','1999-10-13',19,'pra17u234@viit.ac.in',934527)";            PreparedStatement statement=con.prepareStatement(query);
            String query = "select * from apartment";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

//            show apartments
            if(rs.next()) {
                jLabelApartmentName.setText(rs.getString("APARTMENT_NAME"));
                jLabelDeposit.setText(rs.getString("DEPOSIT"));
                jLabelAddress.setText(rs.getString("ADDRESS"));
                jLabelType.setText(rs.getString("APARTMENT_TYPE"));
                String get ="select PROPRIETOR_NAME from proprietor where proprietor_id="+rs.getString("PROPRIETOR_ID");
                PreparedStatement getname = con.prepareStatement(get);
                ResultSet rName  = getname.executeQuery();
                rName.next();
                jLabelProprietorName.setText(rName.getString(1));

            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public CustomerDashboard(String id) {
        initComponents();
        cust_id=id;
        Dashboard();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelList = new javax.swing.JPanel();
        jLabelApartmentName = new javax.swing.JLabel();
        jLabelAddress = new javax.swing.JLabel();
        jLabelType = new javax.swing.JLabel();
        jLabelDeposit = new javax.swing.JLabel();
        jLabelProprietorName = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        buttonMore = new java.awt.Button();
        buttonEditProfile = new java.awt.Button();
        button2 = new java.awt.Button();
        buttonChangePassword = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Apartment Info");

        jPanelList.setBackground(new java.awt.Color(240, 184, 240));

        jLabelApartmentName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelApartmentName.setText("apt name");

        jLabelAddress.setText("address");

        jLabelType.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabelType.setText("type");

        jLabelDeposit.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabelDeposit.setText("depo");

        jLabelProprietorName.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelProprietorName.setText("ithe naav proprietor cha");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Owner:");

        buttonMore.setLabel("more");
        buttonMore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMoreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelListLayout = new javax.swing.GroupLayout(jPanelList);
        jPanelList.setLayout(jPanelListLayout);
        jPanelListLayout.setHorizontalGroup(
            jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelListLayout.createSequentialGroup()
                        .addComponent(jLabelApartmentName)
                        .addGap(153, 153, 153)
                        .addComponent(jLabelType, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addComponent(jLabelDeposit, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47))
                    .addGroup(jPanelListLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelProprietorName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonMore, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(jPanelListLayout.createSequentialGroup()
                        .addComponent(jLabelAddress)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelListLayout.setVerticalGroup(
            jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelListLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelApartmentName)
                    .addComponent(jLabelType)
                    .addComponent(jLabelDeposit))
                .addGroup(jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelListLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonMore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanelListLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabelAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelProprietorName)
                            .addComponent(jLabel1))
                        .addContainerGap(30, Short.MAX_VALUE))))
        );

        jLabelApartmentName.getAccessibleContext().setAccessibleName("jLabelApartmentName");

        buttonEditProfile.setLabel("Edit Profile");
        buttonEditProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditProfileActionPerformed(evt);
            }
        });

        button2.setLabel("View Interested");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        buttonChangePassword.setLabel("Change Password");
        buttonChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonChangePasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jPanelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(buttonEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(buttonChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(buttonEditProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonChangePassword, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, 109)
                .addComponent(jPanelList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonMoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMoreActionPerformed
        // TODO add your handling code here:
        CApartmentDetails c = new CApartmentDetails("100");
        c.setVisible(true);
    }//GEN-LAST:event_buttonMoreActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void buttonChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonChangePasswordActionPerformed
        // TODO add your handling code here:
        ChangePassword cp = new ChangePassword(cust_id);
        cp.setVisible(true);
    }//GEN-LAST:event_buttonChangePasswordActionPerformed

    private void buttonEditProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditProfileActionPerformed
        // TODO add your handling code here
        EditProfile ep = new EditProfile(cust_id);
        ep.setVisible(true);
    }//GEN-LAST:event_buttonEditProfileActionPerformed

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
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button2;
    private java.awt.Button buttonChangePassword;
    private java.awt.Button buttonEditProfile;
    private java.awt.Button buttonMore;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAddress;
    private javax.swing.JLabel jLabelApartmentName;
    private javax.swing.JLabel jLabelDeposit;
    private javax.swing.JLabel jLabelProprietorName;
    private javax.swing.JLabel jLabelType;
    private javax.swing.JPanel jPanelList;
    // End of variables declaration//GEN-END:variables

}