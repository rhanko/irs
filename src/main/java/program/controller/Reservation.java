package program.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Reservation {
    @RequestMapping("/reservation")
    public String contact() {
        return "/reservation.html";
    }
}

