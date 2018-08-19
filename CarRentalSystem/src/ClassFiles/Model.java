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


public class Model {
    
    private int modelID;
    private String modelName;
    
    public Model(){
    
}
  public Model(String name){
      this.modelName=name ;
    
}    
  
  public boolean FindModel()throws SQLException{
     ResultSet rs = null;
     Connection con = DBConnect.connect();
     try {
        String D ="SELECT modelName FROM model WHERE modelName = '"+this.modelName+"'";
        PreparedStatement pst = con.prepareStatement(D);
        rs = pst.executeQuery();
         
    } catch (Exception e)
    {
         System.out.println(e);
    }
     return rs.next();//print "Empty"
}
  
  
  public int FindModelCount()throws SQLException{
     int count = 0;
     ResultSet rs = null;
     Connection con = DBConnect.connect();
     try {
         String D ="SELECT modelName FROM model WHERE modelName = '"+this.modelName+"'";
         PreparedStatement pst = con.prepareStatement(D);
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
    
  
  
     public void AddModel() throws SQLException{
         if(FindModel())
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Model Already Exists");
        }
        else
        {
        Connection con = DBConnect.connect();
        
        
        try {
        String D = "INSERT INTO model (modelName) values ('"+ this.modelName +"') ";
        PreparedStatement st = con.prepareStatement(D);
        st.execute();
         JOptionPane.showMessageDialog(null, "Model Added Successfully");
        } catch (Exception e) 
        {
            System.out.println(e);
        }
     
    }
     }
     
    
    public boolean UpdateModel(String inputmodel)throws SQLException{
        if(FindModelCount()>=1)
        {
            JOptionPane.showMessageDialog(null, "Cannot Perform Action. Model name :'"+this.modelName+"' Has Been Already Added");
            return false;
        }
        else
        {
            Connection con = DBConnect.connect();
      
            try {
                String D= "UPDATE model SET modelName='"+this.modelName+"' where modelName='"+ inputmodel +"'";
                PreparedStatement st = con.prepareStatement(D);
                st.execute();
                JOptionPane.showMessageDialog(null, "Model Updated Successfully");
            }
            catch (Exception e){
                System.out.println(e);
            }
            return true;
        }
    }
     public void DeleteModel()throws SQLException{
         Connection con = DBConnect.connect();
         
         try {
             String D = "DELETE from model where modelName='"+this.modelName+"'";
             PreparedStatement st = con.prepareStatement(D);
             st.execute();
             JOptionPane.showMessageDialog(null, "Model Deleted Successfully");
         } catch (Exception e)
         {
             System.out.println(e);
         }
}
     
      //getters
  public String getName() {
        return modelName;
    }
  
  //setters
   public void setName(String name) {
        this.modelName = name;
    }
}
