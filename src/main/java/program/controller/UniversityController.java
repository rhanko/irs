package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import program.model.University;
import program.service.UniversityService;

import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService uniService;

    @GetMapping("/universities")
    public List<University> university(Model model) {
        List<University> universities = uniService.findAllUniversities();
        model.addAttribute("universities", universities);
        return universities;
    }
}