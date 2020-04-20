package sample;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import sample.Drone;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;



public class Controller {

    ObservableList<Message> messages = FXCollections.observableArrayList();

    public void initialize() {
        System.out.println("Kører");

        tableView.setItems(messages);
        System.out.println(messages);


        UdpReciever udpReciever = new UdpReciever();
        new Thread(udpReciever).start();



    }

    @FXML
    private Canvas Canvas;

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
            double x = event.getX();
            double y = event.getY();
            graph.addVertex(new Drone(x, y));
            draw(graphicsContext);
        }

}
