/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.Admin;
import ClassFiles.DBConnect;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class AdminsInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public AdminsInternalFrame() {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
    }

    public void LoaddTable(){
        try {
            String sql = "select name as Name , username as Username, email as Email , phone as Phone from admin";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        subpane = new javax.swing.JDesktopPane();
        jButton6 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1310, 769));
        setMinimumSize(new java.awt.Dimension(1310, 769));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 50, 842, 297);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setText("Add Admin");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(940, 50, 93, 25);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton2.setText("Update Admin");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(940, 90, 107, 25);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton3.setText("Delete Admin");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(940, 130, 107, 25);

        subpane.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout subpaneLayout = new javax.swing.GroupLayout(subpane);
        subpane.setLayout(subpaneLayout);
        subpaneLayout.setHorizontalGroup(
            subpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
        );
        subpaneLayout.setVerticalGroup(
            subpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 360, Short.MAX_VALUE)
        );

        getContentPane().add(subpane);
        subpane.setBounds(37, 363, 480, 360);

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton6.setText("Change Admin Password");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(940, 170, 169, 25);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton5.setText("Generate Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(940, 210, 123, 25);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/1130.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1310, 769));
        jLabel1.setMinimumSize(new java.awt.Dimension(1310, 769));
        jLabel1.setPreferredSize(new java.awt.Dimension(1310, 769));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1130, 740);

        setBounds(-5, -35, 1128, 769);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        subpane.removeAll();
        AdminRegister ar = new AdminRegister(this);
        subpane.add(ar).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
      
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int row = -1;
        row = jTable1.getSelectedRow();
        if(row !=-1)
        {
            String name = jTable1.getValueAt(row, 0).toString();
            String username = jTable1.getValueAt(row, 1).toString();
            String email = jTable1.getValueAt(row, 2).toString();
            String phone = jTable1.getValueAt(row, 3).toString();
            AdminUpdate au = new AdminUpdate(name,username,email,phone,this);
            subpane.removeAll();
            subpane.add(au).setVisible(true);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select The Admin You Want To Update From The Table First");     
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = -1;
        row = jTable1.getSelectedRow();  
        if(row != -1)
        {
            int x = JOptionPane.showConfirmDialog(null,"Do You Really Want To Delete The Selected User?");
            if(x ==0)
            {
                String name = jTable1.getValueAt(row, 0).toString();
                String username = jTable1.getValueAt(row, 1).toString();
                String email = jTable1.getValueAt(row, 2).toString();
                String phone = jTable1.getValueAt(row, 3).toString();

                Admin ad = new Admin(name,username,email,phone);
                ad.DeleteAdmin();
                LoaddTable();
            }
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Please Select The Admin You Want To Delete From The Table First");     
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int row = -1;
        row = jTable1.getSelectedRow();  
        if(row != -1)
        {
            String username = jTable1.getValueAt(row, 1).toString();
            AdminChangePassword ac = new AdminChangePassword(username);
            subpane.removeAll();
            subpane.add(ac).setVisible(true);
        }
        else
        {
           JOptionPane.showMessageDialog(null, "Please Select The Admin You Want To Change The Password From The Table First");     
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Compile jrxml file.
        JasperReport jasperReport;
        try {
            // Compile jrxml file.
            jasperReport = JasperCompileManager.compileReport("src/Reports/AdminsReport.jrxml");

            // Parameters for report
            Map<String, Object> parameters = new HashMap<String, Object>();

            // DataSource
            Connection conn = DBConnect.connect();
            // This is simple example, no database.
            // then using empty datasource.

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,
                parameters,conn);

            // Make sure the output directory exists.
            File outDir = new File("src/jasperoutput");
            outDir.mkdirs();

            // Export to PDF.
            JasperExportManager.exportReportToPdfFile(jasperPrint,
                "src/jasperoutput/AdminsReport.pdf");

            System.out.println("Done!");
        } catch (JRException ex) {
            Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File("src/jasperoutput/AdminsReport.pdf");
        if(file.exists())
        {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException ex) {
                Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JDesktopPane subpane;
    // End of variables declaration//GEN-END:variables

    private PreparedStatement PreparedStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
