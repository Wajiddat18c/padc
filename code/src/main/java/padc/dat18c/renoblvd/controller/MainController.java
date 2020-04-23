package padc.dat18c.renoblvd.controller;

//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.security.core.parameters.P;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import padc.dat18c.renoblvd.service.NewsletterService;


@Controller
public class MainController {

    @Autowired
    NewsletterService newsletterService;

    @GetMapping("/")
    public String frontPage(){
        return "index";
    }

    @GetMapping("/a")
    public String showNewsletter(Model model){
        model.addAttribute("newsletters", newsletterService.getAll());

        return "showNewsletter";
    }


}
