package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.net.UnknownHostException;


public class Controller {

    //skab drone og send videre til udp
    Drone drone = new Drone(50, 40);
    UdpSender udpSender = new UdpSender(drone);

    private GraphicsContext graphicsContext;

    //liste for forsendelse af meddelser fra fx til lcd
    ObservableList<Message> messages = FXCollections.observableArrayList();
    ObservableList<Apple> apples = FXCollections.observableArrayList();

    //ved ikke
    public void initialize() {
        setGraphicsContext(canvas.getGraphicsContext2D());

        System.out.println("Kører");

        tableView.setItems(messages);
        System.out.println(messages);

        UdpReceiver udpReciever = new UdpReceiver();

        udpReciever.setDrone(drone);

        udpReciever.setController(this);

        new Thread(udpReciever).start();
    }
    //sletter tidligere board for drone bevægelse og tegner opdateret igen
    public void draw() {
        getGraphicsContext().clearRect(0, 0, 500, 500);

        if (drone.isActive()) {
            System.out.println("Draw Drone");
            drawApple();
        }
        drone.draw(getGraphicsContext());
    }

    //laver og sætter apple i vores ovenstående liste, tegner det ved at hente .png og derefter sletter sig selv fra apple listen
    public void drawApple() {
        Apple apple;
        if (apples.size() < 1) {
            apple = new Apple();
            apple.setActive(true);
            apples.add(apple);
        }

        // System.out.println("Apple added ???????????????????????????????????????????????????????????");
        getGraphicsContext().drawImage(apples.get(0).getImage(), apples.get(0).getX(), apples.get(0).getY(), apples.get(0).getWidth(), apples.get(0).getHeight());
        // System.out.println("Apple ------------------------------------------------------------------");
        if (calculateDistanceBetweenDroneAndApple(drone.getX(), drone.getY(), apples.get(0).getX(), apples.get(0).getY()) < 50) {
            apples.remove(0);
            // System.out.println("apple removed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
    }
    //kalkulerer distancen mellem drone og apple for at kunne flytte apple til ny lokation
    public double calculateDistanceBetweenDroneAndApple(double x1, double y1, double x2, double y2) {
        double ac = Math.abs(y2 - y1);
        double cb = Math.abs(x2 - x1);
        return Math.hypot(ac, cb);
    }

    @FXML
    private Canvas canvas;

    @FXML
    private VBox vbox;

    @FXML
    private TableView<Message> tableView;

    @FXML
    private TextField textFieldMessage;

    @FXML
    void oneButton(ActionEvent event) {
        Message message = new Message(textFieldMessage.getText());
        messages.add(message);
        System.out.println(message);
        udpSender.sendUdp(message);
    }

    @FXML
    void mouseClickedOnCanvas(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            draw();
        }
    }

    //getter og setter
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}