/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chat;

import java.util.ArrayList;
import java.util.Scanner;


public class Message {

    
    private String messageId;
    private String recipientCell;
    private String messageContent;

    
    private static ArrayList<Message> sentMessages = new ArrayList<>();

    
    public Message(String id, String cell, String content) {
        this.messageId = id;
        this.recipientCell = cell;
        this.messageContent = content;
    }

   //Gets message ID
    public String getMessageId() {
        return messageId;
    }

   //Gets recipient's cell number
    public String getRecipientCell() {
        return recipientCell;
    }

    //gets message content
    public String getMessageContent() {
        return messageContent;
    }

    
    public boolean isValidMessageId() {
        return this.messageId != null && this.messageId.length() <= 10;
    }

    
    public String validateRecipientCell() {
        if (this.recipientCell != null && this.recipientCell.length() == 10 && this.recipientCell.startsWith("+27")) {
            return "Valid Cell number";
        } else {
            return "Invalid Cell number";
        }
    }

    
    public String createMessageHash() {
        
        StringBuilder hashBuilder = new StringBuilder("Hash");
        hashBuilder.append(this.messageId);
        hashBuilder.append("-");
        hashBuilder.append(this.messageContent.length());
        return hashBuilder.toString();
    }

    
    public String processMessage() {
        
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Select an option for message ID: " + this.messageId);
            System.out.println("1 = Send");
            System.out.println("2 = Store");
            System.out.println("3 = Disregard");
            System.out.print("Enter choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                sentMessages.add(this); 
                return "Message Sent Successfully.";
            } else if (choice == 2) {
                storeMessage();
                return "Message Sent to Storage.";
            } else {
                return "Message Disregarded.";
            }
        } catch (java.util.InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number (1, 2, or 3).");
            return "Message Processing Failed due to invalid input.";
        }
    }

   
    public void storeMessage() {
        
        StringBuilder jsonBuilder = new StringBuilder("{\n");
        jsonBuilder.append("  \"id\": \"").append(this.messageId).append("\",\n");
        jsonBuilder.append("  \"cell\": \"").append(this.recipientCell).append("\",\n");
        jsonBuilder.append("  \"content\": \"").append(this.messageContent).append("\"\n");
        jsonBuilder.append("}");

        System.out.println("\n--- Saved JSON Output ---");
        System.out.println(jsonBuilder.toString());
        System.out.println("-------------------------\n");
    }

    
    public static String printAllSentMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }

        StringBuilder output = new StringBuilder("All Sent Messages:");
        for (Message msg : sentMessages) {
           
            output.append("\n- ID: ").append(msg.getMessageId())
                  .append(", Content: ").append(msg.getMessageContent());
        }
        return output.toString();
    }

    
    public static int getTotalSentMessagesCount() {
        return sentMessages.size();
    }
   
    public static void main(String[] args) {
      
        Message msg1 = new Message("MSG001", "+27712345678", "Hello, this is a test message.");
        Message msg2 = new Message("MSG002", "+27829876543", "Meeting reminder for tomorrow.");
        Message msg3 = new Message("SHORTID", "+27601112233", "Quick update.");
        Message invalidMsg = new Message("VERYLONGMESSAGID12345", "+1234567890", "This is an invalid message.");

        System.out.println("--- Message 1 ---");
        System.out.println("ID Valid: " + msg1.isValidMessageId()); // true
        System.out.println("Cell Valid: " + msg1.validateRecipientCell()); // Valid Cell number
        System.out.println("Hash: " + msg1.createMessageHash()); 

        System.out.println("\n--- Message 2 ---");
        System.out.println("ID Valid: " + msg2.isValidMessageId()); // true
        System.out.println("Cell Valid: " + msg2.validateRecipientCell()); // Valid Cell number
        System.out.println("Hash: " + msg2.createMessageHash()); 
        
        System.out.println("\n--- Message 3 ---");
        System.out.println("ID Valid: " + msg3.isValidMessageId()); // true
        System.out.println("Cell Valid: " + msg3.validateRecipientCell()); // Valid Cell number
        System.out.println("Hash: " + msg3.createMessageHash()); 

        System.out.println("\n--- Invalid Message ---");
        System.out.println("ID Valid: " + invalidMsg.isValidMessageId()); // false
        System.out.println("Cell Valid: " + invalidMsg.validateRecipientCell()); 
        System.out.println("Hash: " + invalidMsg.createMessageHash()); 

        
        System.out.println("\n--- Simulating Sending Messages ---");
        sentMessages.add(msg1);
        sentMessages.add(msg3);

        System.out.println("\n--- All Sent Messages ---");
        System.out.println(Message.printAllSentMessages());
        System.out.println("Total messages sent: " + Message.getTotalSentMessagesCount());
    }
}