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
import javafx.scene.layout.VBox;



public class Controller {

    ObservableList<Message> messages = FXCollections.observableArrayList();

    public void initialize() {
        System.out.println("Kører");

        tableView.setItems(messages);


        UdpReciever udpReciever = new UdpReciever();
        new Thread(udpReciever).start();



    }

    @FXML
    VBox vbox;

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

}
