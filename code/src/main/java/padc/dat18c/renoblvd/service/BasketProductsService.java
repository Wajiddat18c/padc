package padc.dat18c.renoblvd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.BasketProductsRepo;
import padc.dat18c.renoblvd.model.BasketProducts;
import java.util.List;

import java.util.Optional;

@Service
public class BasketProductsService {
    final BasketProductsRepo basketProductsRepo;

    @Autowired
    private BasketProductsService(BasketProductsRepo basketProductsRepo){
        this.basketProductsRepo = basketProductsRepo;
    }

    public void create(BasketProducts basketProducts){
        basketProductsRepo.save(basketProducts);
    }

    public void delete(int idbasketProducts){
        basketProductsRepo.deleteById(idbasketProducts);
    }

    public void update(BasketProducts basketProducts){
        basketProductsRepo.save(basketProducts);
    }

    public BasketProducts findbyId(int idbasketProducts){
        Optional<BasketProducts>find = basketProductsRepo.findById(idbasketProducts);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }

    public List<BasketProducts>getAll(){
        return (List<BasketProducts>)basketProductsRepo.findAll();
    }
}
