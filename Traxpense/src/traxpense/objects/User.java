/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package traxpense.objects;

/**
 *
 * @author Trevor
 */
public class User {
    protected String fName;
    protected String lName;
    protected String address;
    protected String age;
    protected String email;
    protected String userName;
    protected String password;
    
    //this should be taken out because we dont want empty instances of Profile
    public User(){
        
    }
    
    //this can be our worst case instance of a Profile
    public User(String fName, String lName, String userName, String password){
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.password = encrypt(password);
    }
    
    /*this function takes in the vanilla password field after it is confirmed 
    as the password the user wants to use, and ecrypts it to a small extent*/
    private String encrypt(String vanillaPassword){
        StringBuilder sb = new StringBuilder();
        String encryptedPassword;
        for(int i = 0; i < vanillaPassword.length(); i++){
            char c = vanillaPassword.charAt(i);            
            sb.append(String.format("%04x", (int) c));
        }
        encryptedPassword = sb.toString();
        return encryptedPassword;
    }
    
    //decrypts password from file so that checking can occur
    private String decrypt(String encryptedPassword){
        StringBuilder sb = new StringBuilder();
        String decryptedPassword;
        for (int i = 0; i < encryptedPassword.length(); i+=2) {
            String str = encryptedPassword.substring(i, i+2);
            sb.append((char)Integer.parseInt(str, 16));
        }
        decryptedPassword = sb.toString();
        return decryptedPassword;
    }
    
}
