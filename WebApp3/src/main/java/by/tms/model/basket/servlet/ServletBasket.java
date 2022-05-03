package by.tms.model.basket.servlet;

import static by.tms.model.registry.AccountData.clearUserBasket;
import static by.tms.model.registry.AccountData.confirmOrder;
import static by.tms.model.registry.AccountData.getProductListFromUserBasket;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/basket")
public class ServletBasket extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getProductList(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    actionWithUserBasket(req, resp);
    getProductList(req, resp);
  }

  private void getProductList(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    session.setAttribute("products",
        getProductListFromUserBasket(userName));
    session.getServletContext().getRequestDispatcher("/basket.jsp").forward(req, resp);
  }

  private void actionWithUserBasket(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    String basketAction = req.getParameter("basket-btn");
    switch (basketAction) {
      case "Reset":
        if (Optional.ofNullable(userName).isPresent()) {
          clearUserBasket(userName);
        }
        break;
      case "Order":
        confirmOrder(userName, getProductListFromUserBasket(userName));
        break;
    }
  }
}
