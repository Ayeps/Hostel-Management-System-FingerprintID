/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;

import java.sql.*;


/**
 *
 * @author Yepson
 */
public class sqlt {
    
        Connection connection;
        PreparedStatement preparedStatement;
        
       
     public void select (String id) throws SQLException, ClassNotFoundException{
            Class.forName("com.mysql.jdbc.Driver");
        
           connection = DriverManager.getConnection("jdbc:mysql://localhost/hostelmangement??","root","");
          
            preparedStatement = connection.prepareStatement("SELECT * FROM  Students where idstudents = ?");
         
                    String Name ="";
                   String Hostel = "";
                   String Number = "";
          
         try {
             
             
               
               preparedStatement.setString(1, id);
              ResultSet g= preparedStatement.executeQuery();
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
