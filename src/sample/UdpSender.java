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

            // loop while user not enters "bye"
            while (true) {


                // convert the String input into the byte array.
                data = string from chat .getBytes();

                // Step 2 : Create the datagramPacket for sending
                // the data.
                DatagramPacket datagramPacket =
                        new DatagramPacket(data, data.length, ip, 7000);

                // Step 3 : invoke the send call to actually send
                // the data.
                socket.send(datagramPacket);

                // break the loop if user enters "bye"

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}