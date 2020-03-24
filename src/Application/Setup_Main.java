/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.FileOutputStream;
import java.io.IOException;
import static java.lang.System.out;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Raymond
 */
public class Setup_Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        //Save CA key for both programs to use
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA/ECB/PKCS1Padding");
        kpg.initialize(3072);
        KeyPair kp = kpg.generateKeyPair();

        Key pub = kp.getPublic();
        Key pvt = kp.getPrivate();

        String outFile = "CA_Key";
        FileOutputStream out = new FileOutputStream(outFile + ".key");
        out.write(pvt.getEncoded());
        out.close();

        out = new FileOutputStream(outFile + ".pub");
        out.write(pub.getEncoded());
        out.close();
    }

}
