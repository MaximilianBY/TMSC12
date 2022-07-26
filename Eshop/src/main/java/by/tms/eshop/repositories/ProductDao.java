package by.tms.eshop.repositories;

import by.tms.eshop.entities.Product;
import java.util.Set;

public interface ProductDao {

  Set<Product> getAllProducts();

  Set<Product> getProductsByCategory(int categoryId);

  Product getProductById(int productId);

  Set<Product> searchProducts(String[] searchArray);

  void updateProductQuantity(Product product);
}
