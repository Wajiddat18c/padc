package padc.dat18c.renoblvd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import padc.dat18c.renoblvd.imageshandler.DatabaseFileService;
import padc.dat18c.renoblvd.imageshandler.FileInfoService;
import padc.dat18c.renoblvd.model.Productstoimages;
import padc.dat18c.renoblvd.service.ProductsService;
import padc.dat18c.renoblvd.service.ProductstoimagesService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    DatabaseFileService databaseFileService;
    @Autowired
    ProductsService productsService;
    @Autowired
    ProductstoimagesService productstoimagesService;
    @Autowired
    FileInfoService fileInfoService;

    @GetMapping("/")
    public String frontPage(Model model){

        model.addAttribute("product", productsService.getAll());
        List<Productstoimages> productstoimagesList = productstoimagesService.getAll();
        List<Productstoimages> result = new ArrayList<>();

        for(Productstoimages productstoimages : productstoimagesList){
            boolean contains = false;
            for(Productstoimages productstoimages1 : result){
                if(productstoimages1.getProducts_id_Products() == productstoimages.getProducts_id_Products()) {
                    contains = true;
                    break;
                }
            }
            if(!contains)
                result.add(productstoimages);
        }

        model.addAttribute("imgproduct", result);

        return "shop/index";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin/adminIndex";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout-success")
    public String getLogoutPage(){
        return "logout";
    }

    @GetMapping("/product/{id}")
    public String viewProduct(@PathVariable("id")int id, Model model){

        model.addAttribute("productImgs", productstoimagesService.getByProdId(id));
        model.addAttribute(("product"), productsService.findById(id));
        return "shop/products/showProduct";
    }

}
