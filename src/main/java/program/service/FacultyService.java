package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Faculty;
import program.model.User;
import program.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UserService userService;

    public List<Faculty> getAllFacultiesByUniversity(int id) {
        return facultyRepository.getFacultiesByUniversityId(id);
    }

    public List<Faculty> getAllFaculties() {
        return facultyRepository.findAll();
    }

    public Faculty getFacultyByName(String facultyName) {
        return facultyRepository.findFacultyByName(facultyName);
    }

    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public void deleteFaculty(Faculty faculty) {
        List<User> users = userService.getUserByFaculty(faculty);

        if (!users.isEmpty()) {
            for (User user : users) {
                user.setFaculty(facultyRepository.getFacultyById(0));
            }
        }

        facultyRepository.delete(faculty);
    }

    public Faculty getFacultyById(int id) {
        return facultyRepository.getFacultyById(id);
    }
}
