package program.repository;

import org.springframework.data.repository.CrudRepository;
import program.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
