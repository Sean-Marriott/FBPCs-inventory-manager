package FrostBytePCs.unittests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import FrostBytePCs.repository.DatabaseManager;

import java.sql.Connection;
import java.sql.SQLException;

class DatabaseTest {

    @Test
    void testDatabaseManagerInstance() {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        Assertions.assertNotNull(databaseManager);
        Assertions.assertEquals(databaseManager, DatabaseManager.getInstance());
    }

    @Test
    void testDatabaseConnection() throws SQLException {
        DatabaseManager databaseManager = DatabaseManager.getInstance();
        Connection connection = databaseManager.connect();
        Assertions.assertNotNull(connection);
        Assertions.assertNotNull(connection.getMetaData());
        connection.close();
    }
}
