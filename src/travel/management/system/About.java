package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    String s;
    JButton b1;
    About(){
        setBounds(400, 150, 500, 550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        
        JLabel l1 = new JLabel("Travel and tourism management system");
        l1.setBounds(50, 10, 400, 80);
        l1.setForeground(Color.red);
        l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        
        s = "The objective of the Travel and Tourism Management System project is to develop a system that automates the processes and activities of a travel and tourism agency.\n The purpose is to design a system using which one can perform all operations related to traveling and sight-seeing.\n The system allows one to easily access the relevant information and make necessary travel arrangements. \n Users can decide about places they want to visit and make bookings online for travel and accommodation.\n" +
"This project series is a step by step explanation of how to build a Desktop based application using Swing.\n\n"+
                "Introduction \n" +
"\n" +
"The Tours and Travel Management System is a web based application. The main purpose of “Tours and travels management system ” is to provide a convenient way for a customer to book hotels, flight, train and bus for tour purposes. The objective of this project is to develop a system that automates the processes and activities of a travel agency.\n In this project, We will make an easier task of searching places and for booking train, flight or bus. \n. In the present system a customer has to approach various agencies to find details of places and to book tickets.\n This often requires a lot of time and effort.\n We provide approach skills to critically examine how a tourist visits and its ability to operate in an appropriate way when dealing with the consequences of tourism, locally, regionally, and nationally including visitor security and ecological influences.\n It is tedious for a customer to plan a particular journey and have it executed properly. The project ‘Tours and Travels Management System’ is developed to replace the currently existing system, which helps in keeping records of the customer details of destination as well as payment received."+
               "\n\n"+ "this project is build by :- \n Vikalp sharma roll no 181110106076  of bca sec-b \n"+"Ubaid ansari roll no 181110106073 of bca sec-b";
        
        TextArea t1 = new TextArea(s, 10, 30, Scrollbar.VERTICAL);
        t1.setEditable(false);
        t1.setBounds(20, 100, 450, 300);
        add(t1);
        add(l1);
        
        b1 = new JButton("Back");
        b1.setBounds(200, 420, 100, 25);
        b1.addActionListener(this);
        add(b1);
    }
    
  public void actionPerformed(ActionEvent ae){
      this.setVisible(false);
  }
    
    public static void main(String[] args){
        new About().setVisible(true);
    }
}
