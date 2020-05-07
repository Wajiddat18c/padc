package padc.dat18c.renoblvd.Repository;

import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.BasketProducts;


public interface BasketProductsRepo extends CrudRepository<BasketProducts, Integer > {
}