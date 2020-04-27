package padc.dat18c.renoblvd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import padc.dat18c.renoblvd.auth.UserService;
import padc.dat18c.renoblvd.model.Newsletter;
import padc.dat18c.renoblvd.service.CategoriesService;
import padc.dat18c.renoblvd.service.NewsletterService;


@Controller
@RequestMapping("/admin/")
public class AdminController {

    @Autowired
    NewsletterService newsletterService;

    @Autowired
    CategoriesService categoriesService;

    @Autowired
    UserService userService;

    @GetMapping("/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String adminPage(){
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



    @GetMapping("/news")
    public String showNewsletter(Model model){
        model.addAttribute("newsletters", newsletterService.getAll());

        return "admin/news/showNewsletter";
    }





    @GetMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String deleteNewsletter(@PathVariable("id") int idNews)
    {
        newsletterService.delete(idNews);
        return "redirect:/admin/news";
    }


    @GetMapping("/createNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String  createTeachers(){
        return "admin/news/createNewsletter";
    }

    @PostMapping("/createNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String createTeachers(@ModelAttribute Newsletter newsletter)
    {
        newsletterService.create(newsletter);
        return "redirect:/admin/news";
    }


    @GetMapping("/updateNewsletter/{idNews}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateNewsletter(@PathVariable("idNews") int idNews, Model model){
        model.addAttribute("newsletter", newsletterService.findById(idNews));
        return "admin/news/updateNewsletter";
    }
    @PostMapping("/updateNewsletter")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String updateTeacher(@ModelAttribute Newsletter newsletter){
        newsletterService.update(newsletter);
        return "redirect:/admin/news";
    }

}
