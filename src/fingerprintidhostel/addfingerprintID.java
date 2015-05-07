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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import GUI.fingerprint;
import GUI.Enroll;
import javax.swing.ImageIcon;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author Yepson
 */
public class addfingerprintID {

    /**
     *
     * @author Ayeps
     */
    String url = "jdbc:mysql://localhost/hostelmangement?";
    final String Driver = "com.mysql.jdbc.Driver";
    String pass = "#enancy12";
    String user = "root";
    Statement stm;
    PreparedStatement am, pm, rm, cm, um, tm, vm;
    ResultSet g, h, i, j, k, l, m, n, o, p;
    Connection conn = null;

    public addfingerprintID() {
        try {
            Class.forName(Driver).newInstance();
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Could conect");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
            System.out.println("Could not conect" + e.getMessage());

        }




    }

    public void add(int id, String refnumber) {
        String name = "", room = "", hostel = "";
        try {


            am = conn.prepareStatement("UPDATE students set fingerprintid = ?  WHERE refnumber = ?");

            am.setInt(1, id);
            am.setString(2, refnumber);
            am.execute();

        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }
        try {


            am = conn.prepareStatement("SELECT * FROM students where refnumber  = ?");

            am.setInt(1, id);
            g = am.executeQuery();
            while (g.next()) {




                name = g.getString("name");
                room = g.getString("roomnumber");
                hostel = g.getString("hostelname");






            }



            System.out.println(name);
            System.out.println(room);

            Enroll.E_name.setText(name);
            Enroll.e_ref.setText(refnumber);
            Enroll.e_hostel.setText(hostel);
            Enroll.e_room.setText(room);



        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    public void select(int id) {
        String name = "", room = "", ref = null, hostel = "";

        try {


            am = conn.prepareStatement("SELECT * FROM students where fingerprintid = ?");

            am.setInt(1, id);
            g = am.executeQuery();
            while (g.next()) {




                name = g.getString("name");
                ref = g.getString("refnumber");
                room = g.getString("roomnumber");
                hostel = g.getString("hostelname");






            }




            System.out.println(name);
            System.out.println(room);

            fingerprint.nameID.setText(name);
            fingerprint.pictureId.setIcon(new ImageIcon("C:/xampp/htdocs/charles/onlineregistration/upload/" + ref + ".jpg"));
            fingerprint.hostelID.setText(hostel);
            fingerprint.roomnumberID.setText(room);




        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }



    }

    public void view(String ref) throws SQLException {
        String number = null, type = "", des = "";

        vm = conn.prepareStatement("Select * FROM complaints where roomnumber = ?");


        vm.setString(1, ref);
        m = vm.executeQuery();

        while (m.next()) {
            number = m.getString("roomnumber");
            type = m.getString("type");
            des = m.getString("description");

        }
        conn.close();
        fingerprint.num_com.setText(number);
        fingerprint.fault.setText(type);
        fingerprint.comp.setText(des);
    }
    public void view1(String ref) throws SQLException {
        String name = "", room = "", hostel = "";

        try {


            am = conn.prepareStatement("SELECT * FROM students where roomnumber = ?");

            am.setString(1, ref);
            g = am.executeQuery();
            while (g.next()) {




                name = g.getString("name");
                ref = g.getString("refnumber");
                room = g.getString("roomnumber");
                hostel = g.getString("hostelname");






            }




            System.out.println(name);
            System.out.println(room);

            fingerprint.nameID1.setText(name);
            fingerprint.pictureId1.setIcon(new ImageIcon("C:/xampp/htdocs/charles/onlineregistration/upload/" + ref + ".jpg"));
            fingerprint.hostelID1.setText(hostel);
            fingerprint.roomnumberID1.setText(room);




        } catch (Exception e) {
            System.out.println("error" + e.getMessage());
        }

    }

    public String login(String username, String password) throws SQLException {


        vm = conn.prepareStatement("SELECT * FROM tb_user  WHERE username = ? AND password = ?");
        vm.setString(1, username);
        vm.setString(2, password);
        p = vm.executeQuery();

        if (p.next()) {
            return "exist";
        } else {
            return "not exist";
        }
    }
     
        public void search (javax.swing.JTable jTable , String tabname, String colname,String room) throws SQLException
        {
            
           vm = conn.prepareStatement("Select * FROM "+tabname + " where "+colname+ " like ?");
        
            
            vm.setString(1,room);
            m = vm.executeQuery();
            
            jTable.setModel(DbUtils.resultSetToTableModel(m));
            
            conn.close();
            } 
}
