/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlcracker;



/**
 *
 * @author johnathan
 */
public class SqlCracker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sqlsha1 result = new sqlsha1();
        fileSystem file = new fileSystem();
        try{file.set();}catch(Exception e){System.out.println(e);}
        for (int i = 0; i < file.getWord().size(); i++){
            //Dictionary Attack
            if (file.getRemainer() != file.getWord().size()){
                result.setHash(file.getWord().get(i));
                file.checkHash(result.getResult().toUpperCase(),file.getWord().get(i));
            }else{break;}
        }
        
        System.out.println("Change to Brute Force Attack...");
        if (file.getRemainer() != 0){
            for(int i = 0; i < file.getChar().size(); i++){
                for(int j = 0; j < file.getChar().size(); j++){
                    for(int k = 0; k < file.getChar().size(); k++){
                        for (int l = 0; l < file.getChar().size(); l++ ){
                            for (int m = 0; m < file.getChar().size(); m++ ){
                                String pwd = file.getChar().get(i)+file.getChar().get(j)+file.getChar().get(k)+file.getChar().get(l)+file.getChar().get(m);
                                result.setHash(pwd);
                                file.checkHash(result.getResult().toUpperCase(),pwd);
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("Change to Combinator Attack...");
        if (file.getRemainer() != 0){
            // combinator attack
            // because of time reason, this number change to the number of the word in the wordlist
            // normally all init of var in each for loop is 0
            for (int a = 0; a < file.getWord().size(); a++){
                for(int b = 0; b < file.getWord().size(); b++){
                    for(int c = 0; c < file.getWord().size(); c++){
                        for(int d = 0; d < file.getWord().size(); d++){
                            for(int e = 0; e < file.getWord().size(); e++){
                                for(int f = 0; f < file.getWord().size(); f++){
                                    for(int g = 0; g < file.getWord().size(); g++){
                                        for(int h = 0; h < file.getWord().size(); h++){
                                            for(int i = 0; i < file.getWord().size(); i++){
                                                String pwd = file.getWord().get(a)+file.getWord().get(b)+file.getWord().get(c)+file.getWord().get(d)+file.getWord().get(e)+file.getWord().get(f)+file.getWord().get(g)+file.getWord().get(h)+file.getWord().get(i);
                                                result.setHash(pwd);
                                                file.checkHash(result.getResult().toUpperCase(),pwd);
                                                if (file.getRemainer() ==0){return;}
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
    }
}
    
