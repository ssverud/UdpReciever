package sample;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.*;
import javafx.scene.image.Image;




public class UdpReciever implements Runnable {


    Apple apple;

    private Drone drone;

    private Controller controller;

    private DatagramSocket socket;

    double canvasHeight = 327.0;
    double canvasWidth = 372.0;

    public void messageHandler(String message) {

        //System.out.println(drone);

        if(message.equals("BLACK")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BLACK);
                controller.draw();
            }
        }

        if(message.equals("BLUE")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BLUE);
                controller.draw();
            }
        }

        if(message.equals("BEIGE")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BEIGE);
                controller.draw();
            }
        }

        if(message.equals("BROWN")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BROWN);
                controller.draw();
            }
        }

        if(message.equals("BISQUE")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BISQUE);
                controller.draw();
            }
        }

        if(message.equals("DARKGREEN")) {
            if(drone.isActive()) {
                drone.changeColor(Color.DARKGREEN);
                controller.draw();
            }
        }

        if(message.equals("DARKSALMON")) {
            if(drone.isActive()) {
                drone.changeColor(Color.DARKSALMON);
                controller.draw();
            }
        }

        if(message.equals("CORAL")) {
            if(drone.isActive()) {
                drone.changeColor(Color.CORAL);
                controller.draw();
            }
        }

        if(message.equals("BLUEVIOLET")) {
            if(drone.isActive()) {
                drone.changeColor(Color.BLUEVIOLET);
                controller.draw();
            }
        }

        if(message.equals("DARKRED")) {
            if(drone.isActive()) {
                drone.changeColor(Color.DARKRED);
                controller.draw();
            }
        }

        if(message.equals("moveup")) {
            if(drone.isActive()) {
                drone.setY(drone.getY() - 0.25);
                if(drone.getY() < 0) {
                    drone.setY(0);
                }
                controller.draw();
            }
        }

        if(message.equals("movedown")) {
            if(drone.isActive()) {
                drone.setY(drone.getY() + 0.25);
                if(drone.getY() > canvasHeight - drone.getHeight()) {
                    drone.setY(canvasHeight - drone.getHeight());
                }
                controller.draw();
            }
        }

        if(message.equals("moveright")) {
            if(drone.isActive()) {
                drone.setX(drone.getX() + 0.25);
                if(drone.getX() > canvasWidth - drone.getWidth()) {
                    drone.setX(canvasWidth - drone.getWidth());
                }
                controller.draw();
            }
        }

        if(message.equals("moveleft")) {
            if(drone.isActive()) {
                drone.setX(drone.getX() - 0.25);
                if(drone.getX() < 0) {
                    drone.setX(0);
                }
                controller.draw();
            }
        }

        if(message.equals("init")) {
           drone.setActive(true);
           System.out.println("DRONE INIT");
           controller.draw();
           controller.drawApple();
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

                drone.setIP(datagramPacket.getAddress().getHostAddress());
                messageHandler(s);

                // printer gemt string
                //System.out.println(s);
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
