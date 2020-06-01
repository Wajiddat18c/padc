/**
 * padc.dat18c.renoblvd.service
 */
package padc.dat18c.renoblvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.ProductsRepo;
import padc.dat18c.renoblvd.model.Products;

import java.util.List;
import java.util.Optional;
/**
 * This class handles all of the Crud-operations
 */

@Service
public class ProductsService {

    final ProductsRepo productsRepo;

    @Autowired
    private ProductsService(ProductsRepo productsRepo){
        this.productsRepo = productsRepo;
    }

    public void create(Products products){
        productsRepo.save(products);

    }
    public void delete(int idProducts){
        productsRepo.deleteById(idProducts);
    }
    public void update(Products products){
        productsRepo.save(products);
    }
    public Products findById(int idProducts){
        Optional<Products>find = productsRepo.findById(idProducts);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Products>getAll(){
        return (List<Products>) productsRepo.findAll();
    }
}
