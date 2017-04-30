package securoserve.ui.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import securoserve.Main;
import securoserve.api.interfaces.ConfirmationMessage;
import securoserve.library.User;
import securoserve.requests.LoginRequest;
import securoserve.requests.UserRequest;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private Main main;

    @FXML
    public Button loginBtn;
    @FXML
    public TextField user;
    @FXML
    public TextField password;

    public LoginController(Main main) {
        this.main = main;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loginBtn.setOnAction(this::handleLoginAction);
    }

    @FXML
    public void handleLoginAction(ActionEvent event) {
        LoginRequest loginRequest = new LoginRequest();
        ConfirmationMessage result = loginRequest.login(user.getText(), password.getText());
        System.out.println(result.getReturnObject());

        if(result.getStatus().equals(ConfirmationMessage.StatusType.SUCCES)) {

            String token = (String) result.getReturnObject();
            UserRequest userRequest = new UserRequest();
            result = userRequest.getUser(token);

            LinkedHashMap<String,?> values = (LinkedHashMap<String,?>) result.getReturnObject();
            //TODO Create user with values

        } else if(result.getStatus().equals(ConfirmationMessage.StatusType.ERROR)) {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setHeaderText("Something went wrong");
            a.setResizable(true);
            String content = "The username and password are incorrect! Please try again.";
            a.setContentText(content);
            a.showAndWait();
        }
    }
}