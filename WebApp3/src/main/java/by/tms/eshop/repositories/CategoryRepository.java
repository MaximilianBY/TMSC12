package by.tms.eshop.repositories;

import by.tms.eshop.entities.Category;

public interface CategoryRepository extends BaseRepository<Category> {

  Category findCategoryById(int id) throws Exception;
}
