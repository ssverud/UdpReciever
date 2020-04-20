package sample;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.Drone;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;



public class Controller {

    Drone drone;

    GraphicsContext graphicsContext;
    GraphicsContext graphicsContextApple;


    ObservableList<Message> messages = FXCollections.observableArrayList();

    public void initialize()
    {
        graphicsContext = canvas.getGraphicsContext2D();

        System.out.println("Kører");

        tableView.setItems(messages);
        System.out.println(messages);


        UdpReciever udpReciever = new UdpReciever();
        new Thread(udpReciever).start();



    }


    private void draw(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0, 0, 500, 500);

        double droneX = canvas.getWidth() / 2;
        double droneY = canvas.getHeight() / 2;

        graphicsContext.fillRect(droneX, droneY, 10, 10);

        //if (event.getButton() == MouseButton.PRIMARY) {

        //}
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
        // tableView.getItems().add(message);
        messages.add(message);
        System.out.println(message);
    }

    @FXML
    public void twoButton(ActionEvent event) {
        draw(graphicsContext);
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

            draw(graphicsContext);
        }

    }
}