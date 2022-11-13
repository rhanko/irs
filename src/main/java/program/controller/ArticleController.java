package program.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {
/*
    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;

    @GetMapping("/index.html")
    private String read(Model model) {
        List<Article> articles = articleService.getAll();
        model.addAllAttributes(articles);
        return "article";
    }

    @GetMapping("/article/showed")
    private List<Article> getAllShowed() {
        return articleService.getAllShowed();
    }

    @GetMapping("/article/{id}")
    private Article getByID(@PathVariable("id") int id) {
        return articleService.getByID(id);
    }

    @DeleteMapping("/article/{id}")
    private void deleteByID(@PathVariable("id") int id) {
        articleService.delete(id);
    }

    @PostMapping("/articles")
    private int save(@RequestBody Article article) {
        articleService.createOrUpdate(article);
        return article.getId();
    }

    @PutMapping("/articles")
    private Article update(@RequestBody Article article) {
        articleService.createOrUpdate(article);
        return article;
    }
*/
}
