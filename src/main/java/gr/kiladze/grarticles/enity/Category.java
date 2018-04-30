package gr.kiladze.grarticles.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends AbstractModel {
	@Column(unique = true)
	private String name;
	private String description;
}
