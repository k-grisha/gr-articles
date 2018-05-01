package gr.kiladze.grarticles.service;

import com.google.common.collect.Lists;
import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.repository.ArticleRepository;
import gr.kiladze.grarticles.repository.AuthorRepository;
import gr.kiladze.grarticles.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ArticleService {

	private static final int PAGE_SIZE = 5;

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private AuthorRepository authorRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Save article
	 *
	 * @param article    to save
	 * @param authorId   id of related author
	 * @param categoryId id of related category
	 */
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

	/**
	 * Get all articles
	 *
	 * @return List of articles
	 */
	@Transactional(readOnly = true)
	public List<Article> getAllArticles() {
		return Lists.newArrayList(articleRepository.findAll());
	}

	/**
	 * Delete by Id
	 */
	@Transactional
	public void delete(Long id) {
		articleRepository.delete(id);
	}

	/**
	 * Find only one article by id
	 *
	 * @param id of article to delete
	 * @return article
	 */
	@Transactional(readOnly = true)
	public Article findById(Long id) {
		return articleRepository.findOne(id);
	}

	/**
	 * Get Paginal Articles list.
	 * Size of page defined in {@link ArticleService#PAGE_SIZE}
	 *
	 * @param pageNumber page number start from 0
	 * @param direction  of sort
	 * @param sort       fields list for sorting
	 * @return list of Articles
	 */
	@Transactional(readOnly = true)
	public List<Article> findSortedPage(Integer pageNumber, Sort.Direction direction, List<String> sort) {
		PageRequest request;
		if (CollectionUtils.isEmpty(sort)) {
			request = new PageRequest(pageNumber, PAGE_SIZE);
		} else {
			request = new PageRequest(pageNumber, PAGE_SIZE, direction, sort.toArray(new String[sort.size()]));
		}
		Page<Article> page = articleRepository.findAll(request);
		return page.getContent();
	}
}
