
package ClassFiles;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Admin {
    private String aid;
    private String name;
    private String username;
    private String password;
    private String email;
    private String phone;
    
    
    //Constructors
    public Admin() {
    }

    public Admin(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public Admin(String aid, String name, String username, String password, String email, String phone) {
        this.aid = aid;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public Admin(String name, String username, String password, String email, String phone) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }
    
    public Admin(String name, String username, String email, String phone) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }


    
    
    
    //Methods
    public boolean FindAdmin() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from admin where username = '" +this.username+ "' OR email = '" +this.email + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    public int FindAdminCount() throws SQLException{
        int count = 0;
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from admin where username = '" +this.username+ "' OR email = '" +this.email + "'";
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
    
    public boolean FindAdminFromUsername() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from admin where username = '" +this.username+ "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    public boolean FindAdminFromEmail() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from admin where email = '" +this.email + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next(); //System.out.println("empty");
    }
    
    
    public boolean AddAdmin() throws SQLException{
        if(FindAdmin())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. User Already Exists");
            return false;
        }
        else
        {
            Connection conn = DBConnect.connect();
            try {

                String query = "INSERT INTO admin (name, username, password, email, phone) VALUES ( '" +this.name+ "', '" +this.username+ "', '"+ this.password + "', '" + this.email +"', '" + phone +"')";
                PreparedStatement stmnt = conn.prepareStatement(query);
                stmnt.execute();
            } 
            catch (Exception e) {
                  System.out.println(e);
                  return false;
            }
            JOptionPane.showMessageDialog(null, "Admin Added Successfully");
            return true;
        }
    }
    
    public boolean UpdateAdmin(String inputUname) throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE admin SET name='"+ this.name +"',username='"+ this.username +"',email='"+ this.email +"',phone='"+ this.phone +"' where username = '" + inputUname + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Admin Updated Successfully");
        return true;
    }
    
    public boolean UpdateAdmin() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE admin SET name='"+ this.name +"',username='"+ this.username +"',email='"+ this.email +"',phone='"+ this.phone +"' where username = '" + this.username + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Admin Updated Successfully");
        return true;    
    }
    
    public boolean ChangeAdminPassword() throws SQLException{ 
        Connection conn = DBConnect.connect();
        try {

            String query = "UPDATE admin SET password='"+ this.password +"' where username = '" + this.username + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
        }
        catch (Exception e){

            System.out.println(e);
            return false;
        }
        JOptionPane.showMessageDialog(null, "Admin Password Changed Successfully");
        return true;
    }
    
    public void DeleteAdmin(){
    
        Connection conn = DBConnect.connect();
        try {
            
            String query="DELETE from admin where username='"+ this.username +"'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            stmnt.execute();
           
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        JOptionPane.showMessageDialog(null, "Admin Deleted Successfully");
    }
    
    public boolean LogInAdmin() throws SQLException{
        ResultSet rs = null;
        Connection conn = DBConnect.connect();
        try {
            
            String query="Select name from admin where username = '" +this.username+ "' and password = '" +this.password + "'";
            PreparedStatement stmnt = conn.prepareStatement(query);
            rs = stmnt.executeQuery();
            
        } catch (Exception e){
            
            System.out.println(e);
            
        }
        return rs.next();
    }
    
    
    
    
    //Setters

    public void setAid(String aid) {
        this.aid = aid;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    //Getters

    public String getAid() {
        return aid;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

   
}
