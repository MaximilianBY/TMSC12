package by.tms.db_utils;

import static by.tms.db_utils.CRUDUser.getConnection;

import by.tms.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CRUDCategory {

  private static Connection connection = getConnection();

  private static final String GET_ALL_CATEGORY = "SELECT * FROM eshop.category JOIN eshop.images scd_img ON category.id = scd_img.category_id";

  private CRUDCategory() {
    throw new java.lang.UnsupportedOperationException(
        "This is a utility class and cannot be instantiated");
  }

  public static Map<Integer, Category> getCategoryFromDB() {
    Map<Integer, Category> categoryList = new HashMap<>();

    try {
      PreparedStatement getCategory = connection.prepareStatement(GET_ALL_CATEGORY);
      ResultSet rs = getCategory.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String imagePath = rs.getString("image_path");
        categoryList.put(id, new Category(id, name, imagePath));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return categoryList;
  }
}
