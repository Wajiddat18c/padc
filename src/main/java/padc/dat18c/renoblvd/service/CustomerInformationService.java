/**
 * padc.dat18c.renoblvd.service
 */
package padc.dat18c.renoblvd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.CustomerInformationRepo;
import padc.dat18c.renoblvd.model.CustomerInformation;

import java.util.List;
import java.util.Optional;
/**
 * This class handles all of the Crud-operations
 */

@Service
public class CustomerInformationService {

    final CustomerInformationRepo customerInformationRepo;

    @Autowired
    private CustomerInformationService(CustomerInformationRepo customerInformationRepo){
        this.customerInformationRepo = customerInformationRepo;
    }

    public void create(CustomerInformation customerInformation){
        customerInformationRepo.save(customerInformation);
    }
    public void delete(int idcustomerInformation){
        customerInformationRepo.deleteById(idcustomerInformation);
    }

    public void update(CustomerInformation customerInformation){
        customerInformationRepo.save(customerInformation);
    }
    public CustomerInformation findById(int idcustomerInformation){
        Optional<CustomerInformation>find = customerInformationRepo.findById(idcustomerInformation);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<CustomerInformation>getAll(){
        return (List<CustomerInformation>)customerInformationRepo.findAll();
    }

}
