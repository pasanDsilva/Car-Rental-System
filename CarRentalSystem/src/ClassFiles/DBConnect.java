package ClassFiles;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


//The Class to connect the program to the database

public class DBConnect {
     
    //Method to connect to the database
    
    public static Connection connect(){
    
        Connection conn = null;
        
        try {
            
            //Introducing the JDBC driver to the class
            
            Class.forName("com.mysql.jdbc.Driver");
            
            //Making the connection with the database
           
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/carrentalsystem","root","");
                    
        } 
        catch (Exception e) {
            
            //Promting error message to user if there is an any error with the connection
            
            System.out.println(e);
            
            
        }
        return conn;
    } 
}
