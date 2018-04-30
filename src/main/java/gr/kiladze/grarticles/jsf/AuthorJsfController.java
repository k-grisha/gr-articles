package gr.kiladze.grarticles.jsf;

import com.google.common.collect.Lists;
import gr.kiladze.grarticles.enity.AbstractModel;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

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

	//todo Optimize need
	public Iterable<Author> getAuthors() {
		return authorService.getAll();
	}

	public Map<String, Long> getMappedAuthors() {
		Map<String, Long> map = Lists.newArrayList(authorService.getAll()).stream()
				.collect(Collectors.toMap(Author::getName, AbstractModel::getId));
		return map;
	}


}
