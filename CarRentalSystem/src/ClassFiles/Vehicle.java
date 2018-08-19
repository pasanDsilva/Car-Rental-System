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
public class Vehicle {
    
    
    private int vid;
    private String make;
    private String model;
    private String type;
    private String year;
    private String fueltype;
    private String availability;
    private String transmission;
    private String regno;

    public Vehicle() {
    }

    
    
    
    public Vehicle(String make, String model, String type, String year , String fueltype, String availability, String transmission, String regno) {
        
        this.make = make;
        this.model = model;
        this.type = type;
        this.year = year;
        this.fueltype = fueltype;
        this.availability = availability;
        this.transmission = transmission;
        this.regno = regno;
    }
    
    
    public boolean FindVehicle() throws SQLException{
    
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select regNumber from vehicle where regNumber = '" +this.regno+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next();
    }
    
    public boolean FindAvailableVehicles() throws SQLException{
    
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select regNumber from vehicle where regNumber = '" +this.regno+ "' AND availability='Available'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next();
    }
    
    
    public void AddVehicle() throws SQLException{
    
        if(FindVehicle())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Vehicle already Exists");
        }
        
        else
        {
            Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO vehicle ( make, model, type, year , fuelType, availability, transmission, regNumber) VALUES ((Select makeId from make where makeName = '"+ this.make +"'),(select modelID from model where modelName = '"+ this.model +"'),(select vtId from vehicletype where typeName='"+ this.type +"'),'"+ this.year +"','"+ this.fueltype +"','"+ this.availability +"','"+ this.transmission +"','"+ this.regno +"')";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
                JOptionPane.showMessageDialog(null, "Vehicle Added Successfully");
            } 
            catch (Exception e) {
                  System.out.println(e);
            }
        }
    
    }
    
    public int FindVehicleCount() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select regNumber from vehicle where regNumber = '" +this.regno+ "' ";
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
    
    
    public void UpdateVehicle() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicle SET make=(Select makeId from make where makeName = '"+ this.make +"'), model=(select modelID from model where modelName = '"+ this.model +"'), type=(Select vtId from vehicletype where typeName ='"+this.type+"'), year='"+ this.year +"', fuelType='"+ this.fueltype +"', availability='"+ this.availability +"', transmission='"+ this.transmission +"', regNumber='"+ this.regno +"' where regNumber = '" + this.regno + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Vehicle Updated Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public void UpdateVehicle(String newRegNo) throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE vehicle SET make=(Select makeId from make where makeName = '"+ this.make +"'), model=(select modelID from model where modelName = '"+ this.model +"'), type=(Select vtId from vehicletype where typeName ='"+this.type+"'), year='"+ this.year +"', fuelType='"+ this.fueltype +"', availability='"+ this.availability +"', transmission='"+ this.transmission +"', regNumber='"+ this.regno +"' where regNumber = '" + newRegNo + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Vehicle Updated Successfully");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    
    public void DeleteVehicle(){
    
        Connection conn = DBConnect.connect();
        try {
            
            String query="DELETE from vehicle where regNumber='"+ this.regno +"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Vehicle Deleted Successfully");
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        
    }
    
    
    //setters
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }
    
    
    //getters

    public String getMake() {
        return make;
    }
    
    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getYear() {
        return year;
    }

    public String getFueltype() {
        return fueltype;
    }

    public String getAvailability() {
        return availability;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getRegno() {
        return regno;
    }
    
    
    
}
