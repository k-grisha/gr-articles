package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorJsfController {
	@Autowired
	private AuthorService authorService;
	private Author author = new Author();

	public String save() {
		authorService.save(author);
		author = new Author();
		return "author-list.xhtml";
	}

	public void delete(Long id) {
		authorService.delete(id);
	}

	public String edit(Long id){
		author = authorService.findById(id);
		return "author-form.xhtml";
	}

	public Author getAuthor() {
		return author;
	}

	//todo Optimize need
	public Iterable<Author> getAuthors() {
		return authorService.getAllAuthors();
	}

}
