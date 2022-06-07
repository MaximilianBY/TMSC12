package by.tms.repositories;

import by.tms.entities.Product;
import java.sql.ResultSet;
import java.util.Map;

public interface ProductRepository extends BaseRepository<Product> {

  Map<Integer, Product> getAllProductsByCategory(int categoryID);

  Product getProductByID(int productID);

  Map<Integer, Product> findProductByRequestFromSearch(String[] searchArray);

  Product getProduct(ResultSet resultSet);
}
