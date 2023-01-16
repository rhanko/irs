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

    public Article getArticleById(int id) {
        return articleRepository.findArticleById(id);
    }

    public boolean existArticleById(int id) {
        return articleRepository.existsArticleById(id);
    }

    public void deleteArticleById(int id) {
        articleRepository.deleteById(id);
    }

    public boolean existArticleByTitle(String name) {
        return articleRepository.existsArticleByTitle(name);
    }

    public Article getArticleByTitle(String name) {
        return articleRepository.findArticleByTitle(name);
    }
}
