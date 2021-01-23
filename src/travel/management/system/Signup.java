package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener{
    JButton b1, b2;
    JTextField t1,t2,t3,t4;
    Choice c1;
    Signup(){
        setBounds(200, 250, 900, 400);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(133, 193, 233));
        p1.setBounds(0, 0, 500, 400);
        p1.setLayout(null);
        add(p1);
        
        JLabel l1 = new JLabel("Username");
        l1.setFont(new Font("tahoma", Font.BOLD, 12));
        l1.setBounds(60, 10, 100, 50);
        p1.add(l1);
        
        t1 = new JTextField();
        t1.setBorder(BorderFactory.createEmptyBorder());
        t1.setBounds(150, 25, 110, 20);
        add(t1);
        
        
        JLabel l2 = new JLabel("Name");
        l2.setFont(new Font("tahoma", Font.BOLD, 12));
        l2.setBounds(60, 55, 200, 50);
        p1.add(l2);
        
        t2 = new JTextField();
        t2.setBorder(BorderFactory.createEmptyBorder());
        t2.setBounds(150, 70, 110, 20);
        add(t2);
        
        
        JLabel l3 = new JLabel("Password");
        l3.setFont(new Font("tahoma", Font.BOLD, 12));
        l3.setBounds(60, 100, 300, 50);
        p1.add(l3);
        
        t3 = new JPasswordField();
        t3.setBorder(BorderFactory.createEmptyBorder());
        t3.setBounds(150, 115, 110, 20);
        add(t3);
        
        JLabel l4 = new JLabel("Security Question");
        l4.setFont(new Font("tahoma", Font.BOLD, 12));
        l4.setBounds(20, 150, 110, 40);
        p1.add(l4);
        
        c1 = new Choice();
        c1.add("your lucky number ?");
        c1.add("favourite marvel character ?");
        c1.add("your nickname ?");
        c1.add("what you like to eat most ?");
        c1.setBounds(150, 160, 180, 80);
        p1.add(c1);
        
        
        JLabel l5 = new JLabel("Answer");
        l5.setFont(new Font("tahoma", Font.BOLD, 12));
        l5.setBounds(50 ,180, 200, 50);
        p1.add(l5);
        
        t4 = new JTextField();
        t4.setBorder(BorderFactory.createEmptyBorder());
        t4.setBounds(150, 195, 160, 20);
        add(t4);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("travel/management/system/icons/icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l6 = new JLabel(i3);
        l6.setBounds(540, 50, 250, 250);
        add(l6);
        
             b1 = new JButton("Add");
        b1.setFont(new Font("tahoma", Font.BOLD, 12));
        b1.setBackground(Color.WHITE); 
        b1.setForeground(new Color(133, 193, 233));
        b1.setBounds(120, 300, 100, 25);
        b1.addActionListener(this);
        p1.add(b1);
        
        b2 = new JButton("Back");
        b2.setFont(new Font("tahoma", Font.BOLD, 12));
        b2.setBackground(Color.WHITE);
        b2.setForeground(new Color(133, 193, 233));
        b2.setBounds(250, 300, 100, 25);
        b2.addActionListener(this);
       p1.add(b2);
        
      
    }
    
    @Override
     public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            String username = t1.getText();
            String name = t2.getText();
            String password = t3.getText();
            String security = c1.getSelectedItem();
            String answer = t4.getText();
            
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"')";
            try{
                conn c = new conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                
                this.setVisible(false);
                new Login().setVisible(true);
            }catch(Exception e){
            
            }
            
        }else if(ae.getSource() == b2){
            this.setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String[] args){
    
    new Signup().setVisible(true);
    
    }
}
