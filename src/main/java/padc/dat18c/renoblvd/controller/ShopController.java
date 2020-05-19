package padc.dat18c.renoblvd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.Newsletter;
import padc.dat18c.renoblvd.model.Productstoimages;
import padc.dat18c.renoblvd.service.CategoriesService;
import padc.dat18c.renoblvd.service.NewsletterService;
import padc.dat18c.renoblvd.service.ProductsService;
import padc.dat18c.renoblvd.service.ProductstoimagesService;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/shop/")
public class ShopController {

    @Autowired
    NewsletterService newsletterService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    ProductsService productsService;

    @Autowired
    ProductstoimagesService productstoimagesService;

    @Autowired
    UserService userService;


    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout-success")
    public String getLogoutPage(){
        return "logout";
    }


    @GetMapping("/signup")
    public String  createTeachers(){
        return "shop/news/signupNewsletter";
    }

    @PostMapping("/signup")
    public String createTeachers(@ModelAttribute Newsletter newsletter)
    {
        newsletterService.create(newsletter);
        return "redirect:/";
    }

    @GetMapping("/products")
    public String showProducts(Model model) {
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
        model.addAttribute("category", categoriesService.getAll());

        return "shop/products/showProducts";
    }


}
