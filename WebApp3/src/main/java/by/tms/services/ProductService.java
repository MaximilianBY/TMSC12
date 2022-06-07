package by.tms.services;

import by.tms.entities.Product;
import java.util.Map;

public interface ProductService extends BaseService<Product> {

  Map<Integer, Product> getAllProductsByCategory(int categoryID);

  Product getProductByID(int productID);

  Map<Integer, Product> findProductByRequestFromSearch(String[] searchArray);
}
