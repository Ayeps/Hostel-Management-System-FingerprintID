/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


/**
 *
 * @author Yepson
 */
public class sqltest {



/**
 *
 * @author Ayeps
 */

     String url = "jdbc:mysql://localhost/hostelmangement?";
     final String Driver = "com.mysql.jdbc.Driver";
     String pass = "#enancy12";;
     String user = "root";
     Statement stm ;
     PreparedStatement am,pm,rm,cm,um,tm,vm;
     ResultSet g,h,i,j,k,l,m,n,o,p;
     Connection conn = null;
      
     public  sqltest(){
         try {
             Class.forName(Driver).newInstance();
             conn=DriverManager.getConnection(url, user, pass);
             System.out.println("Could conect");
         } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
             System.out.println("Could not conect"+e.getMessage());
                     
         }
         
        
                 
         
     } 
      public void select (String id){
          
                    String Name ="";
                   String Hostel = "";
                   String Number = "";
          
         try {
             
             
               am = conn.prepareStatement("SELECT * FROM  Students where idstudents = ?");
               
               am.setString(1, id);
               g=am.executeQuery();
               while(g.next()){
                   Name = g.getString("name");
                   Hostel = g.getString("hostelname");
                   Number = g.getString("date_birth");
                }
         }
                catch (Exception e) {
             System.out.println("error"+e.getMessage());
         }
                   System.out.println(Name);
                   System.out.println(Hostel);
                   System.out.println(Number);
      }

    
      
                 
      
}
