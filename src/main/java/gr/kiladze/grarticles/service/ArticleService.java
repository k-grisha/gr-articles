package gr.kiladze.grarticles.service;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.repository.ArticleRepository;
import gr.kiladze.grarticles.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@Transactional
	public void save(Article article) {
		articleRepository.save(article);
	}

	@Transactional
	public void save(Article article, Long authorId) {
		Author author = authorRepository.findOne(authorId);
		if (author == null) {
			throw new RuntimeException("Not found user with id=" + authorId);
		}
		article.setAuthor(author);
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

	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return articleRepository.findOne(id);
	}
}
