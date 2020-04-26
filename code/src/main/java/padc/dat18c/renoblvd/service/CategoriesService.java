package padc.dat18c.renoblvd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import padc.dat18c.renoblvd.Repository.CategoriesRepo;
import padc.dat18c.renoblvd.model.Categories;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriesService {
    final CategoriesRepo categoriesRepo;

    @Autowired
    private CategoriesService(CategoriesRepo categoriesRepo){
        this.categoriesRepo = categoriesRepo;
    }

    public void create(Categories categories){
        categoriesRepo.save(categories);
    }

    public void delete(int idCategories){
        categoriesRepo.deleteById(idCategories);
    }

    public void update(Categories categories){
        categoriesRepo.save(categories);
    }

    public Categories findbyId(int idCategories){
        Optional<Categories>find = categoriesRepo.findById(idCategories);
        if(find.isPresent()){
            return find.get();
        }
        return null;
    }
    public List<Categories>getAll(){
        return (List<Categories>)categoriesRepo.findAll();
    }
}
