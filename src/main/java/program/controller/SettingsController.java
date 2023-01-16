package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import program.model.Category;
import program.model.Faculty;
import program.model.University;
import program.model.User;
import program.service.CategoryService;
import program.service.FacultyService;
import program.service.UniversityService;
import program.service.UserService;

import java.util.List;

@Controller
public class SettingsController {

    @Autowired
    private UserService userService;

    @Autowired
    private UniversityService uniService;

    @Autowired
    private FacultyService facService;

    @Autowired
    private CategoryService catService;

    @GetMapping("/settings")
    public String university(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByNickname(((UserDetails) principal).getUsername());
        model.addAttribute("userlogged", user);

        List<University> universities = uniService.findAllUniversities();
        model.addAttribute("universities", universities);

        List<Faculty> faculties = facService.getAllFaculties();
        model.addAttribute("faculties", faculties);

        List<Category> categories =  catService.getAllCategories();
        model.addAttribute("categories", categories);
        return "settings.html";
    }
}
