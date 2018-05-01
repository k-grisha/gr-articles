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

/**
 * Category Controller for JSF page
 */
@Component
public class CategoryJsfController {

	@Autowired
	private CategoryService categoryService;
	private Category category = new Category();

	/**
	 * Save current category with Name validation
	 *
	 * @return path to list or #
	 */
	public String save() {
		if (categoryService.findByName(category.getName()) != null) {
			// show popup error message
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

	/**
	 * Get Map of Categories for <h:selectOneMenu>
	 *
	 * @return map of label-value pairs where label is Category name and value is Author ID
	 */
	public Map<String, Long> getMappedCategories() {
		return categoryService.getAll().stream()
				.collect(Collectors.toMap(Category::getName, AbstractModel::getId));
	}

	//todo Optimization need
	public Iterable<Category> getCategories() {
		return categoryService.getAll();
	}

}
