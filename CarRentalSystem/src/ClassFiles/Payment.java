/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class Payment {
    int bpId;
    int bId;
    Date pDate;
    double charge;

    public Payment(int bId, Date pDate) {
        this.bId = bId;
        this.pDate = pDate;
    }
    
    public void AddPayment() throws SQLException{
        Connection conn = DBConnect.connect();
        try {

            String query = "INSERT INTO bookingpayment (rId,amount) VALUES ("+this.bId+","+this.charge+")";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Payment Processed Successfully");
        } 
        catch (Exception e) {
              System.out.println(e);
        }      
    }
    public void Accept(String regnum) throws SQLException{
    
        Vehicle v = new Vehicle();
        v.setRegno(regnum); 
        Connection conn = DBConnect.connect();
        String query = "UPDATE vehicle set availability='Available' where regNumber='"+ regnum +"'";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Vehicle Can be Rented Again");
    }
    
    public void CalculateCharge(String type, Date startDate, double addcharges) throws SQLException{
        VehicleType vt = new VehicleType();
        vt.FindVehicleType(type);
        double keymoney = vt.getKeymoney();
        double dailycharge = vt.getDailycharge();
        long timeDiff = Math.abs(this.pDate.getTime() - startDate.getTime());
        int DiffDates = (int) TimeUnit.MILLISECONDS.toDays(timeDiff);
        System.out.println(DiffDates);
        this.charge = addcharges +keymoney + (dailycharge*(DiffDates+1));
    }

    public int getBpId() {
        return bpId;
    }

    public int getbId() {
        return bId;
    }

    public Date getpDate() {
        return pDate;
    }

    public double getCharge() {
        return charge;
    }

    public void setBpId(int bpId) {
        this.bpId = bpId;
    }

    public void setbId(int bId) {
        this.bId = bId;
    }

    public void setpDate(Date pDate) {
        this.pDate = pDate;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
    
}
