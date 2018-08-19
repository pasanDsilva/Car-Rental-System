/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class Booking {
    int bId;
    int vehicleId;
    int vtId;
    int customerId;
    Date startDate;
    Date endDate;
    double charge;

    public Booking() {
    }

    public Booking(int bId) {
        this.bId = bId;
    }

    
    public Booking(int vehicleId, int vtId, int customerId, Date startDate, Date endDate) {
        this.vehicleId = vehicleId;
        this.vtId = vtId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public Booking(int bid,int vehicleId, int vtId, int customerId, Date startDate, Date endDate) {
        this.bId = bid;
        this.vehicleId = vehicleId;
        this.vtId = vtId;
        this.customerId = customerId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    
    public boolean AddBooking(double keymoney, double dailycharge){
        CalculateCharge(keymoney, dailycharge);
        String sd = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String ed = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO booking (vehicleId,vtId,customerId,startDate,endDate,charge) VALUES ("+this.vehicleId+","+this.vtId+","+this.customerId+",'"+sd+"','"+ed+"',"+this.charge+")";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  return false;
            }
            JOptionPane.showMessageDialog(null, "Booking Made Successfully");
        return true;
    }
    public boolean UpdateBooking(double keymoney, double dailycharge){
        CalculateCharge(keymoney, dailycharge);
        String sd = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        String ed = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
        Connection conn = DBConnect.connect();
            try {

                String query = "UPDATE booking SET vtId="+this.vtId+",startDate='"+sd+"',endDate='"+ed+"',charge="+this.charge+" WHERE bid="+this.bId+"";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  return false;
            }
            JOptionPane.showMessageDialog(null, "Booking Updated Successfully");
        return true;
    }
    
    public void CalculateCharge(double keymoney, double dailycharge){
        long timeDiff = Math.abs(this.endDate.getTime() - this.startDate.getTime());
        int DiffDates = (int) TimeUnit.MILLISECONDS.toDays(timeDiff);
        this.charge = keymoney + (dailycharge*(DiffDates+1));
    }
    
    public void UpdateBooking() throws SQLException{
    
        Connection conn = DBConnect.connect();
        String query = "UPDATE booking set vehicleId='"+ this.vehicleId +"' , customerId='"+ this.customerId +"' , startDate='"+ this.startDate +"' , endDate='"+ this.endDate +"' , charge='"+ this.charge +"'";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Booking Updated Successfully");

    }
    
    public void DeleteBooking() throws SQLException{
    
        Connection conn = DBConnect.connect();
        String query="DELETE from booking where bid='"+ this.bId +"'";
        PreparedStatement stmnt = conn.prepareStatement(query);
        stmnt.execute();
        JOptionPane.showMessageDialog(null, "Booking Deleted Successfully");
    
    }
    
    public void Rent(String regnum,int bid) throws SQLException{
    
        Vehicle v = new Vehicle();
        v.setRegno(regnum);
        boolean status = v.FindAvailableVehicles();
        if(status)
        {    
            Connection conn = DBConnect.connect();
            String query = "UPDATE booking SET vehicleId=(select vehicleId from vehicle where regNumber='"+ regnum +"') where bid='"+ bid +"'";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();
            query = "UPDATE vehicle set availability='Rented' where regNumber='"+ regnum +"'";
            stmt = conn.prepareStatement(query);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Vehicle Rented");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Entered Vehicle is not Registered in the System or Vehicle is not availabel");
        }
    }
    
    
    public int getbId() {
        return bId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public int getVtId() {
        return vtId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getCharge() {
        return charge;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public void setVtId(int vtId) {
        this.vtId = vtId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
    
    
}
