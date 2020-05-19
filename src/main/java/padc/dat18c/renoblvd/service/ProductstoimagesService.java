package padc.dat18c.renoblvd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.ProductstoimagesRepo;
import padc.dat18c.renoblvd.model.Productstoimages;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductstoimagesService {

    final ProductstoimagesRepo productstoimagesRepo;

    @Autowired
    private ProductstoimagesService(ProductstoimagesRepo productstoimagesRepo){
        this.productstoimagesRepo = productstoimagesRepo;
    }

    public void delete(int idProductsToImages){
        productstoimagesRepo.deleteById(idProductsToImages);
    }

    public void create(Productstoimages productstoimages){
        productstoimagesRepo.save(productstoimages);
    }

    public void update(Productstoimages productstoimages){
        productstoimagesRepo.save(productstoimages);
    }

    public Productstoimages findById(int idProductsToImages){
        Optional<Productstoimages> find = productstoimagesRepo.findById(idProductsToImages);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Productstoimages>getAll(){
        return (List<Productstoimages>) productstoimagesRepo.findAll();
    }
    public List<Productstoimages>getByProdId(int id){
        List<Productstoimages> result = new ArrayList<>();
        List<Productstoimages> all = (List<Productstoimages>) productstoimagesRepo.findAll();
        for(Productstoimages productstoimages : all){
            if(productstoimages.getProducts_id_Products() == id)
                result.add(productstoimages);
        }
        return result;
    }

}
