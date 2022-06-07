package by.tms.services.impl;

import by.tms.entities.BaseEntity;
import by.tms.entities.Category;
import by.tms.repositories.impl.CategoryRepositoryImpl;
import by.tms.services.CategoryService;
import java.util.List;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {

  private CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();

  @Override
  public void create(BaseEntity entity) {

  }

  @Override
  public Map<Integer, Category> read() {
    return categoryRepository.read();
  }

  @Override
  public BaseEntity update(BaseEntity entity) {
    return null;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public List<Category> getAllCategories() {
    return read().values().stream().toList();
  }
}
