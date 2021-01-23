package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class DeleteCustomer extends JFrame implements ActionListener{
        JButton b1, b2;
        String username;
        DeleteCustomer(String user){
            this.username = user;
            setBounds(460, 200, 850, 500);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            
            JLabel heading = new JLabel("DELETE  CUSTOMER  DETAILS");
            heading.setFont(new Font("Tahoma", Font.PLAIN, 30));
            heading.setBounds(100, 10, 500, 30);
            add(heading);
            
            
           JLabel l1 = new JLabel("Username: ");
           l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l1.setBounds(30, 70, 150, 24);
           add(l1); 
            
               
           JLabel l11 = new JLabel();
           l11.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l11.setBounds(270, 70, 200, 24);
           add(l11); 
           
              JLabel l2 = new JLabel("Name: ");
           l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l2.setBounds(30, 110, 150, 24);
           add(l2); 
            
               
           JLabel l12 = new JLabel();
           l12.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l12.setBounds(270, 110, 200, 24);
           add(l12);
           
              JLabel l3 = new JLabel("ID: ");
           l3.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l3.setBounds(30, 150, 150, 24);
           add(l3); 
            
               
           JLabel l13 = new JLabel();
           l13.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l13.setBounds(270, 150, 200, 24);
           add(l13);
           
           JLabel l4 = new JLabel("Number: ");
           l4.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l4.setBounds(30, 190, 150, 24);
           add(l4); 
            
               
           JLabel l14 = new JLabel();
           l14.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l14.setBounds(270, 190, 200, 24);
           add(l14);
          
           JLabel l5 = new JLabel("Gender:");
           l5.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l5.setBounds(30, 230, 150, 24);
           add(l5); 
            
               
           JLabel l15 = new JLabel();
           l15.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l15.setBounds(270, 230, 200, 24);
           add(l15);
           
              JLabel l6 = new JLabel("Country:");
           l6.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l6.setBounds(30, 270, 150, 24);
           add(l6); 
            
               
           JLabel l16 = new JLabel();
           l16.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l16.setBounds(270, 270, 200, 24);
           add(l16);
           
              JLabel l7 = new JLabel("Address:");
           l7.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l7.setBounds(30, 310, 150, 24);
           add(l7); 
            
               
           JLabel l17 = new JLabel();
           l17.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l17.setBounds(270, 310, 200, 24);
           add(l17);
           
              JLabel l8 = new JLabel("Phone:");
           l8.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l8.setBounds(30, 350, 150, 16);
           add(l8); 
            
               
           JLabel l18 = new JLabel();
           l18.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l18.setBounds(270, 350, 200, 16);
           add(l18);
           
              JLabel l9 = new JLabel("E-mail:");
           l9.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l9.setBounds(30, 390, 150, 24);
           add(l9); 
            
               
           JLabel l19 = new JLabel();
           l19.setFont(new Font("Tahoma", Font.PLAIN, 20));
           l19.setBounds(270, 390, 200, 24);
           add(l19);
           
               b1 = new JButton("Delete");
               b1.setBackground(Color.BLACK);
               b1.setForeground(Color.WHITE);
               b1.setBounds(80, 430, 120, 25);
               b1.addActionListener(this);
               add(b1);
               
               
               b2 = new JButton("Back");
               b2.setBackground(Color.BLACK);
               b2.setForeground(Color.WHITE);
               b2.setBounds(220, 430, 120, 25);
               b2.addActionListener(this);
               add(b2);
               
                      
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/icons/delete.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(380, 30, 400, 400);
        add(l10);
           
           
           try{
               conn c = new conn();
               ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"' ");
               while(rs.next()){
                   l11.setText(rs.getString("username"));
                   l12.setText(rs.getString("name"));
                   l13.setText(rs.getString("id"));
                   l14.setText(rs.getString("number"));
                   l15.setText(rs.getString("gender"));  
                   l16.setText(rs.getString("country"));
                   l17.setText(rs.getString("address"));
                   l18.setText(rs.getString("phone"));  
                   l19.setText(rs.getString("email"));   
               }
           }catch(Exception e){}
        }
     
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                try{
                    conn c = new conn();
                    c.s.executeUpdate("delete  from account where username = '"+username+"' ");
                    c.s.executeUpdate("delete  from bookhotel where username = '"+username+"' ");
                    c.s.executeUpdate("delete  from bookpackage where username = '"+username+"' ");
                    c.s.executeUpdate("delete  from customer where username = '"+username+"' ");
                    
                    JOptionPane.showMessageDialog(null, "Your Account is Deleted Successfully");
                    System.exit(0);
                    
                }catch(Exception e){}
            }else if(ae.getSource() == b2){
                this.setVisible(false);
            }
        }
        
        public static void main(String[] args){
            new DeleteCustomer("").setVisible(true);
        }
}
