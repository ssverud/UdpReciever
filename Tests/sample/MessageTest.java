package sample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    Message message = new Message("Init");
    String testString2 = "hej Ebbe";

    @Test
    void getMessage() {
        String testString = message.getMessage();
        assertEquals(testString, message.getMessage());
        assertNotEquals(testString2, message.getMessage());
    }

    @Test
    void setMessage() {
        assertNotEquals(testString2, message.getMessage());
        message.setMessage("hej Ebbe");
        assertEquals(testString2, message.getMessage());
    }
}