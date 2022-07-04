package by.tms.eshop.repositories;

import by.tms.eshop.entities.Product;
import java.util.Set;

public interface ProductRepository extends BaseRepository<Product> {

  Set<Product> getAllProductsByCategory(int categoryID) throws Exception;

  Product getProductByID(int productID) throws Exception;

  Set<Product> findProductByRequestFromSearch(String[] searchArray) throws Exception;
}
