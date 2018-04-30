package gr.kiladze.grarticles.enity;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "gr_author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private Integer age;

	public Author(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
