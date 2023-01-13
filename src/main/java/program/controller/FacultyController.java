package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import program.model.Faculty;
import program.service.FacultyService;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @GetMapping("/faculties/university/{id}")
    public List<Faculty> getFacultyByUniversity(Model model, @PathVariable String id) {
        int cId = Integer.parseInt(id);
        List<Faculty> faculties = facultyService.getAllFacultiesByUniversity(cId);
        model.addAttribute("faculties", faculties);
        return faculties;
    }
}
