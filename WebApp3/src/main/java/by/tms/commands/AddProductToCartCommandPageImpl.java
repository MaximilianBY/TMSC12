package by.tms.commands;

import static by.tms.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER_CART;
import static by.tms.utils.RequestParamsEnum.PRODUCT;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;

import by.tms.entities.Cart;
import by.tms.entities.Product;
import by.tms.entities.User;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.ProductServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddProductToCartCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(AddProductToCartCommandPageImpl.class);
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    int productID = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
    HttpSession session = request.getSession();
    User user = (User) session.getAttribute(CURRENT_USER.getValue());
    Cart cart = (Cart) session.getAttribute(CURRENT_USER_CART.getValue());
    if (Optional.ofNullable(user).isPresent() && Optional.ofNullable(cart).isPresent()) {
      cart.addProductToCart(productService.getProductByID(productID));
      log.info(
          "getting user from session: " + user.getLogin() + " " + "product ID added to user cart: "
              + productID);
      session.setAttribute(CURRENT_USER.getValue(), user);
      session.setAttribute(CURRENT_USER_CART.getValue(), cart);
    }
    Product product = productService.getProductByID(productID);
    request.setAttribute(PRODUCT.getValue(), product);
    return PRODUCT_PAGE.getPath();
  }
}
