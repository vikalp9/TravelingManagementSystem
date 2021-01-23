package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class BookPackage extends JFrame implements ActionListener{
        Choice c1;
        JLabel l11,l12,l13,l14,l15;
        JTextField t1;
        JButton b1,b2,b3;
    
        BookPackage(String username){
            setBounds(300, 240, 1000, 450);
            setLayout(null);
            getContentPane().setBackground(Color.WHITE);
            
            
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/icons/bookpackage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l10 = new JLabel(i3);
        l10.setBounds(550, 30, 400, 300);
        add(l10);
        
            
            
            JLabel l1 = new JLabel("BOOK PACKAGE");
            l1.setBounds(100, 10, 500, 30);
            l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
            add(l1);
            
            JLabel l2 = new JLabel("Username");
            l2.setBounds(40, 70, 100, 30);
            l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l2);
            
            l11 = new JLabel();
            l11.setBounds(260, 70, 150, 30);
            l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l11);
            
            JLabel l3 = new JLabel("Select Package");
            l3.setBounds(40, 110, 200, 30);
            l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l3);
            
            
            c1 = new Choice();
            c1.add("GOLD PACKAGE");
            c1.add("SILVER PACKAGE");
            c1.add("BRONZE PACKAGE");
            c1.setBounds(250, 110, 200, 30);
            add(c1);
          
              
            JLabel l4 = new JLabel("Total Person");
            l4.setBounds(40, 150, 100, 30);
            l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l4);
            
            
            t1 = new JTextField("1");
            t1.setBounds(250, 150, 200, 25);
            add(t1);
            
              JLabel l5 = new JLabel("ID :-");
            l5.setBounds(40, 190, 100, 30);
            l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l5);
            
            l12 = new JLabel();
            l12.setBounds(260, 190, 150, 30);
            l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l12);
            
            JLabel l6 = new JLabel("Number");
            l6.setBounds(40, 230, 100, 30);
            l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l6);
            
            l13 = new JLabel();
            l13.setBounds(260, 230, 150, 30);
            l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l13);
            
            JLabel l7 = new JLabel("Phone");
            l7.setBounds(40, 270, 100, 30);
            l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l7);
            
            l14 = new JLabel();
            l14.setBounds(260, 270, 150, 30);
            l14.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l14);
            
            JLabel l8 = new JLabel("Total Price");
            l8.setBounds(40, 310, 100, 30);
            l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l8);
            
            l15 = new JLabel();
            l15.setBounds(260, 310, 150, 30);
            l15.setForeground(Color.red);
            l15.setFont(new Font("Tahoma", Font.PLAIN, 16));
            add(l15);
            
            
            try{
                conn c = new conn();
                ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"' ");
                while(rs.next()){
                    l11.setText(rs.getString("username"));   
                    l12.setText(rs.getString("id")); 
                    l13.setText(rs.getString("number"));
                    l14.setText(rs.getString("phone"));      
                    l15.setText(rs.getString("price"));   
                }
            }catch(Exception e){}
            
            
            b1 = new JButton("Check price");
            b1.setBackground(Color.BLACK);
            b1.setForeground(Color.WHITE); 
            b1.setBounds(60, 370, 120, 25);
            b1.addActionListener(this);
            add(b1);
            
            b2 = new JButton("Book Package");
            b2.setBackground(Color.BLACK);
            b2.setForeground(Color.WHITE); 
            b2.setBounds(200, 370, 120, 25);
            b2.addActionListener(this);  
            add(b2);
            
            b3 = new JButton("Back");
            b3.setBackground(Color.BLACK);
            b3.setForeground(Color.WHITE); 
            b3.setBounds(340, 370, 120, 25);
            b3.addActionListener(this);
            add(b3);
            
        }
    
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource() == b1){
                String p = c1.getSelectedItem();
                int cost = 0;
                if(p.equals("GOLD PACKAGE")){
                    cost+=12000;
                }else if(p.equals("SILVER PACKAGE")){
                    cost+=24000; 
                }else if(p.equals("BRONZE PACKAGE")){
                    cost+=36000;  
                    }
                
                int person = Integer.parseInt(t1.getText());
                cost *= person;
                l15.setText("RS ." +cost);
                
            }else if(ae.getSource() == b2){
                   String username = l11.getText();
                   String Package = c1.getSelectedItem();
                   String person = t1.getText();
                   String id = l12.getText();            
                   String number = l13.getText();
                   String phone = l14.getText();
                   String price = l15.getText();
                   
      String q = "insert into bookpackage values('"+username+"','"+Package+"', '"+person+"', '"+id+"', '"+number+"', '"+phone+"' , '"+price+"')";
            try{
            conn c = new conn();
            c.s.executeUpdate(q);
            JOptionPane.showMessageDialog(null, "package booked successfully");
            this.setVisible(false);
                }catch(Exception e){}
            }else if(ae.getSource() == b3){
                    this.setVisible(false);
            }
        }
        
    public static void main(String[] args){
        new BookPackage("").setVisible(true);
    }
    
}
