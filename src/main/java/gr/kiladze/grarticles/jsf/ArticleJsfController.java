package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ArticleJsfController {
	@Autowired
	private ArticleService articleService;

	private Long authorId;
	private Long categoryId;
	private Article article;

	public ArticleJsfController(){
		article = new Article();
		article.setDate(new Date());
	}

	public String save() {
		articleService.save(article, authorId, categoryId);
		article = new Article();
		article.setDate(new Date());
		return "article-list.xhtml";
	}

	public void delete(Long id) {
		articleService.delete(id);
	}

	public String edit(Long id) {
		article = articleService.findById(id);
		categoryId = article.getCategory().getId();
		authorId = article.getAuthor().getId();
		return "article-form.xhtml";
	}

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

	//todo Optimize need
	public Iterable<Article> getArticles() {
		return articleService.getAllArticles();
	}

	public void updateStatus(Article article) {
		articleService.updateStatus(article);
	}

}
