package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;



public class Controller {

    public void initialize() {
        System.out.println("Kører");

        UdpReciever udpReciever = new UdpReciever();
        new Thread(udpReciever).start();

    }

    @FXML
    VBox vbox;

    @FXML
    private TableView<Message> tableView;

    @FXML
    private TextField textFieldType;

    @FXML
    public void oneButton(ActionEvent event) {
        Message message = new Message(textFieldType.getText());
        tableView.getItems().add(message);
        //drinks.add(drink);
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

}
