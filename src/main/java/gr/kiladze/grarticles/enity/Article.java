package gr.kiladze.grarticles.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gr_article")
public class Article extends AbstractModel {

	private String title;
	private String summary;
	@Lob
	private String content;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	private Author author;
	private Boolean published;
	private LocalDate localDate;


	public Article(String title, String summary, String content, Author author, Boolean published, LocalDate localDate) {
		this.title = title;
		this.summary = summary;
		this.content = content;
		this.author = author;
		this.published = published;
		this.localDate = localDate;
	}
}
