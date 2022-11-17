package FrostBytePCs.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import FrostBytePCs.model.Part;

public class PartDAO implements DAOInterface<Part> {
    private final DatabaseManager databaseManager;
    private static final Logger log = LogManager.getLogger();
    
    /**
     * Creates a new PartDAO object and gets a reference to the database singleton
     */
    public PartDAO() {
        databaseManager = DatabaseManager.getInstance();
    }

    /**
     * Gets all of Parts from the database
     * @return a list of all parts
     */
    @Override
    public List<Part> getAll() {
        List<Part> parts = new ArrayList<>();
        String sql = "SELECT * FROM parts";
        try (Connection conn = databaseManager.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                parts.add(new Part(
                    rs.getInt("partID"),
                    rs.getString("name"), 
                    rs.getString("type"), 
                    rs.getString("condition"), 
                    rs.getFloat("price"),
                    rs.getString("purchaseDate"), 
                    rs.getString("warrantyDate"), 
                    rs.getString("store"),
                    rs.getInt("received")
                ));
            }
            return parts;
        } catch (SQLException sqlException) {
            log.error("Error getting all parts", sqlException);
            return new ArrayList<>();
        }
    }

    /**
     * Gets a single part from the database by id
     * 
     * @param id id of part to get
     * @return Part from database with the given id
     */
    @Override
    public Part getOne(int id) {
        Part part = null;
        String sql = "SELECT * FROM parts WHERE partID=?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    part = new Part(
                        rs.getInt("partID"),
                        rs.getString("name"), 
                        rs.getString("type"), 
                        rs.getString("condition"), 
                        rs.getFloat("price"),
                        rs.getString("purchaseDate"), 
                        rs.getString("warrantyDate"), 
                        rs.getString("store"),
                        rs.getInt("recieved")
                    );
                }
                return part;
            }
        } catch (SQLException sqlException) {
            log.error("Error getting part with id " + id, sqlException);
            return null;
        }
    }

    /**
     * Adds an individual part to the database
     * @param toAdd part to add
     * @return true if no error, false if sql error
     */
    @Override
    public int add(Part toAdd) {
        String sql = "INSERT INTO parts (name, type, condition, price, purchaseDate, warrantyDate, store, received) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseManager.connect();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, toAdd.getPartName());
            ps.setString(2, toAdd.getPartType());
            ps.setString(3, toAdd.getPartCondition());
            ps.setFloat(4, toAdd.getPartPrice());
            ps.setString(5, toAdd.getPurchaseDate());
            ps.setString(6, toAdd.getWarrantyDate());
            ps.setString(7, toAdd.getPartStore());
            ps.setInt(8, toAdd.getReceived());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            int insertId = -1;

            if (rs.next()) {
                insertId = rs.getInt(1);
            }
            return insertId;
        } catch (SQLException sqlException) {
            log.error("Error adding part", sqlException);
            return -1;
        }
    }

    /**
     * Adds a batch of parts to the database
     * This is done much quicker than individually
     * @param toAdd list of parts to add to the database
     */
    public void addBatch(List<Part> toAdd) {
        String sql = "INSERT INTO parts (name, type, condition, price, purchaseDate, warrantyDate, store, received) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = databaseManager.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (Part part : toAdd) {
                ps.setString(1, part.getPartName());
                ps.setString(2, part.getPartType());
                ps.setString(3, part.getPartCondition());
                ps.setFloat(4, part.getPartPrice());
                ps.setString(5, part.getPurchaseDate());
                ps.setString(6, part.getWarrantyDate());
                ps.setString(7, part.getPartStore());
                ps.setInt(8, part.getReceived());

                ps.addBatch();
            }
            ps.executeBatch();
            conn.commit();
        } catch (SQLException sqlException) {
            log.error("Error adding batch of parts", sqlException);
        }
    }

    /**
     * Deletes a part from the database by id
     * @param id id of part to delete
     */
    @Override
    public void delete(int id) {
        String sql = "DELETE FROM parts WHERE partID=?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException sqlException) {
            log.error("Error deleting part with id " + id, sqlException);
        }
    }

    /**
     * Updates a part in the database
     * @param toUpdate part to update
     */
    @Override
    public void update(Part toUpdate) {
        String sql = "UPDATE parts SET name=?, type=?, condition=?, price=?, purchaseDate=?, warrantyDate=?, store=?, received=? WHERE partID=?";
        try (Connection conn = databaseManager.connect();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, toUpdate.getPartName());
                stmt.setString(2, toUpdate.getPartType());
                stmt.setString(3, toUpdate.getPartCondition());
                stmt.setFloat(4, toUpdate.getPartPrice());
                stmt.setString(5, toUpdate.getPurchaseDate());
                stmt.setString(6, toUpdate.getWarrantyDate());
                stmt.setString(7, toUpdate.getPartStore());
                stmt.setInt(8, toUpdate.getReceived());
                stmt.setInt(9, toUpdate.getPartID());
                stmt.executeUpdate();

        } catch (SQLException sqlException) {
            log.error("Error updating part", sqlException);
        }        
    }
}
