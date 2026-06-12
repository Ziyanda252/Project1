package com.mycompany.quick_chat3;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;



public class Message_3Test {

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
    }


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



        assertEquals("Hello", instance.getMessageContent());

    }

    @Test

    public void testCreateMessageHash() {

        Message_3 instance = new Message_3("MSG001", "+27712345678", "Hello");
        assertNotNull(instance.createMessageHash());
    }
     public void testSentMessagesArray() {

    Message_3.addSentMessage( new Message_3("001", "+27834557896", "Did you get the cake?"));

    String result = Message_3.printAllSentMessages();

    assertTrue(result.contains("Did you get the cake?"));

    }


    @Test


      public void testLongestStoredMessage() {

        Message_3.addStoredMessage(new Message_3("001", "+27838884567","Where are you? You are late! I have asked you to be on time."));
        String longest = Message_3.getLongestStoredMessage();



    assertEquals( "Where are you? You are late! I have asked you to be on time.",longest);

    }

    @Test

    public void testSearchRecipient() {

    Message_3.addStoredMessage( new Message_3("001","+27838884567", "Where are you?"));

    
    String result = Message_3.searchRecipient("+27838884567");

       assertTrue(result.contains("Where are you?"));
    }

    @Test

     public void testSearchMessageID() {
     Message_3 msg = new Message_3("0838884567","+27838884567", "It is dinner time !");

     Message_3.addSentMessage(msg);

    String result = Message_3.searchMessageID("0838884567");

       assertTrue(result.contains("It is dinner time !"));

     }

     @Test



     public void testDeleteMessageByHash() {


    Message_3 msg = new Message_3("001", "+27838884567", "Where are you?");


    Message_3.addStoredMessage(msg); String hash = msg.createMessageHash();

    boolean deleted = Message_3.deleteMessageByHash(hash);

      assertTrue(deleted);



     
}

    /**
     * Test of addSentMessage method, of class Message_3.
     */
    @Test
    public void testAddSentMessage() {
        System.out.println("addSentMessage");
        Message_3 msg = null;
        Message_3.addSentMessage(msg);
        
    }

    /**
     * Test of addStoredMessage method, of class Message_3.
     */
    @Test
    public void testAddStoredMessage() {
        System.out.println("addStoredMessage");
        Message_3 msg = null;
        Message_3.addStoredMessage(msg);
       
    }

    /**
     * Test of addDisregardedMessage method, of class Message_3.
     */
    @Test
    public void testAddDisregardedMessage() {
        System.out.println("addDisregardedMessage");
        Message_3 msg = null;
        Message_3.addDisregardedMessage(msg);
        
    }

    /**
     * Test of printAllSentMessages method, of class Message_3.
     */
    @Test
    public void testPrintAllSentMessages() {
        System.out.println("printAllSentMessages");
        String expResult = "";
        String result = Message_3.printAllSentMessages();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of displaySenderAndRecipient method, of class Message_3.
     */
    @Test
    public void testDisplaySenderAndRecipient() {
        System.out.println("displaySenderAndRecipient");
        Message_3.displaySenderAndRecipient();
      
    }

    /**
     * Test of displayLongestStoredMessage method, of class Message_3.
     */
    @Test
    public void testDisplayLongestStoredMessage() {
        System.out.println("displayLongestStoredMessage");
        Message_3.displayLongestStoredMessage();
       
    }

    /**
     * Test of displayReport method, of class Message_3.
     */
    @Test
    public void testDisplayReport() {
        System.out.println("displayReport");
        Message_3.displayReport();
       
    }
}


