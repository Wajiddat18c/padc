package padc.dat18c.renoblvd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.BasketRepo;
import padc.dat18c.renoblvd.model.Basket;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService {
    final BasketRepo basketRepo;

    @Autowired
    private BasketService(BasketRepo basketRepo){
        this.basketRepo = basketRepo;
    }

    public void create(Basket basket){
        basketRepo.save(basket);
    }

    public void delete(int idBasket){
        basketRepo.deleteById(idBasket);
    }

    public void update(Basket basket){
        basketRepo.save(basket)
    }

    public Basket findById(int idBasket){
        Optional<Basket>find = basketRepo.findById(idBasket);
        if (find.isPresent()){
            return find.get();
        }
        return null;
    }

    public List<Basket>getAll(){
        return (List<Basket>) basketRepo.findAll();
    }
}
