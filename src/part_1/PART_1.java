/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part_1;

import java.util.Scanner;
/**
 *
 * @author Student
 */
public class PART_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    String captureUserName;
     String capturePassword;
    String userName;
    String userPassword;
    
    System.out.println("Create a username");
     captureUserName = input.nextLine();
    
    System.out.println("Please create a password");
        capturePassword= input.nextLine();
    
    System.out.println("Please enter a username");
    userName = input.nextLine();
     
     
    
        System.out.println("Please enter a password");
         userPassword = input.nextLine();
     
//Condition testing using BOOLEAN
     if(userName.contains("_")&& userName.length()<=5){
         System.out.println ("Captured successfully");
     }else{
         System.out.println("Username invalid");
          
     if (password.length() )
     
         
       
         
     }
     
     input.close();
    }
    
}
