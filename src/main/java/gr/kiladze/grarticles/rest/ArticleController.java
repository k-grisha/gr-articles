package gr.kiladze.grarticles.rest;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/rest/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@GetMapping("/")
	public List<Article> get() {
		return articleService.getAllArticles();
//		authorService.save(new Author("ivan", 96));
//		return "sdff";
	}

}
