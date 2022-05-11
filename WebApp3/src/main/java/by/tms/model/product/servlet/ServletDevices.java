package by.tms.model.product.servlet;

import static by.tms.model.product.ProductList.addProductsListFromDB;
import static by.tms.model.product.ProductList.getProductListByType;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/devices")
public class ServletDevices extends HttpServlet {


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    addProductsListFromDB();
    getDevicesFromType(req, resp);
  }

  private void getDevicesFromType(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String type = req.getParameter("type");
    req.setAttribute("products", getProductListByType(type));
    session.getServletContext().getRequestDispatcher("/devices.jsp").forward(req, resp);
  }
}