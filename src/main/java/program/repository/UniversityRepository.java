package program.repository;

import org.springframework.data.repository.CrudRepository;
import program.model.University;

public interface UniversityRepository extends CrudRepository<University, Integer> {
}
