package gr.kiladze.grarticles.service;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	@Transactional
	public void save(Article article) {
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
	public Article findById(Long id){
		return articleRepository.findOne(id);
	}
}
