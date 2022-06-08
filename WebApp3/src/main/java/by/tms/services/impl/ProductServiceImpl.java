package by.tms.services.impl;

import by.tms.entities.Product;
import by.tms.repositories.impl.ProductRepositoryImpl;
import by.tms.services.ProductService;
import java.util.Map;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

  private ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

  @Override
  public void create(Product entity) {
    productRepository.create(entity);
  }

  @Override
  public Map<Integer, Product> read() {
    return productRepository.read();
  }

  @Override
  public Product update(Product entity) {
    return productRepository.update(entity).get(entity.getId());
  }

  @Override
  public void delete(int id) {
    productRepository.delete(id);
  }

  @Override
  public Map<Integer, Product> getAllProductsByCategory(int categoryID) {
    Optional<Map<Integer, Product>> products = Optional.ofNullable(
        productRepository.getAllProductsByCategory(categoryID));
    return products.orElse(null);
  }

  @Override
  public Product getProductByID(int productID) {
    Optional<Product> product = Optional.ofNullable(productRepository.getProductByID(productID));
    return product.orElse(null);
  }

  @Override
  public Map<Integer, Product> findProductByRequestFromSearch(String[] searchArray) {
    Optional<Map<Integer, Product>> products = Optional.ofNullable(
        productRepository.findProductByRequestFromSearch(searchArray));
    return products.orElse(null);
  }
}
