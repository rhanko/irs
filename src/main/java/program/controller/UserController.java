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
import program.service.RoleService;
import program.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Trieda
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/account/register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid User user, Model model, BindingResult result) {
        //vloženie role
        user.addRole(roleService.getRoleByName("User"));

        User existingUserByUsername = userService.findUserByNickname(user.getUsername());

        //kontrola, či neexistuje uzivatelske meno
        if(existingUserByUsername != null && existingUserByUsername.getUsername() != null && !existingUserByUsername.getUsername().isEmpty()) {
            result.rejectValue("username", null, "Toto užívateľské meno sa už používa.");
        }

        User existingUserByMail = userService.findUserByEmail(user.getMail());

        //kontrola, či neexistuje mail
        if(existingUserByMail != null && existingUserByMail.getMail() != null && !existingUserByMail.getMail().isEmpty()) {
            result.rejectValue("mail", null, "Tento e-mail sa už používa.");
        }

        //kontrola hesla
        if(user.getPassword().length() > 20 && user.getPassword().length() < 6) {
            result.rejectValue("password", null, "Musí obsahovať aspoň 6 znaky a najviac 20 znakov");
        }

        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "/account/register";
        }

        userService.saveUser(user);
        return "redirect:/login?register_success";
    }

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

    @GetMapping("/profile")
    public String profile(Model model) {

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findUserByNickname(((UserDetails) principal).getUsername());

        model.addAttribute("user", user);
        return "/account/profile";
    }

    @PostMapping("/profile/save")
    public String profileEdit(@Valid User user, Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User userLoggedIn = userService.findUserByNickname(((UserDetails) principal).getUsername());

        model.addAttribute("user", user);

        return("redirect:/profile?edit_success");
    }

    @GetMapping("/login")
    public String login() {
        return "/account/login";
    }

    @GetMapping("/profile/delete")
    public String deleteUserById() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findUserByNickname(((UserDetails) principal).getUsername());

        userService.deleteUserById(user.getId());
        return "redirect:/login?account_has_been_deleted";
    }
}