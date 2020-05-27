package padc.dat18c.renoblvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.OrderRepo;
import padc.dat18c.renoblvd.model.Order;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    final OrderRepo orderRepo;

    @Autowired
    private OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public void create(Order order){
        orderRepo.save(order);
    }
    public void delete(int idOrder){
        orderRepo.deleteById(idOrder);
    }
    public void update(Order order){
        orderRepo.save(order);
    }
    public Order findById(int idOrder){
        Optional<Order> find = orderRepo.findById(idOrder);
        if (find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Order> getAll(){
        return (List<Order>) orderRepo.findAll();
    }
}
