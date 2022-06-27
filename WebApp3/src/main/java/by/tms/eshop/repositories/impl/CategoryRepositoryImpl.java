package by.tms.eshop.repositories.impl;

import static by.tms.eshop.repositories.Connection.closeConnection;

import by.tms.eshop.entities.Category;
import by.tms.eshop.repositories.CategoryRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {

  private static final String ADD_NEW_CATEGORY = "INSERT INTO eshop.category(name) VALUE (?)";
  private static final String ADD_NEW_IMAGE_PATH = "INSERT INTO eshop.images (category_id, image_path) VALUE (LAST_INSERT_ID(), ?)";
  private static final String GET_ALL_CATEGORY = "SELECT * FROM eshop.category JOIN eshop.images im ON category.id = im.category_id";
  private static final String UPDATE_CATEGORY = "UPDATE eshop.category JOIN images i on category.id = i.category_id SET name=?, image_path=? WHERE id=?";
  private static final String DELETE_CATEGORY = "DELETE FROM eshop.category WHERE id=?";
  private static final String GET_CATEGORY_BY_ID = "SELECT * FROM eshop.category JOIN eshop.images i on category.id = i.category_id WHERE category.id=?";

  @Override
  public Set<Category> create(Category category) throws Exception {
    Set<Category> categoryMap;
    Connection connection = pool.getConnection();

    try {
      PreparedStatement addCategory = connection.prepareStatement(ADD_NEW_CATEGORY);
      PreparedStatement addImage = connection.prepareStatement(ADD_NEW_IMAGE_PATH);

      addCategory.setString(1, category.getName());
      addImage.setString(1, category.getImagePath());

      addCategory.executeUpdate();
      addImage.executeUpdate();

      categoryMap = read();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeConnection(connection);
    }

    return categoryMap;
  }

  @Override
  public Set<Category> read() throws Exception {
    Set<Category> categoryMap = new HashSet<>();
    Connection connection = pool.getConnection();

    try {
      PreparedStatement getAllCategory = connection.prepareStatement(GET_ALL_CATEGORY);
      ResultSet rs = getAllCategory.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String imagePath = rs.getString("image_path");
        categoryMap.add(Category.builder()
            .id(id)
            .name(name)
            .imagePath(imagePath)
            .build());
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeConnection(connection);
    }
    return categoryMap;
  }

  @Override
  public Set<Category> update(Category category) throws Exception {
    Set<Category> categoryMap;
    Connection connection = pool.getConnection();

    try {
      PreparedStatement updateCategory = connection.prepareStatement(UPDATE_CATEGORY);

      updateCategory.setString(1, category.getName());
      updateCategory.setString(2, category.getImagePath());
      updateCategory.setInt(3, category.getId());

      updateCategory.executeUpdate();

      categoryMap = read();

    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeConnection(connection);
    }

    return categoryMap;
  }

  @Override
  public void delete(int id) throws Exception {
    Connection connection = pool.getConnection();
    try {
      PreparedStatement deleteCategory = connection.prepareStatement(DELETE_CATEGORY);

      deleteCategory.setInt(1, id);

      deleteCategory.execute();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeConnection(connection);
    }
  }

  @Override
  public Category findCategoryById(int id) throws Exception {
    Category category = null;
    Connection connection = pool.getConnection();

    try {
      PreparedStatement getCategory = connection.prepareStatement(GET_CATEGORY_BY_ID);
      getCategory.setInt(1, id);
      ResultSet rs = getCategory.executeQuery();

      while (rs.next()) {
        category = Category.builder()
            .id(rs.getInt("id"))
            .name(rs.getString("name"))
            .imagePath("image_path")
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } finally {
      closeConnection(connection);
    }
    return category;
  }
}
