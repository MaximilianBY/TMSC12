package by.tms.services;

import by.tms.entities.Category;
import java.util.List;

public interface CategoryService extends BaseService {

  List<Category> getAllCategories();
}
