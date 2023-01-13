package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller pre zobrazenie stránok na danej ceste
 */
@Controller
public class PagesController {

    @RequestMapping("/charges")
    private String charges() {
        return "/charges.html";
    }

    @RequestMapping("/contacts")
    private String contact() {
        return "/contacts.html";
    }

    @RequestMapping("/lost_password")
    private String lostPassword() {
        return "/account/lostpassword";
    }
}
