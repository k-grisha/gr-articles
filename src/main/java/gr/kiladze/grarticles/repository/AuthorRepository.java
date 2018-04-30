package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
