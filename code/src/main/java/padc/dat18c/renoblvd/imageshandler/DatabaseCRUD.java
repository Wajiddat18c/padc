/**
 * padc.dat18c.renoblvd.imageshandler
 */
package padc.dat18c.renoblvd.imageshandler;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/**
 * This is a Repository class that handles Sql quarries.
 */
@Repository
public interface DatabaseCRUD extends CrudRepository<DatabaseFile, String > {
}
