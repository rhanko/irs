package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Charges {
    @RequestMapping("/charges")
    public String contact() {
        return "/charges.html";
    }
}

