package by.tms.model.cart.servlet;

import static by.tms.model.cart.Cart.clearUserCart;
import static by.tms.model.cart.Cart.confirmOrder;
import static by.tms.model.cart.Cart.getProductListFromUserCart;

import by.tms.model.product.Product;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cart")
public class ServletCart extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getProductList(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    actionWithUserCart(req, resp);
    delProduct(req, resp);
  }

  private void getProductList(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    session.setAttribute("products",
        getProductListFromUserCart(userName).values().stream().toList());
    int totalPrice = getProductListFromUserCart(userName).values().stream()
        .mapToInt(Product::getPrice).sum();
    session.setAttribute("totalprice", totalPrice);
    session.getServletContext().getRequestDispatcher("/cart.jsp").forward(req, resp);
  }

  private void actionWithUserCart(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    String orderAction = req.getParameter("cart-btn");
    if (Optional.ofNullable(orderAction).isPresent()) {
      switch (orderAction) {
        case "Reset":
          if (Optional.ofNullable(userName).isPresent()) {
            clearUserCart(userName, 0);
          }
          getProductList(req, resp);
          break;
        case "Order":
          confirmOrder(userName, getProductListFromUserCart(userName).values().stream().toList());
          getProductList(req, resp);
          break;
      }
    }
  }

  private void delProduct(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    Optional<Integer> idProductCart = Optional.of(
        Integer.parseInt(req.getParameter("del-product")));
//    int idProductCart = Integer.parseInt(req.getParameter("del-product"));
    idProductCart.ifPresent(idProduct -> clearUserCart(userName, idProduct));
    getProductList(req, resp);
  }
}
