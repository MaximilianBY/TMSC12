package by.tms.eshop.services.impl;


import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.dto.converters.ProductConverter;
import by.tms.eshop.repositories.ProductDao;
import by.tms.eshop.services.ProductService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

  private final ProductDao productDao;
  private final ProductConverter productConverter;

  public ProductServiceImpl(ProductDao productDao, ProductConverter productConverter) {
    this.productDao = productDao;
    this.productConverter = productConverter;
  }

  @Override
  public Set<ProductDto> getAllProductsByCategory(int categoryID) throws Exception {
    Optional<Set<ProductDto>> products = Optional.ofNullable(
        productDao.getProductsByCategory(categoryID));
    return products.orElse(null);
  }

  @Override
  public ProductDto getProductByID(int productID) throws Exception {
    Optional<ProductDto> product = Optional.ofNullable(productDao.getProductById(productID));
    return product.orElse(null);
  }

  @Override
  public Set<ProductDto> findProductByRequestFromSearch(String[] searchArray) throws Exception {
    Optional<Set<ProductDto>> products = Optional.ofNullable(
        productDao.searchProducts(searchArray));
    return products.orElse(null);
  }

  @Override
  public void updateProductQuantity(ProductDto product) {
    productDao.updateProductQuantity(product);
  }

  @Override
  public ResponseEntity<Set<ProductDto>> openDevicesPage(int categoryId) {
    Set<ProductDto> products = productDao.getProductsByCategory(categoryId);
    if (Optional.ofNullable(products).isPresent()) {
      return new ResponseEntity<>(products, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseEntity<ProductDto> getProductData(int id) throws Exception {
    ProductDto product = productDao.getProductById(id);
    if (Optional.ofNullable(product).isPresent()) {
      return new ResponseEntity<>(product, HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @Override
  public ResponseEntity<Set<ProductDto>> findProductsFromRequest(String inputString)
      throws Exception {
    if (Optional.ofNullable(inputString).isPresent()) {
      String[] searchArr = inputString.split("\\W");
      Set<ProductDto> products = productDao.searchProducts(searchArr);
      if (Optional.ofNullable(products).isPresent()) {
        return new ResponseEntity<>(products, HttpStatus.OK);
      }
    }
    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
  }

  @Override
  public Set<ProductDto> getAllProducts() {
    return productDao.getAllProducts();
  }

  @Override
  public ResponseEntity<Set<ProductDto>> saveProductsFromFile(MultipartFile file) throws Exception {
    List<ProductDto> csvProducts = parseCsv(file);
    if (Optional.ofNullable(csvProducts).isPresent()) {
      return new ResponseEntity<>(new HashSet<>(csvProducts), HttpStatus.CREATED);
    }
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }

  private List<ProductDto> parseCsv(MultipartFile file) {
    if (Optional.ofNullable(file).isPresent()) {
      try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
        CsvToBean<ProductDto> csvToBean = new CsvToBeanBuilder(reader)
            .withType(ProductDto.class)
            .withIgnoreLeadingWhiteSpace(true)
            .withSeparator(',')
            .build();
        return csvToBean.parse();
      } catch (Exception ex) {
        log.error("Exception occurred during CSV parsing: {}", ex.getMessage());
      }
    } else {
      log.error("Empty CSV file is uploaded.");
    }
    return Collections.emptyList();
  }

  @Override
  public ResponseEntity<Set<ProductDto>> downloadProductsCSV(PrintWriter printWriter)
      throws Exception {
    Set<ProductDto> allProducts = productDao.getAllProducts();
    String[] CSV_HEADER = {"brand", "model", "description", "price", "quantity", "categoryName",
        "imagePath"};
    StatefulBeanToCsv<ProductDto> beanToCsv = null;

    try (CSVWriter writer = new CSVWriter(printWriter,
        CSVWriter.DEFAULT_SEPARATOR,
        CSVWriter.NO_QUOTE_CHARACTER,
        CSVWriter.NO_ESCAPE_CHARACTER,
        CSVWriter.DEFAULT_LINE_END)) {

      writer.writeNext(CSV_HEADER);

      ColumnPositionMappingStrategy<ProductDto> mappingStrategy =
          new ColumnPositionMappingStrategy<ProductDto>();

      mappingStrategy.setType(ProductDto.class);
      mappingStrategy.setColumnMapping(CSV_HEADER);

      beanToCsv = new StatefulBeanToCsvBuilder<ProductDto>(writer)
          .withMappingStrategy(mappingStrategy)
          .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
          .build();

      beanToCsv.write(allProducts.stream().toList());
      return new ResponseEntity<>(allProducts, HttpStatus.OK);
    } catch (Exception e) {
      log.info("Error writing product CSV");
    }
    return new ResponseEntity<>(HttpStatus.FORBIDDEN);
  }
}
