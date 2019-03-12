/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcracker;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author tszfu
 */
public class sqlsha1 {
    public String Input;
    
    public void sqlsha1(){
        Input = null;
    }
    
    public void setHash(String input){
        this.Input = input;
    }
    
    public String getResult(){
        String result = hashsha1(this.Input);
        return result;
    }
    
    public String hashsha1(String input){
        String hashStr = null;
        String password = input;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(password.getBytes(StandardCharsets.UTF_8));
            byte[] hashOnce = md.digest();
            md.reset();
            md.update(hashOnce);
            BigInteger hash = new BigInteger(1, md.digest());
            hashStr = hash.toString(16); 
        } catch (NoSuchAlgorithmException e) {System.out.print(e);}
        return hashStr;
        }
}
