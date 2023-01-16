package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import program.model.Faculty;
import program.model.University;
import program.service.FacultyService;
import program.service.UniversityService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class UniversityController {

    @Autowired
    private UniversityService uniService;

    @Autowired
    private FacultyService facService;

    @GetMapping("/universities")
    public List<University> universities(Model model) {
        List<University> universities = uniService.findAllUniversities();
        model.addAttribute("universities", universities);
        return universities;
    }

    @PostMapping("/university/save")
    public void saveUniversity(University university) {
        uniService.saveUniversity(university);
    }

    @GetMapping("/university/{universityName}/delete")
    public void deleteUniversity(HttpServletResponse response, @PathVariable("universityName") String universityName) throws IOException {
        University uni = uniService.findUniversityByName(universityName);
        List<Faculty> facs = facService.getAllFacultiesByUniversity(uni.getId());

        for (Faculty fac : facs) {
            facService.deleteFaculty(fac);
        }

        uniService.deleteUniversity(uni);
        response.sendRedirect("/settings?university_successfully_deleted");
    }
}