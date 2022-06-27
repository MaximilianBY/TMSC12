package by.tms.eshop.services.impl;

import static by.tms.eshop.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.PRODUCT;

import by.tms.eshop.entities.Product;
import by.tms.eshop.repositories.impl.ProductRepositoryImpl;
import by.tms.eshop.services.ProductService;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

  @Override
  public void create(Product entity) throws Exception {
    productRepository.create(entity);
  }

  @Override
  public Set<Product> read() throws Exception {
    return productRepository.read();
  }

  @Override
  public Product update(Product product) throws Exception {
    return productRepository.update(product).stream()
        .filter(product1 -> product1.getId() == product.getId())
        .findAny()
        .orElse(null);
  }

  @Override
  public void delete(int id) throws Exception {
    productRepository.delete(id);
  }

  @Override
  public Set<Product> getAllProductsByCategory(int categoryID) throws Exception {
    Optional<Set<Product>> products = Optional.ofNullable(
        productRepository.getAllProductsByCategory(categoryID));
    return products.orElse(null);
  }

  @Override
  public Product getProductByID(int productID) throws Exception {
    Optional<Product> product = Optional.ofNullable(productRepository.getProductByID(productID));
    return product.orElse(null);
  }

  @Override
  public Set<Product> findProductByRequestFromSearch(String[] searchArray) throws Exception {
    Optional<Set<Product>> products = Optional.ofNullable(
        productRepository.findProductByRequestFromSearch(searchArray));
    return products.orElse(null);
  }

  @Override
  public ModelAndView getProductData(int id) throws Exception {
    ModelMap modelMap = new ModelMap();
    Product product = productRepository.getProductByID(id);
    if (Optional.ofNullable(product).isPresent()) {
      modelMap.addAttribute(PRODUCT.getValue(), product);
    }
    return new ModelAndView(PRODUCT_PAGE.getPath(), modelMap);
  }
}
