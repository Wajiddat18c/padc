/**
 * padc.dat18c.renoblvd.auth
 */
package padc.dat18c.renoblvd.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/**
 * This is a Repository class that handles Sql quarries.
 */
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Long> {
    List<AuthGroup> findByUsername(String username);
}