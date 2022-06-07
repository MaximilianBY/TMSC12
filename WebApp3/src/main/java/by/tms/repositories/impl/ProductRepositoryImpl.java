package by.tms.repositories.impl;

import by.tms.entities.Product;
import by.tms.repositories.ProductRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class ProductRepositoryImpl implements ProductRepository {

  private static final String GET_ALL_PRODUCT = "SELECT * FROM eshop.product JOIN images i on product.id = i.product_id";
  private static final String UPDATE_QUANTITY_PRODUCT = "UPDATE eshop.product SET quantity = quantity - ? WHERE id = ?";
  private static final String GET_PRODUCTS_BY_CATEGORY = "SELECT * FROM eshop.product JOIN images i on product.id = i.product_id WHERE product.category_id=?";
  private static final String GET_PRODUCT_BY_ID = "SELECT * FROM eshop.product JOIN images i on product.id = i.product_id WHERE id=?";

  @Override
  public Map<Integer, Product> create(Product entity) {
    return null;
  }

  @Override
  public Map<Integer, Product> read() {
    Map<Integer, Product> productMap = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getProduct = connection.prepareStatement(GET_ALL_PRODUCT);
      ResultSet rs = getProduct.executeQuery();

      while (rs.next()) {
        productMap.put(getProduct(rs).getId(), getProduct(rs));
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return productMap;
  }

  @Override
  public Map<Integer, Product> update(Product entity) {
    Map<Integer, Product> products = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement updateProduct = connection.prepareStatement(UPDATE_QUANTITY_PRODUCT);

      updateProduct.setInt(1, entity.getQuantity());
      updateProduct.setInt(2, entity.getId());

      updateProduct.executeUpdate();

      products = read();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return products;
  }

  @Override
  public void delete(int id) {

  }

  @Override
  public Map<Integer, Product> getAllProductsByCategory(int categoryID) {
    Map<Integer, Product> productMap = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getProducts = connection.prepareStatement(
          GET_PRODUCTS_BY_CATEGORY);
      getProducts.setInt(1, categoryID);
      ResultSet rs = getProducts.executeQuery();

      while (rs.next()) {
        productMap.put(getProduct(rs).getId(), getProduct(rs));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    return productMap;
  }

  @Override
  public Product getProductByID(int productID) {
    Product product = null;
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getProduct = connection.prepareStatement(GET_PRODUCT_BY_ID);
      getProduct.setInt(1, productID);
      ResultSet rs = getProduct.executeQuery();

      while (rs.next()) {
        product = getProduct(rs);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return product;
  }

  @Override
  public Map<Integer, Product> findProductByRequestFromSearch(String[] searchArray) {
    Map<Integer, Product> searchProduct = new HashMap<>();

    for (Product product : read().values()) {
      int count = 0;
      for (String request : searchArray) {
        if (product.getBrand().toLowerCase().contains(request.toLowerCase()) || product.getModel()
            .toLowerCase().contains(request.toLowerCase())) {
          count++;
        }
        if (count >= searchArray.length) {
          searchProduct.put(product.getId(), product);
        }
      }
    }
    return searchProduct;
  }

  @Override
  public Product getProduct(ResultSet resultSet) {
    Product product = null;
    try {
      int id = resultSet.getInt("id");
      String brand = resultSet.getString("brand");
      String model = resultSet.getString("model");
      String description = resultSet.getString("description");
      int price = resultSet.getInt("price");
      int quantity = resultSet.getInt("quantity");
      int category = resultSet.getInt("category_id");
      String imagePath = resultSet.getString("image_path");
      if (quantity > 0) {
        product = Product.builder()
            .id(id)
            .brand(brand)
            .model(model)
            .description(description)
            .price(price)
            .imagePath(imagePath)
            .quantity(quantity)
            .categoryID(category)
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return product;
  }
}