package com.mycompany.quick_chat3;



import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;



public class Message_3Test {



    @Test



    public void testGetMessageId() {



        Message_3 instance =



            new Message_3("MSG001", "+27712345678", "Hello");



        assertEquals("MSG001", instance.getMessageId());



    }



    @Test



    public void testGetRecipientCell() {



        Message_3 instance =



            new Message_3("MSG001", "+27712345678", "Hello");



        assertEquals("+27712345678",



                     instance.getRecipientCell());



    }



    @Test



    public void testGetMessageContent() {



        Message_3 instance =



            new Message_3("MSG001", "+27712345678", "Hello");



        assertEquals("Hello",



                     instance.getMessageContent());



    }



    @Test



    public void testCreateMessageHash() {



        Message_3 instance =



            new Message_3("MSG001", "+27712345678", "Hello");



        assertNotNull(instance.createMessageHash());



    }



}

