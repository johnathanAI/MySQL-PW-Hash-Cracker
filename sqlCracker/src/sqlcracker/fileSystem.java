/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcracker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tszfu
 */
public class fileSystem {
    FileInputStream wordListStream = null;
    FileInputStream hashStream = null;
    FileInputStream charStream = null;
    Scanner scanWord = null;
    Scanner scanHash = null;
    Scanner scanChar = null;
    ArrayList<String> hashlist = new ArrayList<String>();
    ArrayList<String> wordlist = new ArrayList<String>();
    ArrayList<String> charlist = new ArrayList<String>();
    int hashCounter;
    
    public void fileSystem() {
        hashCounter = 0; 
    }
    
    public void set() throws FileNotFoundException{
    try{
            wordListStream = new FileInputStream("C:\\Users\\tszfu\\Documents\\NetBeansProjects\\sqlCracker\\src\\sqlcracker\\wordlist.txt");
            scanWord = new Scanner(wordListStream, "UTF-8");
            hashStream = new FileInputStream("C:\\Users\\tszfu\\Documents\\NetBeansProjects\\sqlCracker\\src\\sqlcracker\\hash.txt");
            scanHash = new Scanner(hashStream, "UTF-8");
            charStream = new FileInputStream("C:\\Users\\tszfu\\Documents\\NetBeansProjects\\sqlCracker\\src\\sqlcracker\\char.txt");
            scanChar = new Scanner(charStream, "UTF-8");
            try {
                while (scanHash.hasNextLine()) {
                    String hash = scanHash.nextLine();
                    hashlist.add(hash);
                    hashCounter++;
                }
                while (scanWord.hasNextLine()) {
                    String word = scanWord.nextLine();
                    wordlist.add(word);
                }
                while (scanChar.hasNextLine()) {
                    String Char = scanChar.nextLine();
                    charlist.add(Char);
                }
            }
            finally {
                if (wordListStream != null) {hashStream.close();}
                if (hashStream != null) {scanHash.close();}
                if (charStream != null) {scanHash.close();}
            }
        }catch (IOException e){System.out.print(e);}
    }
    
    public ArrayList<String> getWord(){
        return wordlist;
    }
    
    public ArrayList<String> getHash(){
        return hashlist;
    }
    
    public ArrayList<String> getChar(){
        return charlist;
    }
    
    public int getRemainer(){
        return hashCounter;
    }
    
    
    
    public void checkHash(String hash, String pass){
        for (int i = 0; i< this.hashlist.size();i++){
            if(hash.equals(this.hashlist.get(i))){System.out.println(hash+" | "+pass);hashCounter--;this.hashlist.remove(i);}
        }
    }
}
