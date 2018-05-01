package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
