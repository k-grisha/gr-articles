package gr.kiladze.grarticles;

import gr.kiladze.grarticles.enity.Article;
import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.enity.Category;
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
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Date;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication
@EnableTransactionManagement
@EnableSwagger2
public class GrArticlesApplication extends WebMvcConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrArticlesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(GrArticlesApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("/article-list.xhtml");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		super.addViewControllers(registry);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select().apis(RequestHandlerSelectors.basePackage("gr.kiladze.grarticles.rest"))
				.build();
	}

	@Bean
	public CommandLineRunner demo(ArticleRepository repository) {
		return (args) -> {
			repository.save(new Article(
					"JSF Facelets",
					"When creating a web page template with JSF, a developer needs to know the difference between ui:insert and ui:include.",
					"In these tutorials on template based webpage development with JSF 2.x and Facelets, we've kept the basic layout page pretty simple. We have defined the various page elements with the ui:insert tag, and then within those tags, we've simply spit out a word like Heading or Footer or Messages, right there inside the layout.xhtml page itself. This is acceptable in a tutorial, but normally, each individual page element, be it the header, footer, right navigation pane and even the content window would normally go in a separate file. For example, anything to do with the footer should go in a file of its own, likely named footer.xhtml. Here is what the code would look like if we factored out the various page elements into their own files",
					new Author("Billi", 22),
					new Category("News", "World news"),
					true,
					new Date()));
			repository.save(new Article(
					"Title",
					"Some summary",
					"Some content Some content Some content Some content Some content",
					new Author("Romeo", 33),
					new Category("Cookie", "The Best Recipes"),
					false,
					new Date()));
			repository.save(new Article(
					"Title2",
					"summary-2",
					"content-2 content-2 content-2 content-2 ",
					new Author("Ivan", 44),
					new Category("Other", "Uncategorized articles"),
					true,
					new Date()));

			// fetch all authors
			LOGGER.info("-------------------------------");
			LOGGER.info("Articles was added:");
			for (Article article : repository.findAll()) {
				LOGGER.info(article.getTitle());
			}
		};
	}

}
