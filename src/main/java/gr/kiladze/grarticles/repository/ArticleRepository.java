package gr.kiladze.grarticles.repository;

import gr.kiladze.grarticles.enity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
//public interface ArticleRepository extends PagingAndSortingRepository<Article, Long>, QueryDslPredicateExecutor<Article> {

}
