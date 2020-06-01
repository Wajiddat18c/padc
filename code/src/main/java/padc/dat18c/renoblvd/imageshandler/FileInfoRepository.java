/**
 * This is a Repository class that handles Sql quarries.
 */
package padc.dat18c.renoblvd.imageshandler;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is a Repository class that handles Sql quarries.
 */
@Repository
public interface FileInfoRepository extends JpaRepository<FileInfo, String> {
}