package by.tms.services.impl;

import by.tms.entities.Category;
import by.tms.repositories.impl.CategoryRepositoryImpl;
import by.tms.services.CategoryService;
import java.util.Map;

public class CategoryServiceImpl implements CategoryService {

  private CategoryRepositoryImpl categoryRepository = new CategoryRepositoryImpl();

  @Override
  public void create(Category entity) {
    categoryRepository.create(entity);
  }

  @Override
  public Map<Integer, Category> read() {
    return categoryRepository.read();
  }

  @Override
  public Category update(Category entity) {
    categoryRepository.update(entity);
    return read().values().stream()
        .filter(category -> category.getName().equals(entity.getName()))
        .findAny()
        .get();
  }

  @Override
  public void delete(int id) {
    categoryRepository.delete(id);
  }
}
