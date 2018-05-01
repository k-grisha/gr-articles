package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
