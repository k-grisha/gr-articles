package gr.kiladze.grarticles.rest;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rest/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	@GetMapping
	public List<Article> get(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "sort", required = false) List<String> sort) {
		return articleService.findSortedPage(page, direction, sort);
	}

	@GetMapping(path = "/{id}")
	public Article get(@PathVariable Long id){
		return articleService.findById(id);
	}
}
