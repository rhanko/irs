package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import program.model.User;
import program.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String users(Model model) {
        Object principalloggeduser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userlogged = userService.findUserByNickname(((UserDetails) principalloggeduser).getUsername());
        model.addAttribute("userlogged", userlogged);

        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "users/users";
    }

    @GetMapping("/user/{username}")
    public String user(Model model, @PathVariable("username") String username) {
        Object principalloggeduser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userlogged = userService.findUserByNickname(((UserDetails) principalloggeduser).getUsername());
        model.addAttribute("userlogged", userlogged);

        if(!userService.existUserByUsername(username)) {
            return "redirect:/users?username_not_exist";
        }

        User user = userService.findUserByNickname(username);
        model.addAttribute("user", user);
        return "users/user";
    }

    @GetMapping("/user/{username}/edit")
    public String edituser(Model model, @PathVariable("username") String username) {
        if(!userService.existUserByUsername(username)) {
            return "redirect:/users?username_not_exist";
        }

        Object principalloggeduser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userlogged = userService.findUserByNickname(((UserDetails) principalloggeduser).getUsername());
        model.addAttribute("userlogged", userlogged);

        if(!userService.existUserByUsername(username)) {
            return "redirect:/users?username_not_exist";
        }

        User user = userService.findUserByNickname(username);
        model.addAttribute("user", user);
        return "users/useredit";
    }

    @PostMapping("/user/{username}/save")
    public String saveuser(User user, Model model, BindingResult result, @PathVariable("username") String username) {
        Object principalloggeduser = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userlogged = userService.findUserByNickname(((UserDetails) principalloggeduser).getUsername());
        model.addAttribute("userlogged", userlogged);

        if(!userService.existUserByUsername(username)) {
            return "redirect:/users?username_not_exist";
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "users/useredit";
        }

        userService.saveUserEdited(user);
        return "redirect:/users?user_successfully_edited";
    }

    @GetMapping("user/{username}/delete")
    public String deleteUser(@PathVariable("username") String username) {
        if(!userService.existUserByUsername(username)) {
            return "redirect:/users?username_not_exist";
        }

        userService.deleteUserById(userService.findUserByNickname(username).getId());
        return "redirect:/users?user_successfully_deleted";
    }
}
