/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quick_chat3;

import java.util.ArrayList;

/**
 *
 * @author Student
 */
public class Message_3 {

    private static void Content() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    



    private String messageId;
    private String recipientCell;
    private String messageContent;

    private static final ArrayList<Message_3> sentMessages =
        new ArrayList<>();

    private static ArrayList<Message_3> storedMessages =
            new ArrayList<>();


    private static ArrayList<Message_3> disregardedMessages =
            new ArrayList<>();
    private boolean getMessage_3;
    private boolean getMessage;

    public Message_3 (String id, String cell, String content) {
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
    public String createMessageHash() {
       return "HASH" + messageId;
    }
    public static void addSentMessage(Message_3 msg) {

        sentMessages.add(msg);
    }
    public static void addStoredMessage(Message_3 msg) {
        storedMessages.add(msg);
    }
    public static void addDisregardedMessage(Message_3 msg) {
        disregardedMessages.add(msg);
    }
    public static String printAllSentMessages() {
       if (sentMessages.isEmpty()) {
           return "No sent messages.";
    }
    StringBuilder output =
        new StringBuilder();

    for (Message_3 msg : sentMessages) {
        output.append("\nID: ")
              .append(msg.getMessageId());
        output.append("\nMessage: ")
              .append(msg.getMessageContent());
        output.append("\n");
    }
    return output.toString();
  }
 public static void displaySenderAndRecipient() {
        for (Message_3 msg : storedMessages) {
            System.out.println( "Recipient: " + msg.getRecipientCell());
            System.out.println("Message: "+ msg.getMessageContent());
     }
}
 public static void displayLongestStoredMessage() {
    if (storedMessages.isEmpty()) {
       System.out.println("No stored messages.");
       return;
}
Message_3 longest = storedMessages.get(0);
   for (Message_3 msg : storedMessages) {
        if (msg.getMessageContent().length()
            > longest.getMessageContent().length()) {
        longest = msg;
            }
        }

    System.out.println(longest.getMessageContent());
    }

 public static void searchMessageID(String id) {
     for (Message_3 msg : sentMessages) {
            if (msg.getMessageId().equals(id)) {
                System.out.println(msg.getMessageContent());
return;

     }
  }
 System.out.println("Message not found.");
}
public static void searchRecipient(String recipient) {
     for (Message_3 msg : storedMessages) {
        if (msg.getRecipientCell()
            .equals(recipient)) {
        System.out.println(msg.getMessageContent());
     }
   }
}
public static void deleteMessageByHash(String hash) {
 for (int i = 0;
      i < storedMessages.size();
      i++) {
    if (storedMessages.get(i)
             .createMessageHash()
             .equals(hash)) {
        storedMessages.remove(i);
    System.out.println( "Message deleted.");
       return;
    }
}
    System.out.println("Hash not found.");
}
    public static void displayReport() {
      for (Message_3 msg : sentMessages) {
     System.out.println( "\nHash: "+ msg.createMessageHash());

     System.out.println(  "Recipient: " + msg.getRecipientCell());

    System.out.println(  "Message: "+ msg.getMessageContent());
  }
 }
}

