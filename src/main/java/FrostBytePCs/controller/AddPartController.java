package FrostBytePCs.controller;

import javafx.stage.Stage;

public class AddPartController {
    private MainController mainController;
    private Stage stage;
    /**
     * Initializes the tableview
     * @param stage
     */
    void init(Stage stage, MainController mainController) {
        this.stage = stage;
        this.mainController = mainController;
    }
}
