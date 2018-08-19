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
 * @author Dilshan Wimalasuriya
 */
public class Customer {
        private int cid;
        private String name;
        private String username;
        private String password;
        private String DLnumber;
        private String phone;
        private String email;
        private String address;
        private int points;
       
// Constructors

    public Customer() {
    }

    public Customer(String username, String email) {
        this.email = email;
        this.username = username;
    }

    public Customer(int cid, String name, String username, String password, String DLnumber, String phone, String email, String address, int points) {
        this.cid = cid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.DLnumber = DLnumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.points = points;
    }

    public Customer(String name, String username, String password, String DLnumber, String phone, String email, String address, int points) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.DLnumber = DLnumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.points = points;
    }

    public Customer(String name, String username, String DLnumber, String phone, String email, String address, int points) {
        this.name = name;
        this.username = username;
        this.DLnumber = DLnumber;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.points = points;
    }

    
    
     //Methods
    public boolean FindCustomer() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from customer where username = '" +this.username+ "' OR email = '" +this.email + "' OR dLNumber='"+this.DLnumber+"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    public boolean FindCustomerFromUsername() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from customer where username = '" +this.username+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    public boolean FindCustomerFromEmail() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from customer where email = '" +this.email+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    public boolean FindCustomerFromDLNumber() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from customer where dLNumber = '" +this.DLnumber+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    public int FindCustomerCount() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {

            String query="Select name from customer where username = '" +this.username+ "' OR email = '" +this.email + "' OR dLNumber='"+this.DLnumber+"'";
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
    
    
    public boolean AddCustomer () throws SQLException{
        if(FindCustomer())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. User Already Exists");
            return false;
        }
        else
        {
            Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO customer (name, username, password, email, phone, dLNumber, address ) VALUES ( '" +this.name+ "', '" +this.username+ "', '"+ this.password + "', '" + this.email +"', '" + this.phone +"' , '" +this.DLnumber + "', '"+this.address+"')";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  return false;
            }
            JOptionPane.showMessageDialog(null, "Customer Registered Successfully");
            return true;
        }
    }
    
    public boolean UpdateCustomer(String inputUsername) throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE customer SET name='"+ this.name +"',username='"+ this.username +"',email='"+ this.email +"',phone='"+ this.phone +"', dLNumber = '"+this.DLnumber+"', address = '"+this.address +"' , loyaltyPoints="+this.points+" where username = '" + inputUsername + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            System.out.println("prped");
            stmnt.execute();
            System.out.println("execu");
        }
        catch (Exception e){
            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
        return true;
    }
    
    public boolean UpdateCustomer() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE customer SET name='"+ this.name +"',username='"+ this.username +"',email='"+ this.email +"',phone='"+ this.phone +"', dLNumber = '"+this.DLnumber+"', address = '"+this.address +"', loyaltyPoints="+this.points+" where username = '" + this.username + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Customer Updated Successfully");
        return true;
        
    }
    
    public boolean UpdateCustomerPoints(int cid, int points) throws SQLException{ 
        Connection conn = DBConnect.connect();
        this.points = this.points + points;
        try {

            String query = "UPDATE customer SET loyaltyPoints="+this.points+" where customerId ="+this.cid+"";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        return true;        
    }
    
    public void FindCustomerPointBalance() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {

            String query="select loyaltyPoints from customer where customerId="+this.cid+"";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();

        } catch (Exception e){

            System.out.println(e);

        }
        while(rs.next()&&(count<1))
        {
            this.points = rs.getInt("loyaltyPoints");
            count++;
        }
        System.out.println(this.points);
    }
    
    public boolean ChangeCustomerPassword() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {
            String query = "UPDATE customer SET password='"+ this.password +"' where username = '" + this.username + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();     
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Customer Password Changed Successfully");
        return true;
    }
    
    public boolean ResetCustomerPassword() throws SQLException{ 
        if(FindCustomerCount()!=1)
        {
            JOptionPane.showMessageDialog(null, "You have not Registered. Please Register using the Sign Up option");
            return false;
        }
        else
        {
            Connection conn = DBConnect.connect();
            try {
                String query = "UPDATE customer SET password='"+ this.password +"' where dLNumber = '" + this.DLnumber + "'";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
                JOptionPane.showMessageDialog(null, "Your Password Changed Successfully");
            }
            catch (Exception e){

                System.out.println(e);
                return false;
            }
            JOptionPane.showMessageDialog(null, "Your Password Changed Successfully");
            return true;
        }
    }
    
    public void DeleteCustomer(){
    
        Connection conn = DBConnect.connect();
        try {
            
            String query="DELETE from customer where username='"+ this.username +"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
            JOptionPane.showMessageDialog(null, "Customer Deleted Successfully");
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        
    }
    
    public ResultSet LogInCustomer() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="SELECT customerId, name, username, password, dLNumber, phone, email, address, loyaltyPoints FROM customer where username = '" +this.username+ "' and password = '" +this.password + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs;
    }
    
    
    

//Getters

    public int getCid() {
        return cid;
    }

    public String getDLnumber() {
        return DLnumber;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }
    
 //Setters

    public void setCid(int cid) {
        this.cid = cid;
    }

    public void setDLnumber(String DLnumber) {
        this.DLnumber = DLnumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    

}

