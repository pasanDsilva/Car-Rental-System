/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.Booking;
import ClassFiles.DBConnect;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class CustomerAdminViewPayments extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String model2 = null;
    int row = -1;
    int cid;
    int bpid;
    
    public CustomerAdminViewPayments() {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
    }
    
    
    public void LoaddTable(){
    
        try {
            String sql = "select bid as Booking_ID,c.name as Customer_Name,b.customerId as Customer_ID,vt.typeName as Vehicle_Type,v.regNumber ,b.StartDate as Start_Date,CAST(bp.payDate as Date) as End_Date,CAST(bp.payDate as Time) as Paid_Time,bp.amount as Charge from booking b, customer c, vehicletype vt, vehicle v,bookingpayment bp where bp.rId=b.bid AND b.vehicleId=v.vehicleId AND b.vehicleId!=0 AND vt.vtId=b.vtId AND b.customerId=c.customerId AND b.bid IN (select rId from bookingpayment)";
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        error = new javax.swing.JLabel();
        subpane = new javax.swing.JDesktopPane();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1387, 435));
        setMinimumSize(new java.awt.Dimension(1387, 435));
        getContentPane().setLayout(null);

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
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
        jScrollPane1.setBounds(45, 11, 794, 265);
        getContentPane().add(error);
        error.setBounds(767, 323, 626, 0);

        subpane.setBackground(new java.awt.Color(240, 240, 240));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton2.setText("Get Invoice");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout subpaneLayout = new javax.swing.GroupLayout(subpane);
        subpane.setLayout(subpaneLayout);
        subpaneLayout.setHorizontalGroup(
            subpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subpaneLayout.createSequentialGroup()
                .addComponent(jButton2)
                .addGap(0, 7, Short.MAX_VALUE))
        );
        subpaneLayout.setVerticalGroup(
            subpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, subpaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        subpane.setLayer(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        getContentPane().add(subpane);
        subpane.setBounds(370, 300, 110, 50);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/1387.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1387, 435));
        jLabel1.setMinimumSize(new java.awt.Dimension(1387, 435));
        jLabel1.setPreferredSize(new java.awt.Dimension(1387, 435));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 890, 400);

        setBounds(-5, -35, 1230, 656);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        row = jTable1.getSelectedRow();
        bpid = (int) jTable1.getValueAt(row, 0);
        cid = (int) jTable1.getValueAt(row, 2);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        row = jTable1.getSelectedRow();
        if(row != -1)
        {
            // TODO add your handling code here:
            // Compile jrxml file.
            JasperReport jasperReport;
            try {
                // Compile jrxml file.
                jasperReport = JasperCompileManager.compileReport("src/Reports/Invoice.jrxml");

                // Parameters for report
                Map<String, Object> parameters = new HashMap<String, Object>();

                // DataSource
                parameters.put("Parameter1",cid);
                parameters.put("Parameter2",bpid);
                System.out.println(cid);
                System.out.println(bpid);
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
                    "src/jasperoutput/Invoice.pdf");

                System.out.println("Done!");
            } catch (JRException ex) {
                Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            File file = new File("src/jasperoutput/Invoice.pdf");
            if(file.exists())
            {
                try {
                    Desktop.getDesktop().open(file);
                } catch (IOException ex) {
                    Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select The Payment You Want To Generate the Invoice First");
        }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel error;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JDesktopPane subpane;
    // End of variables declaration//GEN-END:variables
}
