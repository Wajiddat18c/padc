package padc.dat18c.renoblvd.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.parameters.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.Newsletter;
import padc.dat18c.renoblvd.service.CategoriesService;
import padc.dat18c.renoblvd.service.NewsletterService;


@Controller
public class MainController {

    @Autowired
    NewsletterService newsletterService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String frontPage(){
        return "index";
    }

    @GetMapping("/news")
    public String showNewsletter(Model model){
        model.addAttribute("newsletters", newsletterService.getAll());

        return "showNewsletter";
    }


    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(){
        return "adminIndex";
    }

    @GetMapping(value = "/login")
    public String getLoginPage(){
        return "login";
    }
    @GetMapping(value = "/logout-success")
    public String getLogoutPage(){
        return "logout";
    }




    @GetMapping("/delete/{id}")
    public String deleteNewsletter(@PathVariable("id") int idNews)
    {
        newsletterService.delete(idNews);
        return "redirect:/news";
    }


    @GetMapping("/news/createNewsletter")
    public String  createTeachers(){
        return "createNewsletter";
    }

    @PostMapping("/news/createNewsletter")
    public String createTeachers(@ModelAttribute Newsletter newsletter)
    {
        newsletterService.create(newsletter);
        return "redirect:/news";
    }


    @GetMapping("updateNewsletter/{idNews}")
    public String updateNewsletter(@PathVariable("idNews") int idNews, Model model){
        model.addAttribute("newsletter", newsletterService.findById(idNews));
        return "updateNewsletter";
    }
    @PostMapping("/updateNewsletter")
    public String updateTeacher(@ModelAttribute Newsletter newsletter){
        newsletterService.update(newsletter);
        return "redirect:/news";
    }

}
