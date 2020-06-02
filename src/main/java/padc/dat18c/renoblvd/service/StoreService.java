/**
 * padc.dat18c.renoblvd.service
 */
package padc.dat18c.renoblvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.StoreRepo;
import padc.dat18c.renoblvd.model.Store;

import java.util.List;
import java.util.Optional;
/**
 * This class handles all of the Crud-operations
 */

@Service
public class StoreService {
    final StoreRepo storeRepo;

    @Autowired
    private StoreService(StoreRepo storeRepo){ this.storeRepo = storeRepo; }

    public void create(Store store){
        storeRepo.save(store);
    }

    public void delete(int idStore){
        storeRepo.deleteById(idStore);
    }

    public void update(Store store){
        storeRepo.save(store);
    }

    public Store findById(int idStore){
        Optional<Store>find = storeRepo.findById(idStore);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }

    public List<Store>getAll(){
        return (List<Store>) storeRepo.findAll();
    }


}
