package sample;


import java.io.*;
import java.net.*;
import java.net.InetAddress;


public class UdpSender {

    private DatagramSocket socket;
    private Drone drone;

    public UdpSender(Drone drone) {
        this.drone = drone;
    }

    public void sendUdp(Message message) throws UnknownHostException {

        try {
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            InetAddress ip = InetAddress.getByName(drone.getIP());
            byte data[];


            //while (true) {

                // change the string into bytes
                data = message.getMessage().getBytes();

                 // Creating the datagramPacket
                DatagramPacket datagramPacket =
                        new DatagramPacket(data, data.length, ip, 7007);

                // sends
                socket.send(datagramPacket);
            System.out.println("PACKET SENT");

            //}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

