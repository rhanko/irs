package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Articles {
    @RequestMapping("/")
    public String contact() {
        return "/index.html";
    }
}

