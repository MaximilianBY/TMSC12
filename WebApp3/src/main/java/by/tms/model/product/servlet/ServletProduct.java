package by.tms.model.product.servlet;

import static by.tms.model.basket.ProductList.getProductByID;
import static by.tms.model.registry.AccountData.addProductToUserBasket;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/product")
public class ServletProduct extends HttpServlet {

  private int idProduct;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    idProduct = Integer.parseInt(req.getParameter("id"));
    if (Optional.ofNullable(getProductByID(idProduct)).isPresent()) {
      req.setAttribute("product", getProductByID(idProduct));
    }
    session.getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = String.valueOf(session.getAttribute("currentUser"));
    if (Optional.ofNullable(userName).isPresent()) {
      addProductToUserBasket(userName, getProductByID(idProduct), 0, 0);
      req.setAttribute("product", getProductByID(idProduct));
    }
    session.getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
  }
}
