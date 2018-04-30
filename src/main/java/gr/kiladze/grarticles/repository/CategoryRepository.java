package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
