package FrostBytePCs;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

import FrostBytePCs.controller.MainController;


/**
 * Creates a main FXML window to start the application
 * @author Sean Marriott
 */
public class MainWindow extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader baseLoader = new FXMLLoader(getClass().getResource("/fxml/main.fxml"));
        Parent root = baseLoader.load();
        MainController baseController = baseLoader.getController();
        baseController.init(primaryStage);

        primaryStage.setTitle("Dashboard");
        Rectangle2D screenBounds = Screen.getPrimary().getVisualBounds();
        Scene scene = new Scene(root, screenBounds.getWidth() - 50, screenBounds.getHeight() - 50);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Launches the FXML application, for some reason this must be called from another class otherwise JavaFX errors
     * @param args command line arguments
     */
    public static void main(String [] args) {
        launch(args);
    }
}
