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
    
    System.out.println("Please enter a username (a maximum of 5 characters and include an underscore): ");
    //Input the  username
    String userName = input.nextLine();
     //Condition testing using BOOLEAN
     if(userName.contains("_") && userName.length() <= 5){
         System.out.println ("Captured successfully");
     }else{
         System.out.println("Username invalid, ensure there is an underscore and a maximum of 5 characters");
         
         
         System.out.println("Please enter a Pass");
     }
     input.close();
    }
    
}
