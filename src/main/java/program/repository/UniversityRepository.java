package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.University;

public interface UniversityRepository extends JpaRepository<University, Integer> {
}
