package padc.dat18c.renoblvd.imageshandler;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DatabaseCRUD extends CrudRepository<DatabaseFile, String > {
}
