package travel.management.system;

import java.sql.*;

public class conn {
    Connection c;
    Statement s;
    
    public conn(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
       c =  DriverManager.getConnection("jdbc:mysql:///tms","root","root");
       s = c.createStatement();
    }catch(ClassNotFoundException | SQLException e){
        System.out.println(e);
        }
    }
}
