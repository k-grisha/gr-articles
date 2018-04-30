package gr.kiladze.grarticles.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author extends AbstractModel {
	private String name;
	private Integer age;
}
