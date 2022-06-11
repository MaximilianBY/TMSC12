package by.tms.repositories.impl;

import by.tms.entities.Category;
import by.tms.repositories.CategoryRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class CategoryRepositoryImpl implements CategoryRepository {

  private static final String ADD_NEW_CATEGORY = "INSERT INTO eshop.category(name) VALUE (?)";
  private static final String ADD_NEW_IMAGE_PATH = "INSERT INTO eshop.images (category_id, image_path) VALUE (LAST_INSERT_ID(), ?)";
  private static final String GET_ALL_CATEGORY = "SELECT * FROM eshop.category JOIN eshop.images scd_img ON category.id = scd_img.category_id";
  private static final String UPDATE_CATEGORY = "UPDATE eshop.category JOIN images i on category.id = i.category_id SET name=?, image_path=? WHERE id=?";
  private static final String DELETE_CATEGORY = "DELETE FROM eshop.category WHERE id=?";

  @Override
  public Map<Integer, Category> create(Category entity) {
    Map<Integer, Category> categoryMap;

    try (Connection connection = pool.getConnection()) {
      PreparedStatement addCategory = connection.prepareStatement(ADD_NEW_CATEGORY);
      PreparedStatement addImage = connection.prepareStatement(ADD_NEW_IMAGE_PATH);

      addCategory.setString(1, entity.getName());
      addImage.setString(1, entity.getImageName());

      addCategory.executeUpdate();
      addImage.executeUpdate();

      categoryMap = read();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return categoryMap;
  }

  @Override
  public Map<Integer, Category> read() {
    Map<Integer, Category> categoryMap = new HashMap<>();

    try (Connection connection = pool.getConnection()) {
      PreparedStatement getAllCategory = connection.prepareStatement(GET_ALL_CATEGORY);
      ResultSet rs = getAllCategory.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String imagePath = rs.getString("image_path");
        categoryMap.put(id, Category.builder()
            .id(id)
            .name(name)
            .imageName(imagePath)
            .build());
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return categoryMap;
  }

  @Override
  public Map<Integer, Category> update(Category entity) {
    Map<Integer, Category> categoryMap;

    try (Connection connection = pool.getConnection()) {
      PreparedStatement updateCategory = connection.prepareStatement(UPDATE_CATEGORY);

      updateCategory.setString(1, entity.getName());
      updateCategory.setString(2, entity.getImageName());
      updateCategory.setInt(3, entity.getId());

      updateCategory.executeUpdate();

      categoryMap = read();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return categoryMap;
  }

  @Override
  public void delete(int id) {
    try (Connection connection = pool.getConnection()) {
      PreparedStatement deleteCategory = connection.prepareStatement(DELETE_CATEGORY);

      deleteCategory.setInt(1, id);

      deleteCategory.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
