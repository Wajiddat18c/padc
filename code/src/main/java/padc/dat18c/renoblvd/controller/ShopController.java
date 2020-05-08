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
import padc.dat18c.renoblvd.service.CategoriesService;
import padc.dat18c.renoblvd.service.NewsletterService;
import padc.dat18c.renoblvd.service.ProductsService;


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
        model.addAttribute("category", categoriesService.getAll());
        model.addAttribute("products", productsService.getAll());

        return "shop/products/showProducts";
    }


}
