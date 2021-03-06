package securoserve;

import com.guigarage.flatterfx.FlatterFX;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import securoserve.library.Calamity;
import securoserve.library.User;
import securoserve.ui.controller.CalamityDetailsController;
import securoserve.ui.controller.CalamityListController;
import securoserve.ui.controller.DashboardController;
import securoserve.ui.controller.LoginController;

import java.io.IOException;

public class Main extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        loadLogin();
    }

    public void loadLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        LoginController controller = new LoginController(this);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    public void loadDashBoard(User user) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Dashboard.fxml"));
        DashboardController controller = new DashboardController(this, user);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    public void loadCalamityList(User user) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CalamityList.fxml"));
        CalamityListController controller = new CalamityListController(this, user);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    public void loadCalamityDetails(User user, Calamity calamity) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/CalamityDetails.fxml"));
        CalamityDetailsController controller = new CalamityDetailsController(user, calamity, this);
        fxmlLoader.setController(controller);
        setStage(fxmlLoader.load());
    }

    private void setStage(Parent root) {
        primaryStage.setResizable(false);
        primaryStage.setTitle("Securoserve");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        // Center it
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        primaryStage.setX((primScreenBounds.getWidth() - primaryStage.getWidth()) / 2);
        primaryStage.setY((primScreenBounds.getHeight() - primaryStage.getHeight()) / 2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
