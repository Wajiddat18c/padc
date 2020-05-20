package padc.dat18c.renoblvd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.CustomerInformation;
import padc.dat18c.renoblvd.model.Newsletter;
import padc.dat18c.renoblvd.model.Productstoimages;
import padc.dat18c.renoblvd.service.*;

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

    @Autowired
    CustomerInformationService customerInformationService;

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

        model.addAttribute("imgproduct", productstoimagesService.firstImgForProduct());
        model.addAttribute("category", categoriesService.getAll());

        return "shop/products/showProducts";
    }

    @GetMapping("/createCustomer")
    public String createCustomer() {
        return "shop/customer/createCustomer";
    }

    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute CustomerInformation customerInformation) {
        customerInformationService.create(customerInformation);
        return "redirect:/";
    }

}
