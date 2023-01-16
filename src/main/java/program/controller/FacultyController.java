package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import program.model.Faculty;
import program.service.FacultyService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

    @PostMapping("/faculty/save")
    public void saveUniversity(Faculty faculty) {
        if (faculty.getUniversity() == null) {
            Faculty fac = facultyService.getFacultyById(faculty.getId());
            faculty.setUniversity(fac.getUniversity());
        }
        facultyService.saveFaculty(faculty);
    }

    @GetMapping("/faculty/{facultyName}/delete")
    public void deleteUniversity(HttpServletResponse response, @PathVariable("facultyName") String facultyName) throws IOException {
        facultyService.deleteFaculty(facultyService.getFacultyByName(facultyName));
        response.sendRedirect("/settings?university_successfully_deleted");
    }
}
