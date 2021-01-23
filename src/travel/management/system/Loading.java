package travel.management.system;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{
    JProgressBar p;
    Thread t;
    String username;
    
    @Override
    public void run(){
        try{
            for(int i = 1 ; i <= 101 ; i++){
            int m = p.getMaximum();
            int n = p.getValue();
            if(n < m){
                p.setValue(p.getValue() + 1);
                }else{
                i = 101;
                this.setVisible(false);
                new Dashboard(username).setVisible(true);
            }
           
                Thread.sleep(50);
            }
        }catch(InterruptedException e){}
    }
    
    Loading(String user){
            username = user;
            t = new Thread(this);
            
           
            
            setBounds(400, 250, 800, 400);
            getContentPane().setBackground(Color.WHITE);
            setLayout(null);
            
            
        JLabel l1 = new JLabel("TRAVEL  AND  TOURISM  APPLICATION");
        l1.setBounds(30, 20, 700, 40);
        l1.setFont(new Font("Ralewey", Font.BOLD, 35));
        l1.setForeground(Color.BLUE);
        add(l1);
        
        p =  new JProgressBar();
        p.setStringPainted(true);
        p.setBounds(220, 120, 300, 30);
        add(p);
        
        
        JLabel l2 = new JLabel("Please  wait...");
        l2.setBounds(350, 150, 750, 25);
        l2.setFont(new Font("Tahoma", Font.BOLD, 10));
        l2.setForeground(Color.RED);
        add(l2);
      
         JLabel l3 = new JLabel("Welcome  " +username);
        l3.setBounds(20, 300, 750, 25);
        l3.setFont(new Font("Tahoma", Font.BOLD, 10));
        l3.setForeground(Color.RED);
        add(l3);
        
         t.start();
    }
    
    public static void main(String[] args){
        new Loading("").setVisible(true);
    }
}
