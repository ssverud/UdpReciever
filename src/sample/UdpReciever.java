package sample;

import java.io.IOException;
import java.net.*;



public class UdpReciever implements Runnable {

    private Drone drone;

    private Controller controller;

    private DatagramSocket socket;

    public void messageHandler(String message) {
        if(message.equals("moveup")) {
            if(drone.setActive();)
        }

        if(message.equals("init")) {
           drone.setActive(true);
           System.out.println("DRONE INIT");
           controller.draw();
       }

    }

    // kommer af implement Runnable

    @Override
    public void run() {

        // setup socket
        int port = 7000;

        // forbereder en socket til modtagelse af besked
        try {
            socket = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }



        while(true) {

            // forberede byte
            // Laver byte array til besked
            byte[] bytes = new byte[255];

            // laver datagramPacket med længden byte på byte
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            // reciever packet
            try {
                socket.receive(datagramPacket);

                // gemmer det vi har revievet i ny string
                String s = new String(datagramPacket.getData(), 0, datagramPacket.getLength());

                messageHandler(s);

                // printer gemt string
                System.out.println(s);
            } catch (IOException e) {
                e.printStackTrace();
            }



        }
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
}
