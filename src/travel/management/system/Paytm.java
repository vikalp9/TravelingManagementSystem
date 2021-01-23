package travel.management.system;

import java.awt.event.*;
import javax.swing.*;

public class Paytm extends JFrame implements ActionListener{
    Paytm(){
    JEditorPane j = new JEditorPane();
    j.setEditable(false);
    
    try{
        j.setPage("https://paytm.com/credit-card-bill-payment");
    }catch(Exception e){
      j.setContentType("text/html");
        j.setText("<html>error<html/>");
    }
       
        JScrollPane js = new JScrollPane(j);
        getContentPane().add(js);
        
        JButton b1 = new JButton("Back");
        b1.setBounds(610, 20, 80, 40);
        b1.addActionListener(this);
        j.add(b1);
        
      setBounds(440, 200, 800, 500);   
    }
    
        public void actionPerformed(ActionEvent ae){
            this.setVisible(false);
        }
    
    public static void main(String[] args){
        new Paytm().setVisible(true);
    }
}
