package gr.kiladze.grarticles.enity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "gr_author")
public class Author extends AbstractModel {

	private String name;
	private Integer age;

	public Author(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
}
