/**
 * padc.dat18c.renoblvd.Repository
 */
package padc.dat18c.renoblvd.Repository;
import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.Categories;
/**
 * This is a Repository class that handles Sql quarries.
 */
public interface CategoriesRepo extends CrudRepository<Categories, Integer > {
}
