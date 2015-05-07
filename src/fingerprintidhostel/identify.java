/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;

import com.innovatrics.idkit.IDKit;
import com.innovatrics.idkit.IDKitException;
import com.innovatrics.idkit.User;
import javax.swing.JOptionPane;

/**
 *
 * @author Yepson
 */


public class identify {
    

  public void  identifystudent(String image) throws IDKitException {
    
    IDKit idkit;
    idkit=IDKit.getInstance();
    System.out.println("Uses IDKit library version " + idkit.getVersionInfo());

    //Initializes IDKit library
    idkit.initModule();
    
    //Opens iengine.db flat file database.
    idkit.connect("iengine.db");
    System.out.println("Database file iengine.db selected.");

    /************************************************************
    *                                                           *
    *   We will now create a user object with unknown image  *
    *                                                           *
    *************************************************************/
    //Initializing user object
    User user=new User();

    //Add user's fingerprints
    user.addFingerprintFromFile(IDKit.FingerPosition.UNKNOWN_FINGER,image);
    

    /************************************************************
    *                                                           *
    *   Lets find our unknown user in the database              *
    *                                                           *
    *************************************************************/

    IDKit.SearchResult[] result;
    result=idkit.findUser(user);
    int userID=result[0].userID;
    addfingerprintID iden = new addfingerprintID();
    
    if(userID>0)
        
    {
        System.out.println("User already registered in the database with registration ID: " + result[0].userID);
        System.out.println("(Detected similarity score: " + result[0].score + ")");

        /************************************************************
        * 
        *
        *   Lets find the most similar fingerprint and save it's    *
        *   image as found.png                                      *
        *                                                           *
        *************************************************************/

        // compares unknown.bmp (fingeprint stored in user object with index 0) with
        // fingerprints belonging to identified user (user with id=userID)
        IDKit.MatchResult matchResult=idkit.matchFingerprint(user,0,userID);
        System.out.println("Index of best matching fingerprint: " + matchResult.bestIndex);
        iden.select(userID);
        
        //Now, lets load user with id=userID from the database and save its fingerprint
        //with index=bestIndex as found.bmp
        
        User user2=idkit.getUser(userID);
        user2.saveFingerprintImage(matchResult.bestIndex,IDKit.ImageFormat.BMP,"found.bmp");
        
        
    }
    else
    {
        //if no user with the same fingerprint is present in the database, 
        //userID (and score) is set to 0 by IEngine_FindUser 
         JOptionPane.showMessageDialog(null,"User not found in the database");
        
        
    }
    idkit.terminateModule();
  }
    
    public void  identifyfromfile(int nWidth,int nHeight,byte [] m_pImage) throws IDKitException {
    
    IDKit idkit;
    idkit=IDKit.getInstance();
    System.out.println("Uses IDKit library version " + idkit.getVersionInfo());

    //Initializes IDKit library
    idkit.initModule();
    
    //Opens iengine.db flat file database.
    idkit.connect("iengine.db");
    System.out.println("Database file iengine.db selected.");

    /************************************************************
    *                                                           *
    *   We will now create a user object with unknown image  *
    *                                                           *
    *************************************************************/
    //Initializing user object
    User user=new User();

    //Add user's fingerprints
    
      
        IDKit.RawImage x = new IDKit.RawImage(nWidth, nHeight, m_pImage);
       // byte [] u = x.getData();
    user.addFingerprint(IDKit.FingerPosition.UNKNOWN_FINGER, x);
   
    

    /************************************************************
    *                                                           *
    *   Lets find our unknown user in the database              *
    *                                                           *
    *************************************************************/

    IDKit.SearchResult[] result;
    result=idkit.findUser(user);
    int userID=result[0].userID;
    addfingerprintID iden = new addfingerprintID();
    
    if(userID>0)
        
    {
        System.out.println("User already registered in the database with registration ID: " + result[0].userID);
        System.out.println("(Detected similarity score: " + result[0].score + ")");

        /************************************************************
        * 
        *
        *   Lets find the most similar fingerprint and save it's    *
        *   image as found.png                                      *
        *                                                           *
        *************************************************************/

        // compares unknown.bmp (fingeprint stored in user object with index 0) with
        // fingerprints belonging to identified user (user with id=userID)
        IDKit.MatchResult matchResult=idkit.matchFingerprint(user,0,userID);
        System.out.println("Index of best matching fingerprint: " + matchResult.bestIndex);
        iden.select(userID);
        
        //Now, lets load user with id=userID from the database and save its fingerprint
        //with index=bestIndex as found.bmp
        
        User user2=idkit.getUser(userID);
        user2.saveFingerprintImage(matchResult.bestIndex,IDKit.ImageFormat.BMP,"found.bmp");
        
        
    }
    else
    {
        //if no user with the same fingerprint is present in the database, 
        //userID (and score) is set to 0 by IEngine_FindUser 
         JOptionPane.showMessageDialog(null,"User not found in the database");
        
        
    }
    idkit.terminateModule();
    }
    
  
    
}
