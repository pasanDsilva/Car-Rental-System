/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.DBConnect;
import ClassFiles.Vehicle;
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
public class VehiclesInternalFrame extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public VehiclesInternalFrame() throws SQLException {
        initComponents();
        con = DBConnect.connect();
        LoaddTable();
        
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        
        //model drop down
        try {
            
            String query="Select modelName from model ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("modelName");
            modelbox.addItem(a);
        }
        
        
        
        //make drop down
        try {
            
            String query="Select makeName from make ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("makeName");
            makebox.addItem(a);
        }
        
        //type drop down
        try {
            
            String query="Select typeName from vehicletype ";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            String a = rs.getString("typeName");
            typebox.addItem(a);
        }
        
        
    }
    public void LoaddTable(){
        try {
            String sql = "SELECT mk.makeName as make, ml.modelName as model, vt.typeName, v.year, v.fuelType, v.availability, v.transmission, v.regNumber FROM vehicle v, make mk, model ml,vehicletype vt WHERE v.make= mk.makeId and ml.modelID=v.model and v.type=vt.vtId";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
        } catch (Exception e) {
            System.out.println(e);  
        }
   
    }

    public boolean checkDigit(String year){
        boolean x=false;
        if((year.length()>4) || (year.length()<4)){
            x=false;
        }
        else{
            for(int i=0;i<year.length();i++){
                if (Character.isDigit(year.charAt(i))){
                    x= true;
                }
                else{
                    x= false;
                    break;
                }
            }
        }
        return x;
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        yearbox = new javax.swing.JTextField();
        regbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        modelbox = new javax.swing.JComboBox();
        typebox = new javax.swing.JComboBox();
        fuelbox = new javax.swing.JComboBox();
        tranbox = new javax.swing.JComboBox();
        availablebox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        makebox = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1100, 641));
        setMinimumSize(new java.awt.Dimension(1100, 641));
        setPreferredSize(new java.awt.Dimension(1100, 641));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Model");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(12, 116, 114, 22);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Year");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(12, 196, 114, 22);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Type");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(12, 156, 114, 22);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fuel Type");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(12, 238, 83, 22);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Availability");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(12, 280, 92, 22);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Transmission");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(12, 320, 114, 22);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Reg Number");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(12, 362, 114, 22);

        yearbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        getContentPane().add(yearbox);
        yearbox.setBounds(144, 198, 166, 22);

        regbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        regbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regboxActionPerformed(evt);
            }
        });
        getContentPane().add(regbox);
        regbox.setBounds(144, 364, 166, 22);

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
        jScrollPane1.setBounds(347, 76, 793, 318);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton1.setText("Add Vehicle");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(12, 451, 99, 25);

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton2.setText("Update Vehecle");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(129, 451, 115, 25);

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton3.setText("Delete Vehicle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(262, 451, 113, 25);

        modelbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        modelbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));
        modelbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modelboxActionPerformed(evt);
            }
        });
        getContentPane().add(modelbox);
        modelbox.setBounds(144, 116, 166, 22);

        typebox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        typebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));
        typebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeboxActionPerformed(evt);
            }
        });
        getContentPane().add(typebox);
        typebox.setBounds(144, 156, 166, 22);

        fuelbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        fuelbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Petrol", "Diesel", "Hybrid", "Electric" }));
        getContentPane().add(fuelbox);
        fuelbox.setBounds(146, 240, 166, 22);

        tranbox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        tranbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Automatic", "Manual" }));
        getContentPane().add(tranbox);
        tranbox.setBounds(144, 322, 166, 22);

        availablebox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        availablebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--", "Available", "Unavailable", "Rented" }));
        getContentPane().add(availablebox);
        availablebox.setBounds(146, 280, 164, 22);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Make");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(12, 76, 52, 22);

        makebox.setFont(new java.awt.Font("Times New Roman", 0, 13)); // NOI18N
        makebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Please Select--" }));
        getContentPane().add(makebox);
        makebox.setBounds(144, 76, 166, 22);

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 13)); // NOI18N
        jButton5.setText("Generate Report");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(401, 451, 123, 25);

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/1100.jpg"))); // NOI18N
        jLabel4.setText("jLabel4");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 1150, 530);

        setBounds(-5, -35, 1152, 566);
    }// </editor-fold>//GEN-END:initComponents

    private void regboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regboxActionPerformed

    private void typeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeboxActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String make = (String)makebox.getSelectedItem();
        int checkmake = makebox.getSelectedIndex();
        
        String model = (String)modelbox.getSelectedItem();
        int checkmodel = modelbox.getSelectedIndex();
        
        String type =  (String)typebox.getSelectedItem();
        int checktype = typebox.getSelectedIndex();
        
        String checkyear = (String)yearbox.getText();
        boolean checkyearnull = checkyear.isEmpty();
        boolean checknum = false;
        checknum = checkDigit(checkyear);
        String year = (String)(yearbox.getText());
        
        String fuel = (String)fuelbox.getSelectedItem();
        int checkfuel = fuelbox.getSelectedIndex();
        
        String available = (String)availablebox.getSelectedItem();
        int checkavailable = availablebox.getSelectedIndex();
        
        String tran = (String)tranbox.getSelectedItem();
        int checktran = tranbox.getSelectedIndex();
        
        String reg = (String)regbox.getText();
        boolean checkregnull = reg.isEmpty();
        
        boolean regvalidate = false;
        if(reg.length()==6)
        {
            for(int x =0; x<reg.length(); x++)
            {
                if(x<2)
                {
                    if(!Character.isAlphabetic(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }
                else
                {
                    if(!Character.isDigit(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }    
            }    
        }
        else if(reg.length()==7)
        {
            for(int x =0; x<reg.length(); x++)
            {
                if(x<3)
                {
                    if(!Character.isAlphabetic(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }
                else if(x>=3)
                {
                    if(!Character.isDigit(reg.charAt(x)))
                    {
                        regvalidate = false;
                        break;
                    }
                    else
                    {
                        regvalidate = true;  
                    }
                }    
            }
        }
        
        if(checkmake==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
        }
        else if(checkmodel==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
        }
        else if(checktype==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
        }
        else if(checkyearnull==true){
           JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");        
        }
        else if(checknum==false){
           JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
        }
        else if(checkfuel==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a Fueltype");
        }
        else if(checkavailable==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
        }
        else if(checktran==0){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please select a transmission");
        }
        else if(checkregnull==true){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
       }
        else if(regvalidate==false){
            JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
        }
        else{
            Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
            try {
                vehi.AddVehicle();
                LoaddTable();
            }
            catch (Exception e) {
            
                System.out.println(e);
            
            }
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int row = -1;
        row = jTable1.getSelectedRow();
        if(row !=-1)
        {    
            String make = (String)makebox.getSelectedItem();
            int checkmake = makebox.getSelectedIndex();

            String model = (String)modelbox.getSelectedItem();
            int checkmodel = modelbox.getSelectedIndex();

            String type =  (String)typebox.getSelectedItem();
            int checktype = typebox.getSelectedIndex();

            String checkyear = (String)yearbox.getText();
            boolean checkyearnull = checkyear.isEmpty();
            boolean checknum = false;
            checknum = checkDigit(checkyear);
            String year = (String)(yearbox.getText());

            String fuel = (String)fuelbox.getSelectedItem();
            int checkfuel = fuelbox.getSelectedIndex();

            String available = (String)availablebox.getSelectedItem();
            int checkavailable = availablebox.getSelectedIndex();

            String tran = (String)tranbox.getSelectedItem();
            int checktran = tranbox.getSelectedIndex();

            String reg = (String)regbox.getText();
            boolean checkregnull = reg.isEmpty();
            int checklength = reg.length();

            boolean regvalidate = false;
            if(reg.length()==6)
            {
                for(int x =0; x<reg.length(); x++)
                {
                    if(x<2)
                    {
                        if(!Character.isAlphabetic(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }
                    else
                    {
                        if(!Character.isDigit(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }    
                }    
            }
            else if(reg.length()==7)
            {
                for(int x =0; x<reg.length(); x++)
                {
                    if(x<3)
                    {
                        if(!Character.isAlphabetic(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }
                    else if(x>=3)
                    {
                        if(!Character.isDigit(reg.charAt(x)))
                        {
                            regvalidate = false;
                            break;
                        }
                        else
                        {
                            regvalidate = true;  
                        }
                    }    
                }
            }
            
            if(checkmake==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
            }
            else if(checkmodel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
            }
            else if(checktype==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
            }
            else if(checkyearnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");
            }
            else if(checknum==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
            }
            else if(checkfuel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a fueltype");
            }
            else if(checkavailable==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
            }
            else if(checktran==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a trnsmission");
            }
            else if(checkregnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
            }
            else if(regvalidate==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
            }
            else{
                String prevregnum = jTable1.getValueAt(row, 7).toString();
                Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
                int changes = prevregnum.compareTo(reg);
                int count = -1;
                if(changes ==0)
                {    
                    try {
                        vehi.UpdateVehicle();
                        LoaddTable();
                    }
                    catch (Exception e) {
                        System.out.println(e);
                    }
                }
                else
                {
                    try 
                    {
                        count = vehi.FindVehicleCount();
                    } 
                    catch (SQLException ex) 
                    {
                        Logger.getLogger(VehiclesInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(count == 0)
                    {    
                        try {
                            vehi.UpdateVehicle(prevregnum);
                            LoaddTable();
                        } catch (SQLException ex) 
                        {
                            Logger.getLogger(VehiclesInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Cannot Update Vehicle. Registration Number : "+reg+" has been already Registered with another Vehicle");
                    }
                }    
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle to Update From the List");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = -1;
        row = jTable1.getSelectedRow();
        if(row !=-1)
        {  
            String make = (String)makebox.getSelectedItem();
            int checkmake = makebox.getSelectedIndex();

            String model = (String)modelbox.getSelectedItem();
            int checkmodel = modelbox.getSelectedIndex();

            String type =  (String)typebox.getSelectedItem();
            int checktype = typebox.getSelectedIndex();

            String checkyear = (String)yearbox.getText();
            boolean checkyearnull = checkyear.isEmpty();
            boolean checknum = false;
            checknum = checkDigit(checkyear);
            String year = (String)yearbox.getText();

            String fuel = (String)fuelbox.getSelectedItem();
            int checkfuel = fuelbox.getSelectedIndex();

            String available = (String)availablebox.getSelectedItem();
            int checkavailable = availablebox.getSelectedIndex();

            String tran = (String)tranbox.getSelectedItem();
            int checktran = tranbox.getSelectedIndex();

            String reg = (String)regbox.getText();
            boolean checkregnull = reg.isEmpty();
            int checklength = reg.length();

            if(checkmake==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a make");
            }
            else if(checkmodel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a model");
            }
            else if(checktype==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a type");
            }
            else if(checkyearnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter a year");
            }
            else if(checknum==false){
                JOptionPane.showMessageDialog(null, "Cannot perform action : Entered year is Invalid");
            }
            else if(checkfuel==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a fueltype");
            }
            else if(checkavailable==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select the availability");
            }
            else if(checktran==0){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please select a trnsmission");
            }
            else if(checkregnull==true){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter the registration number");
            }
            else if(checklength>7){
                JOptionPane.showMessageDialog(null, "Cannot perform action : please enter valid registration number");
            }
            else{
                Vehicle vehi = new Vehicle(make,model,type,year,fuel,available,tran,reg);
                try {
                    vehi.DeleteVehicle();
                    LoaddTable();
                }
                catch (Exception e) {

                    System.out.println(e);

                }
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Please Select a Vehicle to Delete From the List");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        
        int row = jTable1.getSelectedRow();
        
        String make = jTable1.getValueAt(row, 0).toString();
        String model = jTable1.getValueAt(row, 1).toString(); 
        String type = jTable1.getValueAt(row, 2).toString();
        String year = jTable1.getValueAt(row, 3).toString();
        String fueltype = jTable1.getValueAt(row, 4).toString();
        String availability = jTable1.getValueAt(row, 5).toString();
        String tran = jTable1.getValueAt(row, 6).toString();
        String regno = jTable1.getValueAt(row, 7).toString();
        
        
       makebox.setSelectedItem(make);
       modelbox.setSelectedItem(model);
       typebox.setSelectedItem(type);
       yearbox.setText(year);
       fuelbox.setSelectedItem(fueltype);
       availablebox.setSelectedItem(availability);
       tranbox.setSelectedItem(tran);
       regbox.setText(regno);
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void modelboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modelboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_modelboxActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Compile jrxml file.
        JasperReport jasperReport;
        try {
            // Compile jrxml file.
            jasperReport = JasperCompileManager.compileReport("src/Reports/VehiclesReport.jrxml");

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
                "src/jasperoutput/VehiclesReport.pdf");

            System.out.println("Done!");
        } catch (JRException ex) {
            Logger.getLogger(CustomersInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        File file = new File("src/jasperoutput/VehiclesReport.pdf");
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
    private javax.swing.JComboBox availablebox;
    private javax.swing.JComboBox fuelbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox makebox;
    private javax.swing.JComboBox modelbox;
    private javax.swing.JTextField regbox;
    private javax.swing.JComboBox tranbox;
    private javax.swing.JComboBox typebox;
    private javax.swing.JTextField yearbox;
    // End of variables declaration//GEN-END:variables
}
