/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.DBConnect;
import ClassFiles.Make;
import ClassFiles.Model;
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
 * @author Vince Lance
 */
public class ModelInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String model2 = null;
    int row = -1;
    
    public ModelInternalFrame() {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
        
    }
    
    
    public void LoaddTable(){
    
        try {
            String sql = "select modelName as Model_Name from model";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);
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

        jLabel1 = new javax.swing.JLabel();
        modelbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1100, 641));
        setMinimumSize(new java.awt.Dimension(1100, 641));
        setPreferredSize(new java.awt.Dimension(1100, 641));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Model Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(325, 56, 100, 22);

        modelbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        getContentPane().add(modelbox);
        modelbox.setBounds(465, 58, 189, 22);

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
        jScrollPane1.setBounds(388, 110, 244, 323);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setText("Add Model");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(291, 501, 89, 25);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton2.setText("Edit Model");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(398, 501, 89, 25);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton3.setText("Delete Model");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(520, 501, 103, 25);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton5.setText("Generate Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(657, 501, 123, 25);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/1100.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setMaximumSize(new java.awt.Dimension(1100, 641));
        jLabel2.setMinimumSize(new java.awt.Dimension(1100, 641));
        jLabel2.setPreferredSize(new java.awt.Dimension(1100, 641));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1200, 640);

        setBounds(-5, -35, 1182, 680);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        row = jTable1.getSelectedRow();
        String model = jTable1.getValueAt(row, 0).toString();
        model2 = model;
        
        modelbox.setText(model);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String check = modelbox.getText();
        int x = check.compareTo("");
        if (x==0){
            JOptionPane.showMessageDialog(null, "Cannot Perform Action: A model should be entered");
        }
        
        else{
            String model = modelbox.getText().toUpperCase();
            Model md = new Model(model);
            try {
              md.AddModel();
             LoaddTable();
            }
            catch (SQLException ex) {
                Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        modelbox.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        if (row ==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a model before updating");
        }
        
        else{
            String model = modelbox.getText().toUpperCase();
            Model md = new Model(model);
            try {
                md.UpdateModel(model2);
                LoaddTable();
            }
            catch (SQLException ex) {
                Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            row = -1;
        }
        modelbox.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        if (row ==-1)
        {
            JOptionPane.showMessageDialog(null,"Please select a model before Deleting");
        }
        else{
            Model md = new Model(modelbox.getText());
            try {
                md.DeleteModel();
                LoaddTable();
            }
            catch (SQLException ex) {
                Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
            row = -1;
        }
        modelbox.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Compile jrxml file.
        JasperReport jasperReport;
        try {
            // Compile jrxml file.
            jasperReport = JasperCompileManager.compileReport("src/Reports/ModelsReport.jrxml");

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
                "src/jasperoutput/ModelsReport.pdf");

            System.out.println("Done!");
        } catch (JRException ex) {
            Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File("src/jasperoutput/ModelsReport.pdf");
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField modelbox;
    // End of variables declaration//GEN-END:variables
}
