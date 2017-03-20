package securoserve.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button loginButton;

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
