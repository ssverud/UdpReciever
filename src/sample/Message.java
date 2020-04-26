package sample;

public class Message {

    private String message;

    // constructor
    public Message(String message) {
        this.message = message;
    }

    // print in terminal
    @Override
    public String toString() {
        return "Message{" +
                "message='" + message + '\'' +
                '}';
    }

    // getters and setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}