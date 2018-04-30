package gr.kiladze.grarticles;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.repository.ArticleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDate;

@SpringBootApplication
@EnableTransactionManagement
public class GrArticlesApplication extends WebMvcConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrArticlesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrArticlesApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/author/author-list.xhtml");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}


	@Bean
	public CommandLineRunner demo(ArticleRepository repository) {
		return (args) -> {
			repository.save(new Article(
					"JSF Facelets",
					"When creating a web page template with JSF, a developer needs to know the difference between ui:insert and ui:include.",
					"In these tutorials on template based webpage development with JSF 2.x and Facelets, we've kept the basic layout page pretty simple. We have defined the various page elements with the ui:insert tag, and then within those tags, we've simply spit out a word like Heading or Footer or Messages, right there inside the layout.xhtml page itself. This is acceptable in a tutorial, but normally, each individual page element, be it the header, footer, right navigation pane and even the content window would normally go in a separate file. For example, anything to do with the footer should go in a file of its own, likely named footer.xhtml. Here is what the code would look like if we factored out the various page elements into their own files",
					new Author("Billi", 22),
					true,
					LocalDate.now()));
			repository.save(new Article(
					"Title",
					"Some summary",
					"Some content Some content Some content Some content Some content",
					new Author("Romeo", 33),
					false,
					LocalDate.now()));
			repository.save(new Article(
					"Title2",
					"summary-2",
					"content-2 content-2 content-2 content-2 ",
					new Author("Ivan", 44),
					true,
					LocalDate.now()));

//			repository.save(new Author("Billi", 22));
//			repository.save(new Author("Romeo", 33));
//			repository.save(new Author("Ivan", 44));

			// fetch all authors
			LOGGER.info("-------------------------------");
			LOGGER.info("Articles was added:");
			for (Article article : repository.findAll()) {
				LOGGER.info(article.getTitle());
			}
		};
	}

}
