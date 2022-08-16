package by.tms.eshop.repositories;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.entities.Category;
import java.util.Set;

public interface CategoryDao {

  Set<CategoryDto> getAllCategories();

  Category findById(int id);

  Category findByName(String name);

  Category createCategory(Category category);
}
