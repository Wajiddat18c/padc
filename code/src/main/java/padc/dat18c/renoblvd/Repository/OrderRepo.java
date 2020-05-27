package padc.dat18c.renoblvd.Repository;

import org.springframework.data.repository.CrudRepository;
import padc.dat18c.renoblvd.model.Order;

public interface OrderRepo extends CrudRepository<Order, Integer> {
}
