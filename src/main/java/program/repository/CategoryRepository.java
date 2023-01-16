package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
