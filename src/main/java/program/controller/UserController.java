package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import program.model.User;
import program.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "/account/users";
    }

    @GetMapping("/user/{username}")
    public String user(Model model, @PathVariable("username") String username) {
        User user = userService.findUserByNickname(username);
        model.addAttribute("user", user);
        return "/account/user";
    }
}
