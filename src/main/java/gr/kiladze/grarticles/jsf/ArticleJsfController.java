package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleJsfController {
	@Autowired
	private ArticleService articleService;
	private Article article = new Article();

	public String save() {
		articleService.save(article);
		article = new Article();
		return "article-list.xhtml";
	}

	public void delete(Long id) {
		articleService.delete(id);
	}

	public String edit(Long id){
		article = articleService.findById(id);
		return "article-form.xhtml";
	}

	public Article getArticle() {
		return article;
	}

	//todo Optimize need
	public Iterable<Article> getArticles() {
		return articleService.getAllArticles();
	}

}
