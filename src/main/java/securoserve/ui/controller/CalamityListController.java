package securoserve.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by guillaimejanssen on 20/03/2017.
 * @author guillaime
 */
public class CalamityListController implements Initializable {

    @FXML
    public Button closeBtn;
    @FXML
    public Button refreshButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeBtn.setOnAction(this::handleCloseAction);
        refreshButton.setOnAction(this::handleRefreshAction);
    }

    private void handleRefreshAction(ActionEvent actionEvent) {
        //TODO Refresh the calamities with request to API.
    }

    private void handleCloseAction(ActionEvent actionEvent) {
        System.exit(0);
    }
}
