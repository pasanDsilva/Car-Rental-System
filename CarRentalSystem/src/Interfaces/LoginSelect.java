/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class LoginSelect extends javax.swing.JFrame {

    /**
     * Creates new form LoginSelect
     */
    public LoginSelect() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Select How Do You Want To Log In As");
        setMaximumSize(new java.awt.Dimension(775, 475));
        setMinimumSize(new java.awt.Dimension(775, 475));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("How Do You Want To Log In As?");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(196, 123, 362, 79);

        jButton1.setBackground(new java.awt.Color(51, 102, 255));
        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(196, 326, 101, 37);

        jButton2.setBackground(new java.awt.Color(51, 102, 255));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Customer");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(425, 326, 133, 37);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/ggggg.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(775, 475));
        jLabel2.setMinimumSize(new java.awt.Dimension(775, 475));
        jLabel2.setPreferredSize(new java.awt.Dimension(775, 475));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 780, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        CustomerLogIn custlog = new CustomerLogIn();
        custlog.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AdminLogIn adminlog = new AdminLogIn();
        adminlog.setVisible(true);
        this.dispose();
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSelect.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSelect().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
