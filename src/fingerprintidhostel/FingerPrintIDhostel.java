/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;


import com.innovatrics.idkit.IDKit;
import com.innovatrics.idkit.User;
import java.sql.SQLException;




/**
 *
 * @author Yepson
 */
public class FingerPrintIDhostel {

    /**
     * @param args the command line arguments
     */
    public FingerPrintIDhostel() throws SQLException, ClassNotFoundException, Exception {
        
        
        
      IDKit idkit;
      idkit=IDKit.getInstance();
      System.out.println("Uses IDKit library version " + IDKit.getVersionInfo());

        IDKit.initModule();
        IDKit.LicenseInformation m = idkit.getLicenseInformation() ;
        IDKit.initModule();
        idkit.connect( "iengine.db" );
        
          IDKit.initModule();
    
    //Opens iengine.db flat file database.
    idkit.connect("iengine.db");
    System.out.println("Database file iengine.db selected.");

    //Clear the database, to be sure that we start with an empty database
    idkit.clearDatabase();

     User user=new User();

    //Add user's fingerprints
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/01_li_01.bmp");
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/01_li_02.bmp");

    //Register user
    int id=idkit.registerUser(user);
    System.out.println("First user registered, registration id is: " + id);
     user.clear();
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/02_li_01.bmp");
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/02_li_02.bmp");

    //Register user
    idkit.registerUser(user);
    
    //Register third user
    user.clear();
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/03_li_01.bmp");
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,"images/03_li_02.bmp");

    //Register user
    idkit.registerUser(user);
    
    System.out.println("All three users have been registered.");

    System.out.println("Now, iengine.db contains three users, each with two registered fingerprints.");
    System.out.println("As defined in standard settings,");
    System.out.println("both fingerprint templates and fingerprint images are stored in the database.");

   
     int max =  5 ;
   
     int u;
     u = user.getFingerprintCount();
       System.out.println(u);
         
 
    
    
        
    }
        // TODO code application logic here
    }

