/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package part_1;

import java.util.Scanner;
//https://www.youtube.com/watch?v=MOhiM2SXZl0
//https://www.youtube.com/watch?v=oz0Qd5H4Onk
  public class QUICK_CHART{


   

    // Username validation
    public static boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() >= 5;
    }

    // Password validation
    public static boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false, hasSpecial = false, hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);

            if (Character.isUpperCase(c)) hasCapital = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasCapital && hasNumber && hasSpecial;
    }

    // Phone number validation
    public static boolean checkPhoneNumber(String number) {
        return number.matches("^0[0-9]{9}$");
    }

    // Register user
    public static boolean registerUser(String userName, String password, String number) {
          //Ensure there is an underscore and 5 or more characters
        if (checkUserName(userName)) {
            System.out.println("Username successfully captured");
        } else {
            System.out.println("Username format incorrect, ensure it includes an underscore and has at least 5 characters.");
            return false;
        }
         //There must be 8+ characters
         //a capital letter
         //at least one number
         // a special character
        if (checkPasswordComplexity(password)) {
            System.out.println("Password successfully captured");
        } else {
            System.out.println("Password format incorrect, must contain 8+ characters, a capital letter, a number,  and a special character.");
            return false;
        }

        if (checkPhoneNumber(number)) {
            System.out.println("Phone number successfully added.");
        } else {
            System.out.println("Invalid phone number, must start with 0 and must exactly be 10 digits.");
            return false;
        }

        return true;
    }

    // Login user
    public static boolean loginUser(String storedUser, String storedPass, String loginUser, String loginPass) {
        return storedUser.equals(loginUser) && storedPass.equals(loginPass);
    }

    // Return login status
    public static String returnLoginStatus(boolean success, String firstName, String lastName, String userName) {
        if (success) {
            return "Welcome " + firstName + " " + lastName + " (" + userName + "), it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Declare variables
        String userName;
        String userPassword;
        String firstName;
        String secondName;

        // Ask the user for input
        System.out.println("Enter your first name: ");
        firstName = input.nextLine();

        System.out.println("Enter your second name: ");
        secondName = input.nextLine();

       
        System.out.println("Please create a username: ");
        userName = input.nextLine();

        
        System.out.println("Please create a password: ");
        userPassword = input.nextLine();

        
        System.out.println("Please enter your number: ");
        String userNumber = input.nextLine();

        //registration
        boolean isRegistered = registerUser(userName, userPassword, userNumber);

        System.out.println("\n===== REGISTRATION =====");
        if (isRegistered) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed.");
            input.close();
            return;
        }

        //  LOGIN
        System.out.println("\n===== LOGIN =====");
        System.out.println("Enter username:");
        String loginUser = input.nextLine();

        System.out.println("Enter password:");
        String loginPassword = input.nextLine();

        boolean loginVerified = loginUser(loginUser, loginPassword, loginUser, loginPassword);

        //  Return login message
        String message = returnLoginStatus(loginVerified, firstName, secondName, userName);
        System.out.println(message);

        input.close();
    }
}
      
      
      
              
    
     
         
       
         
     
