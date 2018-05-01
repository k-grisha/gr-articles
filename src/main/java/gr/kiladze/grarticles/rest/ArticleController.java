package gr.kiladze.grarticles.rest;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST API point that a mobile app can use to retrieve the news article list
 * @see <a href="http://localhost:8080/swagger-ui.htm">http://localhost:8080/swagger-ui.htm</a>  for details
 */
@RestController
@RequestMapping(path = "/rest/article")
public class ArticleController {

	@Autowired
	ArticleService articleService;

	/**
	 * Get Paginal Articles list.
	 * Size of page defined in {@link ArticleService#PAGE_SIZE}
	 *
	 * @param page page number start from 0
	 * @param direction of sort
	 * @param sort fields list for sorting
	 * @return list of Articles
	 */
	@GetMapping
	public List<Article> get(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "direction", defaultValue = "ASC") Sort.Direction direction,
			@RequestParam(value = "sort", required = false) List<String> sort) {
		return articleService.findSortedPage(page, direction, sort);
	}

	/**
	 * Get Article
	 * @param id get article by ID
	 * @return Article
	 */
	@GetMapping(path = "/{id}")
	public Article get(@PathVariable Long id) {
		return articleService.findById(id);
	}
}
