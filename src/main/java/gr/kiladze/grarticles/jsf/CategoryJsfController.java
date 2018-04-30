package gr.kiladze.grarticles.jsf;

import com.google.common.collect.Lists;
import gr.kiladze.grarticles.enity.AbstractModel;
import gr.kiladze.grarticles.enity.Category;
import gr.kiladze.grarticles.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class CategoryJsfController {

	@Autowired
	private CategoryService categoryService;
	private Category category = new Category();

	public String save() {
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
		Map<String, Long> map = Lists.newArrayList(categoryService.getAll()).stream()
				.collect(Collectors.toMap(Category::getName, AbstractModel::getId));
		return map;
	}

//	public Map<String, Category> getMappedCategories() {
//		Map<String, Category> map = Lists.newArrayList(categoryService.getAll()).stream()
//				.collect(Collectors.toMap(Category::getName, a -> a));
//		return map;
//	}

}
