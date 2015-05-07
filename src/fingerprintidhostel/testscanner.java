/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fingerprintidhostel;

import com.innovatrics.idkit.IDKit;
import com.innovatrics.idkit.IDKitException;

/**
 *
 * @author Yepson
 */
public class testscanner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IDKitException{
        // TODO code application logic here
          IDKit idkit;
      idkit=IDKit.getInstance();
      System.out.println("Uses IDKit library version " + IDKit.getVersionInfo());
     
        
    }
}
