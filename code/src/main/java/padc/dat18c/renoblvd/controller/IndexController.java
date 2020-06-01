/**
 * padc.dat18c.renoblvd.controller
 */
package padc.dat18c.renoblvd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import padc.dat18c.renoblvd.imageshandler.DatabaseFileService;
import padc.dat18c.renoblvd.imageshandler.FileInfoService;
import padc.dat18c.renoblvd.service.ProductsService;
import padc.dat18c.renoblvd.service.ProductstoimagesService;
import padc.dat18c.renoblvd.service.StoreService;

/**
 * This i an Controller class that routes web pages
 * This class has responsibility to handle the index page
 */

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
    @Autowired
    StoreService storeService;

    //Store id in DB
    public final int storeId = 1;

    @GetMapping("/")
    public String frontPage(Model model){

        model.addAttribute("product", productsService.getAll());
        model.addAttribute("imgproduct", productstoimagesService.firstImgForProduct());
        model.addAttribute("shop", storeService.findById(storeId));
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
