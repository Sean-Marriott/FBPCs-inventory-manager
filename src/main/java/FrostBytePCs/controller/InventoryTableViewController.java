package FrostBytePCs.controller;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import FrostBytePCs.MainWindow;
import FrostBytePCs.model.Part;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML controller class for the inventory tableview scene
 * This is the basic UI that shows the inventory of parts in a table
 * @author Sean Marriott
 */
public class InventoryTableViewController {
    private static final Logger log = LogManager.getLogger();
    private MainController mainController;

    @FXML
    private TableView<Part> inventoryTableView;

    @FXML
    private Button addButton;

    @FXML
    private Button editButton;

    @FXML
    private Button removeButton;

    @FXML
    private MenuButton filterButton;

    private Stage stage;

    /**
     * Initializes the tableview
     * @param stage
     */
    void init(Stage stage, MainController mainController) {
        this.stage = stage;
        this.mainController = mainController;
        initInventoryTable();
    }

    /**
     * Initializes the inventory table
     */
    private void initInventoryTable() {
        TableColumn<Part, Integer> partIDCol = new TableColumn<Part,Integer>("Part ID");
        partIDCol.setCellValueFactory(new PropertyValueFactory<Part, Integer>("partID"));

        TableColumn<Part, String> partNameCol = new TableColumn<Part,String>("Part Name");
        partNameCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partName"));

        TableColumn<Part, String> partTypeCol = new TableColumn<Part, String>("Part Type");
        partTypeCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partType"));

        TableColumn<Part, String> partConditionCol = new TableColumn<Part, String>("Part Condition");
        partConditionCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partCondition"));

        TableColumn<Part, Float> partPriceCol = new TableColumn<Part, Float>("Part Price");
        partPriceCol.setCellValueFactory(new PropertyValueFactory<Part, Float>("partPrice"));

        TableColumn<Part, String> purchaseDateCol = new TableColumn<Part, String>("Purchase Date");
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<Part, String>("purchaseDate"));

        TableColumn<Part, String> warrantyDateCol = new TableColumn<Part, String>("Warranty Date");
        warrantyDateCol.setCellValueFactory(new PropertyValueFactory<Part, String>("warrantyDate"));
        
        TableColumn<Part, String> partStoreCol = new TableColumn<Part, String>("Part Store");
        partStoreCol.setCellValueFactory(new PropertyValueFactory<Part, String>("partStore"));
        
        inventoryTableView.getColumns().add(partIDCol);
        inventoryTableView.getColumns().add(partNameCol);
        inventoryTableView.getColumns().add(partTypeCol);
        inventoryTableView.getColumns().add(partConditionCol);
        inventoryTableView.getColumns().add(partPriceCol);
        inventoryTableView.getColumns().add(purchaseDateCol);
        inventoryTableView.getColumns().add(warrantyDateCol);
        inventoryTableView.getColumns().add(partStoreCol);

        ArrayList<Part> parts = new ArrayList<Part>();
        Part samplePart = new Part(0, "EVGA GTX 1070 8GB", "Graphics Card", "Used", 150, "16/11/2022", "16/11/2023", "Trade Me", 1);
        parts.add(samplePart);
        
        inventoryTableView.setItems(FXCollections.observableArrayList(parts));
    }

    @FXML
    private void addPart() {
        mainController.loadAddPartView(stage);
    }
    
    @FXML
    private void editPart() {
        //TODO
    }

    @FXML
    private void removePart() {
        //TODO
    }
}
