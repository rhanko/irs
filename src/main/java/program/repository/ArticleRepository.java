package program.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import program.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    Article findArticleById(int id);

    boolean existsArticleById(int id);

    Article findArticleByTitle(String name);

    boolean existsArticleByTitle(String name);
}
