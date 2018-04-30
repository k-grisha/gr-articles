package gr.kiladze.grarticles.enity;

import javax.persistence.*;

public class AbstractModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Version
	@Column(nullable = false)
	private Long version;
}
