package gr.kiladze.grarticles.service;

import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Transactional(readOnly = true)
	public Iterable<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		categoryRepository.delete(id);
	}

	@Transactional(readOnly = true)
	public Category findById(Long id) {
		return categoryRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public Category findByName(String name) {
		return categoryRepository.findByName(name);
	}

}
