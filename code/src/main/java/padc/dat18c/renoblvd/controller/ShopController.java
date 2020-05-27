package padc.dat18c.renoblvd.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.*;
import padc.dat18c.renoblvd.service.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/shop/")
public class ShopController {

    @Autowired
    OrderService orderService;

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

    @Autowired
    BasketService basketService;

    @Autowired
    BasketProductsService basketProductsService;



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
    public String createCustomer(Model model,
                                 @RequestParam Optional<Integer> id,
                                 @RequestParam Optional<Integer> amt) {
        model.addAttribute("id", id.orElse(0));
        model.addAttribute("amt", amt.orElse(0));
        return "shop/customer/createCustomer";
    }


    @PostMapping("/createCustomer")
    public String createCustomer(@ModelAttribute CustomerInformation customerInformation,
                                 @RequestParam Optional<Integer> id,
                                 @RequestParam Optional<Integer> amt) {
        if(id.isPresent() && amt.isPresent()) {

            //Customer
            customerInformationService.create(customerInformation);

            //Basket
            Basket basket = new Basket();
            basket.setCreated(LocalDateTime.now().toString());
            basketService.create(basket);

            //Product & amount
            BasketProducts basketProducts = new BasketProducts();
            basketProducts.setAmount(amt.get());
            basketProducts.setProducts_idProducts(id.get());
            basketProductsService.create(basketProducts);


            //Order
            Order order = new Order();
            order.setCustomer_idCustomer(customerInformation.getIdcustomerInformation());
            order.setBasket_idBasket(basket.getIdBasket());
            order.setStatus("Ordered");
            orderService.create(order);

        }
        else
            customerInformationService.create(customerInformation);
        return "redirect:/";
    }

}
