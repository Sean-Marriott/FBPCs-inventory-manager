package FrostBytePCs.controller;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML controller class for the main window
 * @author Sean Marriott
 */
public class MainController {
    private static final Logger log = LogManager.getLogger();

    @FXML 
    private BorderPane mainWindow;
    private Stage stage;

    /**
     * initialises the main window
     * @param stage stage to load
     */
    public void init(Stage stage){
        this.stage = stage;

        loadTableView(stage);
        stage.sizeToScene();
    }

    /**
     * loads the table view into the main window
     * @param stage stage to load
     */
    private void loadTableView(Stage stage) {
        try {
            FXMLLoader tableViewLoader = new FXMLLoader(getClass().getResource("/fxml/inventory_table.fxml"));
            Parent tableViewParent = tableViewLoader.load();
            InventoryTableViewController tableViewController = tableViewLoader.getController();
            tableViewController.init(stage);
            mainWindow.setCenter(tableViewParent);
        } catch (IOException e) {
            log.error("Error loading table view");
        }
    }
}
