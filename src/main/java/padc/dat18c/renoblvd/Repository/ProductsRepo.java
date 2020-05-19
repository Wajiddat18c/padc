package padc.dat18c.renoblvd.Repository;

import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.Products;

public interface ProductsRepo extends CrudRepository<Products, Integer > {

}