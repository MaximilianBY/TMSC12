package by.tms.commands;

import static by.tms.utils.PagesPathEnum.PRODUCT_PAGE;
import static by.tms.utils.ProductList.getProductByID;
import static by.tms.utils.RequestParamsEnum.CURRENT_USER;
import static by.tms.utils.RequestParamsEnum.PRODUCT;
import static by.tms.utils.RequestParamsEnum.PRODUCT_ID;

import by.tms.exceptions.CommandException;
import by.tms.model.User;
import by.tms.utils.AccountData;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class AddProductToCart implements BaseCommand {

  private static final Logger log = LogManager.getLogger(AddProductToCart.class);

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    int productID = Integer.parseInt(request.getParameter(PRODUCT_ID.getValue()));
    request.setAttribute(PRODUCT.getValue(), getProductByID(productID));
    HttpSession session = request.getSession();
    int userID = (int) session.getAttribute(CURRENT_USER.getValue());
    User user = AccountData.getUser(userID);
    if (Optional.ofNullable(user).isPresent()) {
      user.getCart().addProductToCart(productID);
      log.info(
          "getting user from session: " + user.getLogin() + " " + "product ID added to user cart: "
              + productID);
    }
    return PRODUCT_PAGE.getPath();
  }
}
