package securoserve.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    public Button loginButton;
    public Button closeButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginButton.setOnAction(this::handleLoginAction);
        closeButton.setOnAction(this::handleCloseAction);
    }

    @FXML
    public void handleLoginAction(ActionEvent event) {


        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("test");
        alert.setContentText("De knop is geklikt.");

        alert.showAndWait();
    }

    @FXML
    public void handleCloseAction(ActionEvent event) {

        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();

        System.exit(0);
    }
}
