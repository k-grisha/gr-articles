package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Article Controller for JSF page
 */
@Component
public class ArticleJsfController {
	@Autowired
	private ArticleService articleService;
	// current Article
	private Article article;
	// related author ID
	private Long authorId;
	// related category ID
	private Long categoryId;

	public ArticleJsfController() {
		article = new Article();
		article.setDate(new Date());
	}

	/**
	 * Save current Article and implement new one
	 *
	 * @return path to list of articles
	 */
	public String save() {
		articleService.save(article, authorId, categoryId);
		article = new Article();
		article.setDate(new Date());
		return "article-list.xhtml";
	}

	/**
	 * Delete article by Id
	 */
	public void delete(Long id) {
		articleService.delete(id);
	}

	/**
	 * Find Article by Id and set it as current for edit
	 *
	 * @param id edit article ID
	 * @return path to details form of article
	 */
	public String edit(Long id) {
		article = articleService.findById(id);
		categoryId = article.getCategory().getId();
		authorId = article.getAuthor().getId();
		return "article-form.xhtml";
	}

	//todo Optimization need
	public Iterable<Article> getArticles() {
		return articleService.getAllArticles();
	}

	//---- Getters and Setters ----//

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Article getArticle() {
		return article;
	}


}
