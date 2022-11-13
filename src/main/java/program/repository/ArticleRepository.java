package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

}
