package gr.kiladze.grarticles.service;

import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;

	@Transactional
	public void save(Author author) {
		authorRepository.save(author);
	}

	@Transactional(readOnly = true)
	public Iterable<Author> getAll() {
		return authorRepository.findAll();
	}

	@Transactional
	public void delete(Long id) {
		authorRepository.delete(id);
	}

	@Transactional(readOnly = true)
	public Author findById(Long id) {
		return authorRepository.findOne(id);
	}
}
