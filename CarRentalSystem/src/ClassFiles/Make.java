/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassFiles;

import ClassFiles.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Thimothy
 */
public class Make {
    private int makeId;
    private String makeName;
    
    public Make(){
    
}
  public Make(String name){
      this.makeName=name ;
    
}         
  
  //Methods
  
public boolean FindMake()throws SQLException{
     ResultSet rs = null;
     Connection con = DBConnect.connect();
     try {
        String AD ="SELECT makeName FROM make WHERE makeName = '"+this.makeName+"'";
         PreparedStatement pst = con.prepareStatement(AD);
         rs = pst.executeQuery();
         
    } catch (Exception e)
    {
         System.out.println(e);
    }
     return rs.next();//print "Empty"
}

public int FindMakeCount()throws SQLException{
     int count = 0;
     ResultSet rs = null;
     Connection con = DBConnect.connect();
     try {
         String AD ="SELECT makeName FROM make WHERE makeName = '"+this.makeName+"'";
         PreparedStatement pst = con.prepareStatement(AD);
         rs = pst.executeQuery();
        
    } catch (Exception e) 
    {
        System.out.println(e);
    }
      while(rs.next())
        {
            count++;
        }
        return count;
}
    
 
  
    
   public void AddMake() throws SQLException{
       if(FindMake())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Make Already Exists");
        }
        else
        {
        Connection con = DBConnect.connect();
        
        
        try {
        String AD = "INSERT INTO make (makeName) values ('"+ this.makeName +"') ";
        PreparedStatement pst = con.prepareStatement(AD);
        pst.execute();
         JOptionPane.showMessageDialog(null, "Make Added Successfully");
        } catch (Exception e) 
        {
            System.out.println(e);
        }
     
    }
   }
   
   
   

public boolean UpdateMake(String inputmake)throws SQLException{
     if(FindMakeCount()>=1)
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Make name :'"+this.makeName+"' Has Been Already Added");
            return false;
        }
        else
        {
      Connection con = DBConnect.connect();
      
      try {
      String AD = "UPDATE make SET makeName='"+this.makeName+"' where makeName='"+ inputmake +"'";
      PreparedStatement pst = con.prepareStatement(AD);
      pst.execute();
        JOptionPane.showMessageDialog(null, "Make Updated Successfully");
    } catch (Exception e)
    {
        System.out.println(e);
    }
    return true;
        }
}

 public void DeleteMake()throws SQLException{
         Connection con = DBConnect.connect();
         
         try {
             String AD = "DELETE from make where makeName='"+this.makeName+"'";
             PreparedStatement pst = con.prepareStatement(AD);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Make Deleted Successfully");
         } catch (Exception e)
         {
             System.out.println(e);
         }
}
 

 //setters
   public void setName(String name) {
        this.makeName = name;
    }
 //getters
  public String getName() {
        return makeName;
    }
  
  

    }

 //To change body of generated methods, choose Tools | Templates.
   


