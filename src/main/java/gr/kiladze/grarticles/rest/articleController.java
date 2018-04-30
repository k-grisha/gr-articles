package gr.kiladze.grarticles.rest;

import gr.kiladze.grarticles.enity.Author;
import gr.kiladze.grarticles.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class articleController {



	@GetMapping("/save")
	public String save(){
//		authorService.save(new Author("ivan", 96));
		return "sdff";
	}

}
