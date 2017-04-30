package securoserve.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import securoserve.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Main main;

    @FXML
    public Button loginButton;

    public LoginController(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(this::handleLoginAction);
    }

    @FXML
    public void handleLoginAction(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("test");
        alert.setContentText("De knop is geklikt.");
        alert.showAndWait();
    }

}
