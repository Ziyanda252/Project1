/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quick_chat3;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Quick_Chat3 {

    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {
            System.out.print("First Name: ");

            String firstName = input.nextLine();

            System.out.print("Surname: ");

            String lastName = input.nextLine();
            System.out.print("Username: ");

            String userName = input.nextLine();
            System.out.print("Password: ");

            String password = input.nextLine();
            System.out.print("Phone Number: ");

            String number = input.nextLine();
            boolean registered;
            registered = Login.registerUser(userName, password, number);

            if (!registered) {
                return;

            }

            System.out.println("\nRegistration Successful");

            System.out.print("\nLogin Username: ");

            String loginUser = input.nextLine();

            System.out.print("Login Password: ");

            String loginPassword = input.nextLine();

            boolean loggedIn;
            loggedIn = Login.loginUser(userName, password, loginUser, loginPassword);

            System.out.println(Login.returnLoginStatus(loggedIn, firstName, lastName, userName));

            if (!loggedIn) {
                return;
            }
            int choice = 0;

            while (choice != 4) {

                System.out.println("\n===== QUICK CHAT =====");

                System.out.println("1. Send Message");

                System.out.println("2. Show Sent Messages");

                System.out.println("3. Stored Messages");

                System.out.println("4. Quit");

                choice = input.nextInt();
                input.nextLine();

                switch (choice) {

                    case 1 -> {
                        System.out.print("Message ID: ");
                        String id = input.nextLine();
                        System.out.print("Recipient: ");
                        String recipient = input.nextLine();
                        System.out.print("Message: ");
                        String content = input.nextLine();
                        Message msg = new Message(id, recipient, content);
                        Message.addSentMessage(msg);
                        System.out.println("Message sent.");
                        // Added break for case 1
                    }
                    case 2 -> System.out.println(Message.printAllSentMessages());

                    case 3 -> Message.displayReport();

                    case 4 -> System.out.println("Goodbye!");

                    default -> System.out.println("Invalid choice.");

                }
            }
            input.close();
        }
    }

    private static class Message {

        private static void displayReport() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static void addSentMessage(Message msg) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        private static boolean printAllSentMessages() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        public Message() {
        }

        private Message(String id, String recipient, String content) {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    }
}