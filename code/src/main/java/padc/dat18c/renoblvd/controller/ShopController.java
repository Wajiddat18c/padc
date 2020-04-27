package padc.dat18c.renoblvd.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.Newsletter;
import padc.dat18c.renoblvd.service.CategoriesService;
import padc.dat18c.renoblvd.service.NewsletterService;


@Controller
@RequestMapping("/shop/")
public class ShopController {

    @Autowired
    NewsletterService newsletterService;

    @Autowired
    CategoriesService categoriesService;

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



}
