package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleJsfController {
	@Autowired
	private ArticleService articleService;

	private Long authorId;
	private Article article = new Article();

	public String save() {
		articleService.save(article, authorId);
		article = new Article();
		return "article-list.xhtml";
	}

	public void delete(Long id) {
		articleService.delete(id);
	}

	public String edit(Long id) {
		article = articleService.findById(id);
		return "article-form.xhtml";
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

}
