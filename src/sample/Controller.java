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


    Controller controller;

    Drone drone = new Drone(50, 40);
    UdpSender udpSender = new UdpSender(drone);

    private GraphicsContext graphicsContext;

    ObservableList<Message> messages = FXCollections.observableArrayList();

    public void initialize()
    {
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

        double droneX = canvas.getWidth() / 2;
        double droneY = canvas.getHeight() / 2;

        if(drone.isActive()) {
            System.out.println("Draw Drone");

            drone.draw(getGraphicsContext());

        }
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