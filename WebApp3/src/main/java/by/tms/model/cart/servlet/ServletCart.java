package by.tms.model.cart.servlet;

import static by.tms.model.cart.Cart.clearUserCart;
import static by.tms.model.cart.Cart.confirmOrder;
import static by.tms.model.cart.Cart.getProductListFromUserCart;

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
    getProductList(req, resp);
  }

  private void getProductList(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    session.setAttribute("products",
        getProductListFromUserCart(userName));
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
          break;
        case "Order":
          confirmOrder(userName, getProductListFromUserCart(userName));
          break;
      }
    }
  }

  private void delProduct(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    int idProductCart = Integer.parseInt(req.getParameter("del-product"));
    clearUserCart(userName, idProductCart);
  }
}
