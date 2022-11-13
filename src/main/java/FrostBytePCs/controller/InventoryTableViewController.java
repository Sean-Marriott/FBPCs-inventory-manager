package FrostBytePCs.controller;
import java.util.ArrayList;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import FrostBytePCs.model.Part;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
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

    @FXML
    private TableView<Part> inventoryTableView;

    private Stage stage;

    /**
     * Initializes the tableview
     * @param stage
     */
    void init(Stage stage) {
        this.stage = stage;
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

        TableColumn<Part, Date> purchaseDateCol = new TableColumn<Part, Date>("Purchase Date");
        purchaseDateCol.setCellValueFactory(new PropertyValueFactory<Part, Date>("purchaseDate"));

        TableColumn<Part, Date> warrantyDateCol = new TableColumn<Part, Date>("Warranty Date");
        warrantyDateCol.setCellValueFactory(new PropertyValueFactory<Part, Date>("warrantyDate"));
        
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
        parts.add(new Part(0, null, null, null, 0, null, null, null));
        
        inventoryTableView.setItems(FXCollections.observableArrayList(parts));
    }
}
