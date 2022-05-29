package by.tms.commands;

import static by.tms.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.tms.utils.ProductList.getProductByID;
import static by.tms.utils.RequestParamsEnum.PRODUCT;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;

import by.tms.exceptions.CommandException;
import by.tms.model.Product;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProductPage implements BaseCommand {

  private static final Logger log = LogManager.getLogger(ProductPage.class);

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    int idProduct = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
    Product product = getProductByID(idProduct);
    if (Optional.ofNullable(product).isPresent()) {
      request.setAttribute(PRODUCT.getValue(), product);
    }
    log.info("taking product: " + product.getBrand() + " " + product.getModel());
    return PRODUCT_PAGE.getPath();
  }
}
