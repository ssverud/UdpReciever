package sample;


import java.io.*;
import java.net.*;
import java.net.InetAddress;


public class UdpSender {

    private DatagramSocket socket;

    public void sendUdp() throws UnknownHostException {

        try {
            try {
                socket = new DatagramSocket();
            } catch (SocketException e) {
                e.printStackTrace();
            }

            InetAddress ip = InetAddress.getLocalHost();
            byte data[];

            while (true) {


                // change the chat into bytes
                data = "string from chat".getBytes();

                 // Creating the datagramPacket
                DatagramPacket datagramPacket =
                        new DatagramPacket(data, data.length, ip, 7000);

                // sends
                socket.send(datagramPacket);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

