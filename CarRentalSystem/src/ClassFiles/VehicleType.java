/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Vince Lance
 */
public class VehicleType {
    
    private int typeID; 
    private String typeName;
    private double keymoney;
    private double dailycharge;
    
    public VehicleType(){ 
    }

    public VehicleType(String typeName,double keymoney,double dailycharge)
    {
        this.keymoney=keymoney;
        this.typeName=typeName;
        this.dailycharge=dailycharge;
    }

    public boolean FindVehicleType() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select typeName from vehicletype where typeName= '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next();
    }

    public int FindVehicleTypeCount() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select typeName from vehicletype where typeName= '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        while(rs.next())
        {
            count++;
        }
        return count;
    }
    
    public void FindVehicleType(String tName) throws SQLException{
        ResultSet rs = null;
        this.typeName = tName;
        int typeid = 0;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select vtId, keymoney, dailycharge from vehicletype where typeName= '" +tName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        int x = 0;
        while((rs.next()&&(x<1)))
        {
            this.typeID = rs.getInt("vtId");
            this.keymoney = rs.getDouble("keymoney");
            this.dailycharge = rs.getDouble("dailycharge");
            x++;
        }
//        System.out.println(this.typeID);
//        System.out.println(this.typeName);
//        System.out.println(this.dailycharge);
//        System.out.println(this.keymoney);
    }

    
    public void AddVehicleType() throws SQLException{
        if(FindVehicleType())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Vehicle type Already Exists");
            
        }
        else
        {
            Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO vehicletype (typeName,keymoney,dailycharge) VALUES ('" +this.typeName+ "', '"+ this.keymoney + "', '" + this.dailycharge+"')";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  
            }
            JOptionPane.showMessageDialog(null, "Vehicle Type Added Successfully");
            
        }
    }

    
    public boolean UpdateVehicleType() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicletype SET typeName='"+ this.typeName +"',keymoney='"+ this.keymoney+"' where typename = '" +this.typeName+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "VehicleType Updated Successfully");
        }
        catch (Exception e){

            System.out.println(e);
        }
        return true;
    }
    
    public boolean UpdateVehicleType(String inputvtype) throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicletype SET typeName='"+ this.typeName +"',keymoney='"+ this.keymoney+"' where typename = '" +inputvtype+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "VehicleType Updated Successfully");
        }
        catch (Exception e){

            System.out.println(e);
        }
        return true;
    }
    
    public void DeleteVehicleType(){
    
        Connection conn = DBConnect.connect();
        try {
            
            String query="DELETE from vehicletype where typeName='"+ this.typeName +"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
           
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        JOptionPane.showMessageDialog(null, "Vehicle Type Deleted Successfully");
    }

    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    public double getKeymoney() {
        return keymoney;
    }

    public double getDailycharge() {
        return dailycharge;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setKeymoney(double keymoney) {
        this.keymoney = keymoney;
    }

    public void setDailycharge(double dailycharge) {
        this.dailycharge = dailycharge;
    }

    
    
}