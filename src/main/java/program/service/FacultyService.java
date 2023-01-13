package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Faculty;
import program.repository.FacultyRepository;

import java.util.List;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    public List<Faculty> getAllFacultiesByUniversity(int id) {
        return facultyRepository.getFacultiesByUniversityId(id);
    }
}
