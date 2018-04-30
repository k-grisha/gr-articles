package gr.kiladze.grarticles.enity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gr_article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String summary;
	@Lob
	private String content;
	@OneToOne
	@JoinColumn(name = "main_info_id", nullable = false)
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
