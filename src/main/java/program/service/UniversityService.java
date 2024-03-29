package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.University;
import program.repository.UniversityRepository;
import java.util.List;

@Service
public class UniversityService {
    @Autowired
    private UniversityRepository uniRepository;

    public List<University> findAllUniversities() {
        return uniRepository.findAll();
    }

    public University findUniversityByName(String name) {
        return uniRepository.findUniversityByNameUniversity(name);
    }

    public void saveUniversity(University university) {
        uniRepository.save(university);
    }

    public void deleteUniversity(University university) {
        uniRepository.delete(university);
    }
}
