package travel.management.system;


import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

public  class Login  extends JFrame implements ActionListener{
    JButton b1, b2, b3;
    JTextField t1;
    JPasswordField t2;
    Login(){
  
    setLayout(null);
    getContentPane().setBackground(Color.WHITE);
    setBounds(500, 300, 700, 300);
    
    JPanel p1 = new JPanel();
    p1.setBackground(new Color(131, 193, 233));
      p1.setBounds(0, 0, 400,400);
      p1.setLayout(null);
      add(p1);
      
      
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/icons/login.png"));
     Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
     ImageIcon i3 = new ImageIcon(i2);
      JLabel l1 = new JLabel(i1);
      l1.setBounds(80, 10, 200, 200);
      p1.add(l1);
      
      
      JPanel p2 = new JPanel();
      p2.setLayout(null);
      p2.setBounds(375, 30, 480, 330);
      add(p2);
      
      JLabel l2 = new JLabel("Username");
      l2.setBounds(60, 10, 100, 25);
      l2.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
      p2.add(l2);
      
      t1 = new JTextField();
      t1.setBounds(50, 40, 230, 25);
      t1.setBorder(BorderFactory.createEmptyBorder());
      p2.add(t1);
      
      
        JLabel l3 = new JLabel("Password");
      l3.setBounds(60, 70, 100, 25);
      l3.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
      p2.add(l3);
      
      t2 = new JPasswordField();
      t2.setBorder(BorderFactory.createEmptyBorder());
      t2.setBounds(50, 95, 230, 25);
      p2.add(t2);
      
      
      b1 = new JButton("Login");
      b1.setBounds(50, 140, 100, 20);
      b1.setBackground(new Color(133, 193, 233));
      b1.setForeground(Color.WHITE);
      b1.setBorder(BorderFactory.createEmptyBorder());
      b1.addActionListener(this);
      p2.add(b1);
      
      b2 = new JButton("Sign up");
      b2.setBounds(170, 140, 100, 20);
      b2.setForeground(new Color(133, 193, 233));
      b2.setBackground(Color.WHITE);
      b2.setBorder(new LineBorder(new Color(133, 193, 233)));
      b2.addActionListener(this);
      p2.add(b2);
      
    
      b3 = new JButton(" Forget Password ");
      b3.setBounds(85, 180, 120, 20);
      b3.setForeground(new Color(133, 193, 233));
      b3.setBackground(Color.WHITE);
      b3.setBorder(new LineBorder(new Color(133, 193, 233)));
      b3.addActionListener(this);
      p2.add(b3);
      
      JLabel l4 = new JLabel("Trouble in login...");
      l4.setBounds(210, 175, 110, 15);
      l4.setForeground(Color.RED);
      p2.add(l4);
      
    setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent ae){
     
        if(ae.getSource() == b1){
            try{
                String username = t1.getText();
                String password = t2.getText();
                String sql = "select * from account where username = '"+username+"' AND password = '"+password+"' ";
                conn c = new conn();
                ResultSet rs = c.s.executeQuery(sql);
                    if(rs.next()) {
                           this.setVisible(false);
                        new Loading(username).setVisible(true);
                      }else{
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    }
                
            }catch(Exception e){}
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new Signup().setVisible(true);
         
        }else if(ae.getSource() == b3){
             this.setVisible(false);
            new ForgetPassword().setVisible(true);
        }
}

public static void main(String[] args){
    new Login().setVisible(true);
    }
}