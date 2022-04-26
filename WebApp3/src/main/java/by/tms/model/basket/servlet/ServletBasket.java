package by.tms.model.basket.servlet;

import by.tms.model.basket.ProductList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    String chooseAction = req.getParameter("basket-btn");
    if (chooseAction.equals("Reset")) {
      ProductList.clearBasketList();
    }
    getProductList(req, resp);
  }

  private void getProductList(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("products", ProductList.getProductListFromBasket());
    req.getServletContext().getRequestDispatcher("/basket.jsp").forward(req, resp);
  }
}
