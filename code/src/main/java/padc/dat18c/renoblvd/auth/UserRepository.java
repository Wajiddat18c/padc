/**
 * padc.dat18c.renoblvd.auth
 */
package padc.dat18c.renoblvd.auth;


import org.springframework.data.jpa.repository.JpaRepository;
/**
 * This is a Repository class that handles Sql quarries.
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}