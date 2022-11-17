package FrostBytePCs.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import FrostBytePCs.exceptions.InstanceAlreadyExistsException;
import FrostBytePCs.model.Part;
import FrostBytePCs.repository.DatabaseManager;
import FrostBytePCs.repository.PartDAO;

public class PartDAOTest {
    
    static PartDAO partDAO;
    static DatabaseManager databaseManager;
    
    @BeforeAll
    static void setup() throws InstanceAlreadyExistsException {
        DatabaseManager.REMOVE_INSTANCE();
        databaseManager = DatabaseManager.initialiseInstanceWithUrl("jdbc:sqlite:./src/test/resources/test_database.db");
        partDAO = new PartDAO();
    }

    @BeforeEach
    void resetDB() {
        databaseManager.resetDB();
    }

    @Test
    void testPartsEmptyOnCreation() {
        Assertions.assertEquals(0, partDAO.getAll().size());
    }

    @Test
    void testAddPartOK() {
        Part toAdd = new Part(1, "GTX 1060 6GB", "Graphics Card", "Used", 150f, "18/11/2022", "18/11/2023", "Trade Me", 1);
        partDAO.add(toAdd);
        Assertions.assertEquals(1, partDAO.getAll().size());
        Part part = partDAO.getAll().get(0);
        Assertions.assertEquals(toAdd.getPartID(), part.getPartID());
        Assertions.assertEquals(toAdd.getPartName(), part.getPartName());
        Assertions.assertEquals(toAdd.getPartType(), part.getPartType());
        Assertions.assertEquals(toAdd.getPartCondition(), part.getPartCondition());
        Assertions.assertEquals(toAdd.getPartPrice(), part.getPartPrice());
        Assertions.assertEquals(toAdd.getPurchaseDate(), part.getPurchaseDate());
        Assertions.assertEquals(toAdd.getWarrantyDate(), part.getWarrantyDate());
        Assertions.assertEquals(toAdd.getPartStore(), part.getPartStore());
        Assertions.assertEquals(toAdd.getReceived(), part.getReceived());
    }
}
