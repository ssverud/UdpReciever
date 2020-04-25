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


    // måske slet test, hvis ikke problem bare slet  Controller controller;

    Drone drone = new Drone(50, 40);
    UdpSender udpSender = new UdpSender(drone);

    private GraphicsContext graphicsContext;

    ObservableList<Message> messages = FXCollections.observableArrayList();
    ObservableList<Apple> apples = FXCollections.observableArrayList();


    public void initialize() {
        setGraphicsContext(canvas.getGraphicsContext2D());

        System.out.println("Kører");

        tableView.setItems(messages);
        System.out.println(messages);

        UdpReciever udpReciever = new UdpReciever();

        udpReciever.setDrone(drone);

        udpReciever.setController(this);

        new Thread(udpReciever).start();
    }

    public void draw() {
        getGraphicsContext().clearRect(0, 0, 500, 500);

        // test if irrelevant, delete if no problems - double droneX = canvas.getWidth() / 2;
        // test if irrelevant, delete if no problems - double droneY = canvas.getHeight() / 2;

        if (drone.isActive()) {
            System.out.println("Draw Drone");
            drawApple();
            drone.draw(getGraphicsContext());
        }
    }

    // delete if no use:  calculateDistanceBetweenDroneAndApple(drone.getX(),drone.getY(),)
    public void drawApple() {

        Apple apple = new Apple();

        if (apples.size() < 100) {
            apples.add(apple);
            System.out.println("Apple added ???????????????????????????????????????????????????????????");

            getGraphicsContext().drawImage(apple.getImage(), apples.get(0).getX(), apples.get(0).getY(), apples.get(0).getWidth(), apples.get(0).getHeight());
            System.out.println("Apple ------------------------------------------------------------------");
            if (calculateDistanceBetweenDroneAndApple(drone.getX(), drone.getY(), apple.getX(),apple.getY()) < 50) {
                 apples.remove(0);
                 System.out.println("apple removed!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
             }
        }
    }

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
    void oneButton(ActionEvent event) throws UnknownHostException {
        Message message = new Message(textFieldMessage.getText());
        // tableView.getItems().add(message);
        messages.add(message);
        System.out.println(message);
        udpSender.sendUdp(message);
    }

    @FXML
    public void twoButton(ActionEvent event) {

        draw();

    }

    @FXML
    public void threeButton(ActionEvent event) {

    }

    @FXML
    public void fourBotton(ActionEvent event) {

    }

    @FXML
    void mouseClickedOnCanvas(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {

            draw();
        }

    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }
}