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
  public class PART_1{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    
    String userName;
    String userPassword;
   
     //Username creation      
     System.out.println("Please create a username");
    userName = input.nextLine();
     
   //Condition testing using BOOLEAN
   //An underscore
   // 5 or more characters
     if(userName.contains("_") && userName.length() >= 5){
         System.out.println ("Captured successfully");
     }else{
         System.out.println("Username format incorrect, ensure it includes an "
                 + "underscore and no less than five characters.");
    }
     //Password creation
    System.out.println("Create a password");
    userPassword = input.nextLine();

    //Check the complexity logic
    //8 or more characters
    // special character
    // a number
    boolean hasCapital = false, hasSpecial = false, hasNumber = false;
    for(int i = 0; i < userPassword.length(); i++) {
        char c = userPassword.charAt(i);
        if (Character.isUpperCase(c))hasCapital = true;
        else if(Character.isDigit(c))hasNumber = true;
        else if(!Character.isLetterOrDigit(c)) hasSpecial = true;
    }
    if (userPassword.length() >=8 && hasCapital && hasNumber && hasSpecial){
        System.out.println("Password successfully captured");
    } else{
        System.out.println("Password not correctly formatted, please ensure that the password contains"
                + "at least 8 characters, a capital letter, a number and a special character.");
    }
      System.out.println("Please enter your number: ");
        String userNumber = input.nextLine();
      System.out.println("Your number is: " + userNumber);
    
      if(userNumber.matches("^0[0-9]{9}$")){
          System.out.println("Phone number successfully added.");
      } else {
          System.out.println("Invalis phone number, ensure it starts with 0 and has exactly 10 digits.");
      }
      
      //Login
      System.out.println("\n=====LOGIN=====");
      System.out.println("Enter username");
      String loginUser = input.nextLine();
      System.out.println("Enter password");
      String loginPassword = input.nextLine();
      
      if(loginUser.equals(userName) && loginPassword.equals(userPassword)){
          System.out.println("Welcome"+ loginUser);
      } else {
          System.out.println("Username or password incorrect.");
      }
      input.close();
     
     }
  }
      
      
      
              
    
     
         
       
         
     
