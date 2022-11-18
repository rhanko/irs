package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import program.model.User;
import program.service.RoleService;
import program.service.UserService;

import java.util.List;
import java.util.regex.Pattern;

/**
 * Trieda
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    private final Pattern patternUser = Pattern.compile("^[a-zA-Z0-9]+$");
    private final Pattern patternEmail = Pattern.compile("^[a-zA-Z0-9@.]+$");

    private final Pattern patternName = Pattern.compile("^[a-zA-Z]+$");




    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/account/register";
    }

    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User user, Model model, BindingResult result) {
        //vloženie role
        user.addRole(roleService.getRoleByName("User"));

        //kontrola vstupov
        usernameCheck(user, result);
        emailCheck(user, result);
        passwordCheck(user, result);
        nameCheck(user, result);

        //vypisanie chyb
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

    @GetMapping("/profile-edit")
    public String profileEdit(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        User user = userService.findUserByNickname(((UserDetails) principal).getUsername());
        user.setPassword(userService.findUserByNickname(user.getUsername()).getPassword());

        model.addAttribute("user", user);

        return "/account/profileedit";
    }

    @PostMapping("/profile-edit/save")
    public String profileSave(@ModelAttribute("user") User user, Model model, BindingResult result) {

        //nastavenie prihlaseneho uctu
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User userLoggedIn = userService.findUserByNickname(((UserDetails) principal).getUsername());

        if (!(user.equals(userLoggedIn) || user.getUsername().equals(userLoggedIn.getUsername()))) {
            //kontrola vstupov
            emailCheck(user, userLoggedIn, result);
            passwordCheck(user, result);
            nameCheck(user, result);
        }

        //vypisanie chyb
        if(result.hasErrors()) {
            model.addAttribute("user", user);
            return "/account/profileedit";
        }

        userService.saveUserEdited(user);
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

    private void usernameCheck(User user, BindingResult result) {
        User existingUserByUsername = userService.findUserByNickname(user.getUsername());

        //kontrola, či neexistuje uzivatelske meno
        if(existingUserByUsername != null && existingUserByUsername.getUsername() != null && !existingUserByUsername.getUsername().isEmpty()) {
            result.rejectValue("username", null, "Toto užívateľské meno sa už používa.");
        }

        //kontrola uzivatelskeho mena ci obsahuje len tie znaky co moze
        if(!patternUser.matcher(user.getUsername()).matches()) {
            result.rejectValue("username", null, "Môže obsahovať len znaky: a-z, A-Z, 0-9");
        }
    }

    private void emailCheck(User user, User userLoggedIn, BindingResult result) {
        User findUserByEmail = userService.findUserByEmail(user.getMail());
        //kontrola mailu
        if (user.getMail() == null && findUserByEmail != null && user.getMail().equals(findUserByEmail.getMail()) && !(userLoggedIn.getMail().equals(findUserByEmail.getMail()))) {
            result.rejectValue("mail", null, "Tento e-mail už používa iná osoba.");
        }

        //kontrola emailu ci obsahuje len tie znaky co moze
        if(!patternEmail.matcher(user.getMail()).matches()) {
            result.rejectValue("mail", null, "Môže obsahovať len znaky: a-z, A-Z, 0-9, \"@\" a \".\"");
        }
    }

    private void emailCheck(User user, BindingResult result) {
        User existingUserByMail = userService.findUserByEmail(user.getMail());

        //kontrola, či neexistuje mail
        if(existingUserByMail != null && existingUserByMail.getMail() != null && !existingUserByMail.getMail().isEmpty()) {
            result.rejectValue("mail", null, "Tento e-mail sa už používa.");
        }

        //kontrola emailu ci obsahuje len tie znaky co moze
        if(!patternEmail.matcher(user.getMail()).matches()) {
            result.rejectValue("mail", null, "Môže obsahovať len znaky: a-z, A-Z, 0-9, \"@\" a \".\"");
        }
    }

    private void passwordCheck(User user, BindingResult result) {
        //kontrola hesla
        if(user.getPassword().length() > 20 && user.getPassword().length() < 6) {
            result.rejectValue("password", null, "Musí obsahovať aspoň 6 znaky a najviac 20 znakov");
        }

    }

    private void nameCheck(User user, BindingResult result) {
        //kontrola mena
        if(!user.getFirstname().isEmpty() && !patternName.matcher(user.getFirstname()).matches()) {
            result.rejectValue("firstname", null, "Môže obsahovať len znaky: a-z a A-Z");
        }

        //kontrola priezviska
        if(!user.getSurname().isEmpty() && !patternName.matcher(user.getSurname()).matches()) {
            result.rejectValue("surname", null, "Môže obsahovať len znaky: a-z a A-Z");
        }
    }
}