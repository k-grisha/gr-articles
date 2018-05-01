package gr.kiladze.grarticles.jsf;

import gr.kiladze.grarticles.enity.AbstractModel;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.service.CategoryService;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CategoryJsfController {

	@Autowired
	private CategoryService categoryService;
	private Category category = new Category();

	public String save() {
		if (categoryService.findByName(category.getName()) != null) {
			RequestContext.getCurrentInstance().showMessageInDialog(
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Category name must by unique",
							"Category \"" + category.getName() + "\" exist"));
			return "#";
		}

		categoryService.save(category);
		category = new Category();
		return "list.xhtml";
	}

	public void delete(Long id) {
		categoryService.delete(id);
	}

	public String edit(Long id) {
		category = categoryService.findById(id);
		return "form.xhtml";
	}


	public Category getCategory() {
		return category;
	}

	//todo Optimize need
	public Iterable<Category> getCategories() {
		return categoryService.getAll();
	}


	public Map<String, Long> getMappedCategories() {
		return categoryService.getAll().stream()
				.collect(Collectors.toMap(Category::getName, AbstractModel::getId));
	}

}
