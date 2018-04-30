package gr.kiladze.grarticles.service;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.repository.ArticleRepository;
import gr.kiladze.grarticles.repository.AuthorRepository;
import gr.kiladze.grarticles.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Transactional
	public void save(Article article) {
		articleRepository.save(article);
	}

	@Transactional
	public void save(Article article, Long authorId, Long categoryId) {
		Author author = authorRepository.findOne(authorId);
		if (author == null) {
			throw new RuntimeException("Not found user with id=" + authorId);
		}
		Category category = categoryRepository.findOne(categoryId);
		if (category == null) {
			throw new RuntimeException("Not found category with id=" + categoryId);
		}
		article.setAuthor(author);
		article.setCategory(category);
		articleRepository.save(article);
	}

	@Transactional(readOnly = true)
	public Iterable<Article> getAllArticles() {
		return articleRepository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		articleRepository.delete(id);
	}

	@Transactional
	public void updateStatus(Article article) {
		Article foundArticle = articleRepository.findOne(article.getId());
		foundArticle.setPublished(article.getPublished());
	}

	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return articleRepository.findOne(id);
	}
}
