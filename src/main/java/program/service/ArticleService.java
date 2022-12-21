package program.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import program.model.Article;
import program.repository.ArticleRepository;

import java.util.List;

/**
 * Trieda pre prácu s tabuľkou "Article" v databáze
 */
@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> findAllArticles() {
        return articleRepository.findAll();
    }

}
