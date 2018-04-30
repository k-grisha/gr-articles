package gr.kiladze.grarticles.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article extends AbstractModel {

	private String title;
	private String summary;
	@Lob
	private String content;
	// PERSIST for save cascade but remove separated
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "AUTHOR_ID", nullable = false)
	private Author author;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	private Category category;
	private Boolean published;
	private Date date;

}
