package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    JTextField  t1,t2,t3,t4,t5,t6,t7;
    Choice c1;
    JRadioButton r1,r2;
    JButton b1,b2;
    AddCustomer(String username){
        setBounds(300, 200, 850, 450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
       
        JLabel l1 = new JLabel("Username :");
        l1.setBounds(30, 50, 200, 25);
        add(l1);
        
        t1 = new JTextField();
        t1.setBounds(200, 50, 150, 25);
        add(t1);
        
         JLabel l2 = new JLabel("ID : ");
        l2.setBounds(30, 90, 150, 25);
        add(l2);
        
        c1 = new Choice();
        c1.add("Passport");
        c1.add("Adhar card");
        c1.add("Pan card");
        c1.add("Ration card");
        c1.setBounds(200, 90, 150, 80);
        add(c1);
        
        
        JLabel l3 = new JLabel("Number :");
        l3.setBounds(30, 130, 200, 25);
        add(l3);
        
        t2 = new JTextField();
        t2.setBounds(200, 130, 150, 25);
        add(t2);
        
         JLabel l4 = new JLabel("Name :");
        l4.setBounds(30, 170, 200, 25);
        add(l4);
        
        t3 = new JTextField();
        t3.setBounds(200, 170, 150, 25);
        add(t3);
        
          JLabel l5 = new JLabel("Gender :");
        l5.setBounds(30, 210, 200, 25);
        add(l5);
        
        r1 = new JRadioButton("Male");
        r1.setBounds(200, 210, 70, 25);
        add(r1);
        
         r2 = new JRadioButton("Female");
        r2.setBounds(280, 210, 70, 25);
        add(r2);
        
          JLabel l6 = new JLabel("Country :");
        l6.setBounds(30, 250, 200, 25);
        add(l6);
        
        t4 = new JTextField();
        t4.setBounds(200, 250, 150, 25);
        add(t4);
        
          JLabel l7 = new JLabel("Address :");
        l7.setBounds(30, 280, 200, 25);
        add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200, 280, 150, 25);
        add(t5);
        
          JLabel l8 = new JLabel("Phone :");
        l8.setBounds(30, 305, 200, 25);
        add(l8);
        
        t6 = new JTextField();
        t6.setBounds(200, 310, 150, 25);
        add(t6);
     
        
           JLabel l9 = new JLabel("Email :");
        l9.setBounds(30, 335, 200, 25);
        add(l9);
        
        t7 = new JTextField();
        t7.setBounds(200, 340, 150, 25);
        add(t7);
        
          b1 = new JButton("Add");
        b1.setFont(new Font("tahoma", Font.BOLD, 12));
        b1.setForeground(Color.WHITE); 
        b1.setBackground(Color.BLACK);
        b1.setBounds(120, 380, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("tahoma", Font.BOLD, 12));
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setBounds(250, 380, 100, 25);
        b2.addActionListener(this);
        add(b2);
        
           
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(340, 30, 450, 420);
        add(l10);
        
           try{
           conn c = new conn();
           ResultSet rs = c.s.executeQuery("select * from account where username = '"+username+"' "); 
           while(rs.next()){
               t1.setText(rs.getString("username"));
               t3.setText(rs.getString("name"));
           }
           }catch(Exception e){}
        
        
    }
       
    @Override
    public void actionPerformed(ActionEvent ae){
          if(ae.getSource() == b1){
        String username = t1.getText();
        String id = c1.getSelectedItem();
        String number = t2.getText();
        String name = t3.getText();
        String radio = null;
        if(r1.isSelected()){
            radio = "Male";
        }else if(r2.isSelected()){
             radio = "Female";
        }
        String country = t4.getText();
        String address = t5.getText();
        String phone = t6.getText();
        String email = t7.getText();
        
        
        String q = "insert into customer values('"+username+"', '"+id+"', '"+number+"', '"+name+"', '"+radio+"', '"+country+"', '"+address+"', '"+phone+"', '"+email+"')";
        try{
            conn c = new conn();
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "Customer details added successfully");
            this.setVisible(false);
        }catch(Exception e){}
                  } else if(ae.getSource() == b2){
                            this.setVisible(false);
                           } 
    }
    
    
    public static void main(String[] args){
        new AddCustomer("").setVisible(true);
    }
}
