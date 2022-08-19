package by.tms.eshop.services;

import by.tms.eshop.dto.ProductDto;
import java.io.PrintWriter;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

  Set<ProductDto> getAllProductsByCategory(int categoryID) throws Exception;

  ProductDto getProductByID(int productID) throws Exception;

  Set<ProductDto> findProductByRequestFromSearch(String[] searchArray) throws Exception;

  void updateProductQuantity(ProductDto product);

  ResponseEntity<ProductDto> getProductData(int id) throws Exception;

  ResponseEntity<Set<ProductDto>> findProductsFromRequest(String inputString) throws Exception;

  ResponseEntity<Set<ProductDto>> openDevicesPage(int categoryId);

  Set<ProductDto> getAllProducts();

  ResponseEntity<Set<ProductDto>> saveProductsFromFile(MultipartFile file) throws Exception;

  ResponseEntity<Set<ProductDto>> downloadProductsCSV(PrintWriter printWriter) throws Exception;
}
