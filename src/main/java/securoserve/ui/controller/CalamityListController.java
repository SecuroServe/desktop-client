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
import org.mockito.invocation.Location;
import securoserve.library.User;
import securoserve.requests.CalamityRequest;

import java.net.URL;
import java.util.*;

/**
 * Created by guillaimejanssen on 20/03/2017.
 * @author guillaime
 */
public class CalamityListController implements Initializable {

    @FXML
    public Button closeBtn;
    @FXML
    public Button refreshButton;
    @FXML
    public TableView<Calamity> calamityTable;

    private List<Calamity> calamities;
    private ObservableList<Calamity> obsList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        closeBtn.setOnAction(this::handleCloseAction);
        refreshButton.setOnAction(this::handleRefreshAction);

        initiateTableColumns();

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

    private void initiateTableColumns() {

        TableColumn calamityName = new TableColumn("Calamity");
        calamityName.setMinWidth(133);
        calamityName.setCellValueFactory(new PropertyValueFactory<Calamity, String>("title"));

        TableColumn calamityDate = new TableColumn("Date");
        calamityDate.setMinWidth(116);
        calamityDate.setCellValueFactory(new PropertyValueFactory<Calamity, Date>("date"));

        TableColumn calamityLocation = new TableColumn("Location");
        calamityLocation.setMinWidth(131);
        calamityLocation.setCellValueFactory(new PropertyValueFactory<Calamity, Location>("location"));

        TableColumn calamityAlertedBy = new TableColumn("Alerted By");
        calamityAlertedBy.setMinWidth(111);
        calamityAlertedBy.setCellValueFactory(new PropertyValueFactory<Calamity, User>("user"));

        TableColumn calamityStatus = new TableColumn("Status");
        calamityStatus.setMinWidth(79);
        calamityStatus.setCellValueFactory(new PropertyValueFactory<Calamity, Calamity.CalamityState>("state"));

    }

    private void refreshCalamityTable() {
        CalamityRequest calamityRequest = new CalamityRequest();
        calamities = calamityRequest.allCalamity();

        obsList.removeAll(obsList);

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

