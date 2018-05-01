package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.AbstractModel;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Authors Controller for JSF page
 */
@Component
public class AuthorJsfController {
	@Autowired
	private AuthorService authorService;
	private Author author = new Author();

	public String save() {
		authorService.save(author);
		author = new Author();
		return "list.xhtml";
	}

	public void delete(Long id) {
		authorService.delete(id);
	}

	public String edit(Long id) {
		author = authorService.findById(id);
		return "form.xhtml";
	}

	public Author getAuthor() {
		return author;
	}

	/**
	 * Get Map of Authors for <h:selectOneMenu>
	 * @return map of label-value pairs where label is Author name and value is Author ID
	 */
	public Map<String, Long> getMappedAuthors() {
		return authorService.getAll().stream()
				.collect(Collectors.toMap(Author::getName, AbstractModel::getId));
	}

	//todo Optimize need
	public Iterable<Author> getAuthors() {
		return authorService.getAll();
	}

}
