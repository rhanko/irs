package program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import program.model.Article;
import program.model.User;
import program.service.ArticleService;
import program.service.CategoryService;
import program.service.UserService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @GetMapping({"/home", "/", ""})
    public String articles(Model model) {
        List<Article> articles = articleService.findAllArticles();
        model.addAttribute("articles", articles);
        return "index.html";
    }

    @GetMapping("/article/add")
    public String articleupdate(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userService.findUserByNickname(((UserDetails) principal).getUsername());
        model.addAttribute("userlogged", user);

        Article article = new Article();
        article.setUser(user);

        model.addAttribute("article", article);
        return "articles/article";
    }

    @PostMapping("/article/save")
    public String articlesave(@Valid @ModelAttribute("article") Article article, Model model, BindingResult result) {

        if(result.hasErrors()) {
            model.addAttribute("article", article);
            return "articles/article";
        }

        return "redirect:/articles";
    }
}