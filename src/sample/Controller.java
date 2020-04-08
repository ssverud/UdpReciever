package sample;

public class Controller {

    public void initialize() {
        System.out.println("Kører");

        UdpReciever udpReciever = new UdpReciever();
        new Thread(udpReciever).start();

    }

}
