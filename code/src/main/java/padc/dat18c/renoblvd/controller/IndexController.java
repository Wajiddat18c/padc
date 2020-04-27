package padc.dat18c.renoblvd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String frontPage(){
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

}
