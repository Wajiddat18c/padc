/**
 * padc.dat18c.renoblvd.imageshandler
 */
package padc.dat18c.renoblvd.imageshandler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * This class handles all of the Crud-operations
 */

@Service
public class DatabaseSERVICE {
    final DatabaseCRUD databaseCRUD;

    @Autowired
    private DatabaseSERVICE(DatabaseCRUD databaseCRUD){
        this.databaseCRUD = databaseCRUD;
    }

    public void update(DatabaseFile databaseFile){
        databaseCRUD.save(databaseFile);
    }

    public DatabaseFile findbyId(String id){
        Optional<DatabaseFile> find = databaseCRUD.findById(id);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }
}
