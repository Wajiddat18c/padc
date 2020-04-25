package padc.dat18c.renoblvd.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.parameters.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import padc.dat18c.renoblvd.service.NewsletterService;


@Controller
public class MainController {

    @Autowired
    NewsletterService newsletterService;

    @GetMapping("/")
    public String frontPage(){
        return "index";
    }

    @GetMapping("/news")
    public String showNewsletter(Model model){
        model.addAttribute("newsletters", newsletterService.getAll());

        return "showNewsletter";
    }


    @GetMapping("/delete/{id}")
    public String deleteNewsletter(@PathVariable("id") int idNews)
    {
        newsletterService.delete(idNews);
        return "redirect:/news";
    }


}
