package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pre zobrazenie stránok na danej ceste
 */
@Controller
public class PagesController {


    @RequestMapping("/home")
    private String home() {
        return "/index.html";
    }

    @RequestMapping("/charges")
    private String charges() {
        return "/charges.html";
    }

    @RequestMapping("/contacts")
    private String contact() {
        return "/contacts.html";
    }

    @RequestMapping("/profile")
    private String profile() {
        return "/account/profile.html";
    }

    @RequestMapping("/lost_password")
    private String lostPassword() {
        return "/account/lostpassword.html";
    }

    @RequestMapping("/login")
    private String login() {
        return "/account/login.html";
    }

    @RequestMapping("/users")
    public String users() {
        return "/account/users";
    }

}
