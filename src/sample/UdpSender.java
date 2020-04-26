package sample;

import java.io.*;
import java.net.*;
import java.net.InetAddress;

public class UdpSender {

    private DatagramSocket socket;
    private Drone drone;

    // constructor
    public UdpSender(Drone drone) {
        this.drone = drone;
    }

    // method to send an UDP
    public void sendUdp(Message message) {

        try {
            //prepares socket
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            // picks up the drone IP
            InetAddress ip = InetAddress.getByName(drone.getIP());

            // prepares array for data
            byte data[];

            // change the string into bytes
            data = message.getMessage().getBytes();

            // Creating the datagramPacket
            DatagramPacket datagramPacket =
                    new DatagramPacket(data, data.length, ip, 7007);

            // sends
            socket.send(datagramPacket);
            System.out.println("PACKET SENT");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}