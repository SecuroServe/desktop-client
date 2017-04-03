package securoserve.ui.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import library.Calamity;
import securoserve.requests.CalamityRequest;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by guillaimejanssen on 20/03/2017.
 * @author guillaime
 */
public class CalamityListController implements Initializable {

    @FXML
    public Button closeBtn;
    @FXML
    public Button refreshButton;

    private List<Calamity> calamities;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeBtn.setOnAction(this::handleCloseAction);
        refreshButton.setOnAction(this::handleRefreshAction);

        // Refreshing the table every 10 seconds
        Timer timerToRefresh = new Timer();
        timerToRefresh.schedule(new PostRequestTask(), 10 * 1000);
    }

    private void handleRefreshAction(ActionEvent actionEvent) {
        refreshCalamityTable();
    }

    private void handleCloseAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void refreshCalamityTable() {
        CalamityRequest calamityRequest = new CalamityRequest();
        calamities = calamityRequest.allCalamity();
    }

    class PostRequestTask extends TimerTask {
        @Override
        public void run() {
            refreshCalamityTable();
        }
    }
}

