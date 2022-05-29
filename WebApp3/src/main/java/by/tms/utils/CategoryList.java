package by.tms.utils;

import by.tms.db_utils.CRUDCategory;
import by.tms.model.Category;
import java.util.List;
import java.util.Map;

public class CategoryList {

  private static Map<Integer, Category> categoryList;

  private CategoryList() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static List<Category> getCategoryList() {
    categoryList = CRUDCategory.getCategoryFromDB();
    return categoryList.values().stream().toList();
  }
}
