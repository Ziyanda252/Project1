/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chat3;

/**
 *
 * @author Student
 */
public class Login_3 {
    public class Login {
   
      public static boolean checkUserName(String userName) {
        return userName.contains("_") && userName.length() >= 5;
    }
    public static boolean checkPasswordComplexity(String password) {

        boolean hasCapital = false;

        boolean hasSpecial = false;

        boolean hasNumber = false;

        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
           if (Character.isUpperCase(c))
               hasCapital = true;
           
           if (Character.isDigit(c))
               hasNumber = true;

           if (!Character.isLetterOrDigit(c))
                hasSpecial = true;
        }

        return password.length() >= 8

                && hasCapital

                && hasNumber

                && hasSpecial;

    }

    public static boolean checkPhoneNumber(String number) {
        return number.matches("^0[0-9]{9}$");
    }

    public static boolean registerUser(String userName, String password, String number) {

        if (!checkUserName(userName)) {
            System.out.println("Username format incorrect.");
            return false;
        }
        if (!checkPasswordComplexity(password)) {
            System.out.println("Password format incorrect.");
            return false;
        }
       if (!checkPhoneNumber(number)) {
           System.out.println("Invalid phone number.");
           return false;
        }
          return true;
    }

    public static boolean loginUser(String storedUser, String storedPass, String loginUser, String loginPass) {
     return storedUser.equals(loginUser)
       && storedPass.equals(loginPass);
    }
    public static String returnLoginStatus(boolean success, String firstName, String lastName,String userName) {

     if (success) {  return "Welcome " + firstName + " " + lastName  + ", it is great to see you again.";
    }
    return "Username or password incorrect.";
    }
}
}
