package securoserve.ui.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import securoserve.library.Calamity;
import securoserve.library.Location;
import securoserve.library.User;
import securoserve.requests.CalamityRequest;
import securoserve.requests.CalamityRequestTest;

import java.net.URL;
import java.util.*;

/**
 * Created by guillaimejanssen on 20/03/2017.
 * @author guillaime
 */
public class CalamityListController implements Initializable {

    @FXML
    public Button refreshButton;
    @FXML
    public TableView<Calamity> calamityTable;

    private List<Calamity> calamities;
    private ObservableList<Calamity> obsList;

    private Timer timerToRefresh = new Timer();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        refreshButton.setOnAction(this::handleRefreshAction);

        initiateTableColumns();
        refreshCalamityTable();

        // Refreshing the table every 10 seconds
        timerToRefresh.schedule(new PostRequestTask(), 10 * 1000);
    }

    private void handleRefreshAction(ActionEvent actionEvent) {
        refreshCalamityTable();
    }

    private void handleCloseAction(ActionEvent actionEvent) {
        System.exit(0);
    }

    private void initiateTableColumns() {

        calamityTable.setColumnResizePolicy((param) -> true);

        TableColumn calamityName = new TableColumn("Calamity");
        calamityName.getStyleClass().add("foo");
        calamityName.setCellValueFactory(new PropertyValueFactory<Calamity, String>("title"));
        calamityTable.getColumns().add(calamityName);

        TableColumn calamityDate = new TableColumn("Date");
        calamityDate.getStyleClass().add("foo");
        calamityDate.setCellValueFactory(new PropertyValueFactory<Calamity, Date>("date"));
        calamityTable.getColumns().add(calamityDate);

        TableColumn calamityLocation = new TableColumn("Location");
        calamityLocation.getStyleClass().add("foo");
        calamityLocation.setCellValueFactory(new PropertyValueFactory<Calamity, Location>("location"));
        calamityTable.getColumns().add(calamityLocation);

        TableColumn calamityAlertedBy = new TableColumn("Alerted By");
        calamityAlertedBy.getStyleClass().add("foo");
        calamityAlertedBy.setCellValueFactory(new PropertyValueFactory<Calamity, User>("user"));
        calamityTable.getColumns().add(calamityAlertedBy);

        TableColumn calamityStatus = new TableColumn("Status");
        calamityStatus.getStyleClass().add("foo");
        calamityStatus.setCellValueFactory(new PropertyValueFactory<Calamity, Calamity.CalamityState>("state"));
        calamityTable.getColumns().add(calamityStatus);

    }

    private void refreshCalamityTable() {
        CalamityRequestTest calamityRequest = new CalamityRequestTest();
        calamities = calamityRequest.allCalamity();

        obsList = FXCollections.observableArrayList(calamities);
        calamityTable.setItems(obsList);
    }

    class PostRequestTask extends TimerTask {
        @Override
        public void run() {
            refreshCalamityTable();
        }
    }
}

