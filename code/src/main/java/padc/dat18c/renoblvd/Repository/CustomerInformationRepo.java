package padc.dat18c.renoblvd.Repository;

import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.CustomerInformation;

public interface CustomerInformationRepo extends CrudRepository<CustomerInformation, Integer > {
}

