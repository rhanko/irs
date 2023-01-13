package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
    List<Faculty> getFacultiesByUniversityId(int id);
}
