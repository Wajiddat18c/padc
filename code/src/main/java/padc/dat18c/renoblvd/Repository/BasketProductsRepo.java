/**
 * padc.dat18c.renoblvd.Repository
 */
package padc.dat18c.renoblvd.Repository;

import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.BasketProducts;
/**
 * This is a Repository class that handles Sql quarries.
 */

public interface BasketProductsRepo extends CrudRepository<BasketProducts, Integer > {
}