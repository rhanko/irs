package program.repository;

import org.springframework.data.repository.CrudRepository;
import program.model.Faculty;

public interface FacultyRepository extends CrudRepository<Faculty, Integer> {
}
