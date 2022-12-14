package FrostBytePCs.repository;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

public interface DAOInterface<T> {
    /**
     * Gets all of T from the database
     * @return List of all objects of type T from the database
     */
    List<T> getAll();

    /**
     * Gets a single object of type T from the database by id
     * @param id id of object to get
     * @return Object of type T that has id given
     */
    T getOne(int id);

    /**
     * Adds a single object of type T to database
     * @param toAdd object of type T to add
     * @throws DuplicateEntryException if the object already exists
     * @return object insert id if inserted correctly
     */
    int add(T toAdd) throws DuplicateFormatFlagsException;

    /**
     * Deletes and object from database that matches id given
     * @param id id of object to delete
     */
    void delete(int id);

    /**
     * Updates an object in the database
     * @param toUpdate Object that needs to be updated (this object must be able to identify itself and its previous self)
     */
    void update(T toUpdate);
}
