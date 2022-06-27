package by.tms.eshop.services;

import by.tms.eshop.entities.Product;
import java.util.Set;
import org.springframework.web.servlet.ModelAndView;

public interface ProductService extends BaseService<Product> {

  Set<Product> getAllProductsByCategory(int categoryID) throws Exception;

  Product getProductByID(int productID) throws Exception;

  Set<Product> findProductByRequestFromSearch(String[] searchArray) throws Exception;

  ModelAndView getProductData(int id) throws Exception;
}
