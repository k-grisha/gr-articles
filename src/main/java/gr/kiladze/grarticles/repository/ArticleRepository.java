package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
