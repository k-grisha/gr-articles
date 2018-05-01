package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	Category findByName(String name);
}
