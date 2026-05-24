/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.quick_chat;


/**
 *
 * @author Student
 *

*/
 
    

  
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class QUICK_CHAT {

    private static ArrayList<Message> sentMessages = new ArrayList<>(); 

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int userChoice = 0;

        System.out.println("Welcome to QuickChat!");

        while (userChoice != 3) {
            printMenu();
            userChoice = getUserChoice(input);

            switch (userChoice) {
                case 1:
                    handleSendMessage(input);
                    break;
                case 2:
                    System.out.println("Recent Messages - COMING SOON");
                    break;
                case 3:
                    System.out.println("Quitting QuickChat. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a number between 1 and 3.");
            }
            System.out.println();
        }

        input.close(); 
    }

    private static void printMenu() {
        System.out.println("--- Menu ---");
        System.out.println("1. Send Message");
        System.out.println("2. View Recent Messages (Coming Soon)");
        System.out.println("3. Quit");
        System.out.print("Select an option: ");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = -1; 
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Invalid input. Please enter a number.");
            
            scanner.next();
        }
        return choice;
    }

    private static void handleSendMessage(Scanner scanner) {
        System.out.println("\n--- Send New Message ---");
        System.out.print("Enter Message ID: ");
        String messageId = scanner.next();

        System.out.print("Enter Recipient Cell Number (e.g., +27XXXXXXXXXX): ");
        String recipientCell = scanner.next();

      
        scanner.nextLine(); 

        System.out.print("Enter Message Content: ");
        String messageContent = scanner.nextLine();

        Message newMessage = new Message(messageId, recipientCell, messageContent);

       
        String processingResult = newMessage.processMessage(scanner);
        System.out.println(processingResult);

        
        if ("Message Sent Successfully.".equals(processingResult)) {
            sentMessages.add(newMessage);
        }
    }

    // Method to display all sent messages (moved from Message class)
    public static String printAllSentMessages() {
        if (sentMessages.isEmpty()) {
            return "No messages sent yet.";
        }

        StringBuilder output = new StringBuilder("--- All Sent Messages ---");
        for (Message msg : sentMessages) {
            output.append("\n- ID: ").append(msg.getMessageId())
                  .append(", Recipient: ").append(msg.getRecipientCell())
                  .append(", Content: ").append(msg.getMessageContent());
        }
        return output.toString();
    }

   
    public static int getTotalSentMessagesCount() {
        return sentMessages.size();
    }

   
    public static class Message {

        private String messageId;
        private String recipientCell;
        private String messageContent;

        
        public Message(String id, String cell, String content) {
            this.messageId = id;
            this.recipientCell = cell;
            this.messageContent = content;
        }

        
        public String getMessageId() {
            return messageId;
        }

        public String getRecipientCell() {
            return recipientCell;
        }

        public String getMessageContent() {
            return messageContent;
        }

       
        public boolean isValidMessageId() {
            return this.messageId != null && !this.messageId.trim().isEmpty() && this.messageId.length() <= 10;
        }

        
         
        public String validateRecipientCell() {
            if (this.recipientCell != null && this.recipientCell.matches("^\\+27\\d{9}$")) {
                return "Valid Cell number";
            } else {
                return "Invalid Cell number";
            }
        }

        
        public String createMessageHash() {
            StringBuilder hashBuilder = new StringBuilder("Hash");
            hashBuilder.append(this.messageId != null ? this.messageId : "NULL_ID");
            hashBuilder.append("-");
            hashBuilder.append(this.messageContent != null ? this.messageContent.length() : 0);
            return hashBuilder.toString();
        }

       
        public String processMessage(Scanner scanner) {
            System.out.println("\nProcessing Message ID: " + this.messageId);
            System.out.println("1. Send");
            System.out.println("2. Store (Display as JSON)");
            System.out.println("3. Disregard");
            System.out.print("Enter choice: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();

                if (choice == 1) {
                   
                    return "Message Sent Successfully.";
                } else if (choice == 2) {
                    storeMessage();
                    return "Message Stored (Displayed as JSON).";
                } else if (choice == 3) {
                    return "Message Disregarded.";
                } else {
                    return "Invalid choice for message processing.";
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a number (1, 2, or 3).");
                // Consume the invalid input
                scanner.next();
                return "Message Processing Failed due to invalid input.";
            }
        }

        
        public void storeMessage() {
            StringBuilder jsonBuilder = new StringBuilder("{\n");
            jsonBuilder.append("  \"id\": \"").append(escapeJsonString(this.messageId)).append("\",\n");
            jsonBuilder.append("  \"cell\": \"").append(escapeJsonString(this.recipientCell)).append("\",\n");
            jsonBuilder.append("  \"content\": \"").append(escapeJsonString(this.messageContent)).append("\"\n");
            jsonBuilder.append("}");

            System.out.println("\n--- Saved JSON Output ---");
            System.out.println(jsonBuilder.toString());
            System.out.println("-------------------------\n");
        }

        
        private String escapeJsonString(String text) {
            if (text == null) return "";
            StringBuilder escaped = new StringBuilder();
            for (char c : text.toCharArray()) {
                switch (c) {
                    case '"': escaped.append("\\\""); break;
                    case '\\': escaped.append("\\\\"); break;
                    case '\b': escaped.append("\\b"); break;
                    case '\f': escaped.append("\\f"); break;
                    case '\n': escaped.append("\\n"); break;
                    case '\r': escaped.append("\\r"); break;
                    case '\t': escaped.append("\\t"); break;
                    default:
                        if (c >= '\u0000' && c <= '\u001f') {
                            String hex = Integer.toHexString(c);
                            escaped.append("\\u").append("0000".substring(hex.length())).append(hex);
                        } else {
                            escaped.append(c);
                        }
                }
            }
            return escaped.toString();
        }

       
    }

   
    public static void main_demo(String[] args) {
        System.out.println("--- Demonstrating Message Class Functionality ---");

        Message msg1 = new Message("MSG001", "+27712345678", "Hello, this is a test message.");
        Message msg2 = new Message("MSG002", "+27829876543", "Meeting reminder for tomorrow.");
        Message msg3 = new Message("SHORTID", "+27601112233", "Quick update.");
        Message invalidMsg = new Message("VERYLONGMESSAGID12345", "+1234567890", "This is an invalid message.");
        Message msgWithSpecialChars = new Message("MSG_SPECIAL", "+27112233445", "This message has \"quotes\" and \\backslashes\\.");

        System.out.println("\n--- Message 1 ---");
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
        System.out.println("Cell Valid: " + invalidMsg.validateRecipientCell()); // Invalid Cell number
        System.out.println("Hash: " + invalidMsg.createMessageHash());

        System.out.println("\n--- Message with Special Chars ---");
        System.out.println("ID Valid: " + msgWithSpecialChars.isValidMessageId()); // true
        System.out.println("Cell Valid: " + msgWithSpecialChars.validateRecipientCell()); // Valid Cell number
        System.out.println("Hash: " + msgWithSpecialChars.createMessageHash());
        msgWithSpecialChars.storeMessage(); 

        System.out.println("\n--- Simulating Sending Messages (for demo) ---");
        
        sentMessages.add(msg1);
        sentMessages.add(msg3);

        System.out.println("\n--- All Sent Messages (from demo) ---");
        System.out.println(QUICK_CHAT.printAllSentMessages());
        System.out.println("Total messages sent: " + QUICK_CHAT.getTotalSentMessagesCount());
    }
}
  
       
       
      
        

