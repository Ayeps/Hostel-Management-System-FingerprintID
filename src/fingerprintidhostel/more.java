/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;

import com.innovatrics.idkit.IDKit;
import com.innovatrics.idkit.IDKitException;
import com.innovatrics.idkit.User;
import javax.swing.JOptionPane;
import GUI.Enroll;

/**
 *
 * @author Yepson
 */
public class more  {
    public int id; 
    //public static void main(String[] args) throws IDKitException {
public void  id (String image,String image2) throws IDKitException {  
    
    
    IDKit idkit;
    idkit=IDKit.getInstance();
    
    addfingerprintID idv = new addfingerprintID();
     System.out.println("Uses IDKit library version " + IDKit.getVersionInfo());

    
    IDKit.initModule();
    
    idkit.connect("iengine.db");
    System.out.println("Database file iengine.db selected.");

    
    User user=new User();
    
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX, image);
    user.addFingerprintFromFile(IDKit.FingerPosition.LEFT_INDEX,image2);
    id=idkit.registerUser(user);
    
    idv.add(id, Enroll.ref_enroll.getText());
    
    
    JOptionPane.showMessageDialog(null,"Student registered, registration id is: " + id);
    //System.out.println("First user registered, registration id is: " + id);
    user.clear();
  }

public void  idfromimage (int nWidth,int nHeight,byte [] image,byte [] image2, byte [] image3) throws IDKitException {  
    
    
    IDKit idkit;
    idkit=IDKit.getInstance();
    
    addfingerprintID idv = new addfingerprintID();
     System.out.println("Uses IDKit library version " + IDKit.getVersionInfo());

    
    IDKit.initModule();
    
    idkit.connect("iengine.db");
    System.out.println("Database file iengine.db selected.");

    
    User user=new User();
            IDKit.RawImage x = new IDKit.RawImage(nWidth, nHeight, image);
            IDKit.RawImage y = new IDKit.RawImage(nWidth, nHeight, image2);
            IDKit.RawImage z = new IDKit.RawImage(nWidth, nHeight, image3);
    
    user.addFingerprint(IDKit.FingerPosition.RIGHT_THUMB, x);
    user.addFingerprint(IDKit.FingerPosition.RIGHT_INDEX,y);
    user.addFingerprint(IDKit.FingerPosition.RIGHT_MIDDLE,z);
    id=idkit.registerUser(user);
    
    idv.add(id, Enroll.ref_enroll.getText());
    
    
    JOptionPane.showMessageDialog(null,"Student registered, registration id is: " + id);
    //System.out.println("First user registered, registration id is: " + id);
    user.clear();
  }
    
}//}
