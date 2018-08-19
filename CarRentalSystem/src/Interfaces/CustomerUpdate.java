/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import ClassFiles.Customer;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dilshan Wimalasuriya
 */
public class CustomerUpdate extends javax.swing.JInternalFrame {

    /**
     * Creates new form AdminRegister
     * @param name
     * @param username
     * @param tphone
     * @param mail
     */

    private String name1;
    private String username1;
    private String lnum1;
    private String email1;
    private String phonenum1;
    private String addrss1;
    private String points1;
    CustomersInternalFrame cus;
       public CustomerUpdate() {
        initComponents();
    }

    public CustomerUpdate(String name1, String username1, String lnum1, String email1, String phonenum1, String addrss1, String points1,CustomersInternalFrame cus) {
        initComponents();
        this.name1 = name1;
        this.username1 = username1;
        this.lnum1 = lnum1;
        this.email1 = email1;
        this.phonenum1 = phonenum1;
        this.addrss1 = addrss1;
        this.points1 = points1;
        this.cus = cus;
        lname.setText(name1);
        uname.setText(username1);
        email.setText(email1);
        phone.setText(phonenum1);
        dlnum.setText(lnum1);
        addr.setText(addrss1);
        point.setText(points1);
    }
      
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        register = new javax.swing.JButton();
        uname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        resetbutton = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        dlnum = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        point = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        addr = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setBorder(null);
        setMaximumSize(new java.awt.Dimension(1020, 410));
        setMinimumSize(new java.awt.Dimension(1020, 410));
        getContentPane().setLayout(null);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("E-mail");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(153, 142, 40, 17);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Phone");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(153, 178, 38, 17);

        lname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname);
        lname.setBounds(329, 28, 169, 23);

        phone.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        phone.setText("947XXXXXXXX");
        phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                phoneFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                phoneFocusLost(evt);
            }
        });
        phone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                phoneMouseClicked(evt);
            }
        });
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        phone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                phoneKeyPressed(evt);
            }
        });
        getContentPane().add(phone);
        phone.setBounds(329, 175, 169, 23);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Full Name");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(153, 31, 63, 17);

        register.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        register.setText("Update");
        register.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerActionPerformed(evt);
            }
        });
        getContentPane().add(register);
        register.setBounds(540, 120, 75, 25);

        uname.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        uname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unameActionPerformed(evt);
            }
        });
        getContentPane().add(uname);
        uname.setBounds(329, 98, 169, 23);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Username");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(153, 101, 62, 17);

        email.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(329, 139, 169, 23);

        resetbutton.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        resetbutton.setText("Reset");
        resetbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(resetbutton);
        resetbutton.setBounds(540, 170, 75, 25);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Address");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(153, 216, 49, 17);

        dlnum.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        dlnum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dlnumActionPerformed(evt);
            }
        });
        getContentPane().add(dlnum);
        dlnum.setBounds(329, 62, 169, 23);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Driving Licence Number");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(153, 65, 150, 17);

        point.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        point.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                pointFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                pointFocusLost(evt);
            }
        });
        point.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pointMouseClicked(evt);
            }
        });
        point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pointActionPerformed(evt);
            }
        });
        point.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pointKeyPressed(evt);
            }
        });
        getContentPane().add(point);
        point.setBounds(329, 276, 169, 23);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Points");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(153, 279, 38, 17);

        addr.setColumns(20);
        addr.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        addr.setRows(5);
        jScrollPane1.setViewportView(addr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(329, 216, 169, 42);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/1020.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(1020, 410));
        jLabel1.setMinimumSize(new java.awt.Dimension(1020, 410));
        jLabel1.setPreferredSize(new java.awt.Dimension(1020, 410));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-2, 0, 940, 380);

        setBounds(-5, -35, 938, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

    private void phoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusGained
        phone.setText("947");
    }//GEN-LAST:event_phoneFocusGained

    private void phoneFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_phoneFocusLost

    }//GEN-LAST:event_phoneFocusLost

    private void phoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_phoneMouseClicked
        phone.setText("947");
    }//GEN-LAST:event_phoneMouseClicked

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void phoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_phoneKeyPressed

    }//GEN-LAST:event_phoneKeyPressed

    private void registerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerActionPerformed

        String lnam = lname.getText();
        String unam = uname.getText();
        String emai = email.getText();
        String phon = phone.getText();
        String name = lnam;
        String dlnumber = dlnum.getText();
        String address = addr.getText();
        String points = point.getText();

        int atchar = -2;
        int dot = -1;
        for(int x = 0; x< emai.length(); x++)
        {
            if(emai.charAt(x) == '@')
            {
                atchar = x;
            }
            else if (emai.charAt(x) == '.')
            {
                dot = x;
            }
        }

        boolean checkphone = false;

        for (int y=0; y<phon.length(); y++)
        {
            if(Character.isDigit(phon.charAt(y)))
            {
                checkphone = true;
            }
            else
            {
                checkphone = false;
                break;
            }
        }

        boolean checklicence = false;

        for(int x = 1; x<dlnumber.length(); x++)
        {
            if(Character.isDigit(dlnumber.charAt(x)))
            {
                checklicence = true;
            }
            else
            {
                checklicence = false;
                break;
            }
        }
        
        boolean checkpoints = false;
        
        for (int y=0; y<points.length(); y++)
        {
            if(Character.isDigit(points.charAt(y)))
            {
                checkpoints = true;
            }
            else
            {
                checkpoints = false;
                break;
            }
        }

        
        if(lnam.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Name");
        }
        else if(unam.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Username");
        }
        else if(dlnumber.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Driving Licence Number");
        }
        else if(emai.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter an E-mail");
        }
        else if(phon.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter a Phone number");
        }
        else if(address.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please enter an Address");
        }
        else if ((dot<atchar) || (dot == -1) || (atchar == -2))
        {
            JOptionPane.showMessageDialog(null, "Entered Email is not an valid Email address");
        }
        else if((phon.length()!=11) || (phon.charAt(0) != '9') || (phon.charAt(1) != '4') || (phon.charAt(2) != '7') || (checkphone == false))
        {
            JOptionPane.showMessageDialog(null, "Invalid Phone number. You must use 94700000000 Format");
        }
        else if(dlnumber.charAt(0) != 'B')
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. Must Start with letter 'B'");
        }
        else if(dlnumber.length() <6)
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. It should contain 6 or more numbers statring with 'B'");
        }
        else if(!checklicence)
        {
            JOptionPane.showMessageDialog(null, "Invalid Driving Licence number. Must contain only numbers after 'B'");
        }
        else if(!checkpoints)
        {
            JOptionPane.showMessageDialog(null, "Points Feild can have only numbers");
        }
        else
        {
            int pointsint = Integer.parseInt(points);
            int x = JOptionPane.showConfirmDialog(null,"Do You Really Want To Update This User?");
            int usernamecheck = username1.compareTo(unam);
            int emailcheck = emai.compareTo(email1);
            int licencecheck = lnum1.compareTo(dlnumber);
            System.out.println("username"+usernamecheck);
            System.out.println("email"+emailcheck);
            System.out.println("licen"+licencecheck);
            boolean usernamechanges = true;
            boolean dlnumberchanges = true;
            boolean emailchanges = true;
            if(x==0)
            {
                
                boolean status = false;
                boolean find = true;
                boolean changes = false;
                Customer cm = new Customer(name,unam,dlnumber,phon,emai,address,pointsint);
                if( (usernamecheck==0) && (emailcheck==0) && (licencecheck==0))
                {
                    System.out.println("all ok");
                    try {
                       status = cm.UpdateCustomer();
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(status)
                    {
                        JOptionPane.showMessageDialog(null, "Press Refresh Table To View Changes");
                        cus.LoaddTable();
                        this.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error! Customer Details were Not Updated");
                    }
                    changes = true;
                }
                if(usernamecheck!=0)
                {
                    System.out.println("username");
                    try {
                        find = cm.FindCustomerFromUsername();
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(find)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot Update Customer, username : "+unam+" is unavailabel, Please Enter a Different Username");
                        usernamechanges = false;
                    }
                    else
                    {
                        usernamechanges = true;
                    }
                }
                if(emailcheck!=0)
                {
                    System.out.println("email");
                    try {
                        find = cm.FindCustomerFromEmail();
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(find)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot Update Customer, email : "+emai+" is unavailabel, Please Enter a Different email");
                        emailchanges = false;
                    }
                    else
                    {
                        emailchanges = true;
                    }
                }
                if(licencecheck!=0)
                {
                    System.out.println("licen");
                    try {
                        find = cm.FindCustomerFromDLNumber();
                    } catch (SQLException ex) {
                        Logger.getLogger(CustomerUpdate.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(find)
                    {
                        JOptionPane.showMessageDialog(null, "Cannot Update Customer, Licence Number : "+dlnumber+" is unavailabel, Please Enter a Different Licence Number");
                        dlnumberchanges = false;
                    }
                    else
                    {
                        dlnumberchanges = true;
                    }
                }
                if((emailchanges==true)&&(usernamechanges==true)&&(dlnumberchanges==true)&&(changes==false))
                {
                    try {
                       status = cm.UpdateCustomer(username1);
                    }
                    catch (SQLException ex) {
                        Logger.getLogger(AdminsInternalFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(status)
                    {
                        //JOptionPane.showMessageDialog(null, "Press Refresh Table To View Changes");
                        cus.LoaddTable();
                        System.out.println("shap");
                        this.dispose();
                    }
                }    
            }    
        }
    }//GEN-LAST:event_registerActionPerformed

    private void unameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void resetbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbuttonActionPerformed
        lname.setText(name1);
        uname.setText(username1);
        email.setText(email1);
        phone.setText(phonenum1);
        dlnum.setText(lnum1);
        addr.setText(addrss1);
        point.setText(points1);
    }//GEN-LAST:event_resetbuttonActionPerformed

    private void dlnumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dlnumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dlnumActionPerformed

    private void pointFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pointFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_pointFocusGained

    private void pointFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_pointFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_pointFocusLost

    private void pointMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pointMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pointMouseClicked

    private void pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pointActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointActionPerformed

    private void pointKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pointKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_pointKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addr;
    private javax.swing.JTextField dlnum;
    private javax.swing.JTextField email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField point;
    private javax.swing.JButton register;
    private javax.swing.JButton resetbutton;
    private javax.swing.JTextField uname;
    // End of variables declaration//GEN-END:variables
}