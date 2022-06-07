package by.tms.commands;

import static by.tms.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;
import static by.tms.utils.RequestParamsEnum.PRODUCT;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;

import by.tms.entities.Product;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.CategoryServiceImpl;
import by.tms.services.impl.ProductServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(ProductCommandPageImpl.class);
  private CategoryServiceImpl categoryService = new CategoryServiceImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    int idProduct = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
    Product product = productService.getProductByID(idProduct);
    if (Optional.ofNullable(product).isPresent()) {
      request.setAttribute(PRODUCT.getValue(), product);
    }
    request.setAttribute(CATEGORY.getValue(), categoryService.getAllCategories());
    log.info("taking product: " + product.getBrand() + " " + product.getModel());
    return PRODUCT_PAGE.getPath();
  }
}
