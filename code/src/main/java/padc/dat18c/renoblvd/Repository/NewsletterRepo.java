/**
 * padc.dat18c.renoblvd.Repository
 */
package padc.dat18c.renoblvd.Repository;


import padc.dat18c.renoblvd.model.Newsletter;
import org.springframework.data.repository.CrudRepository;
/**
 * This is a Repository class that handles Sql quarries.
 */
public interface NewsletterRepo extends CrudRepository<Newsletter, Integer > {

}
