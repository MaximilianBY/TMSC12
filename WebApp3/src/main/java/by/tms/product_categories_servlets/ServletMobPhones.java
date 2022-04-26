package by.tms.product_categories_servlets;

import by.tms.DB_listener.DBConnectionManager;
import by.tms.model.basket.ProductList;
import by.tms.model.product.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mobPhones")
public class ServletMobPhones extends HttpServlet {

  private static String GET_ALL_PRODUCT =
      "SELECT * FROM online_shop_pc.product_db JOIN online_shop_pc.product_image_db scd on product_db.id = scd.id WHERE product_db.description = 'smartphone'";
  private static String GET_PRODUCT =
      "SELECT * FROM online_shop_pc.product_db JOIN online_shop_pc.product_image_db scd on product_db.id = scd.id";

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getPhones(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int idProduct = Integer.parseInt(req.getParameter("idProduct"));
    System.out.println(idProduct);
    addProductToBasketList(idProduct);
    getPhones(req, resp);
  }

  protected void getPhones(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("products", ProductList.getProductListFromDB().stream()
        .filter(product -> product.getDescription().equals("smartphone")).toList());
    getServletContext().getRequestDispatcher("/mobPhones.jsp").forward(req, resp);
  }

  private void addProductToBasketList(int idProduct) {
    ServletContext ctx = getServletContext();
    try {
      DBConnectionManager dbConnectionManager = (DBConnectionManager) ctx.getAttribute(
          "DBManager");
      Connection connection = dbConnectionManager.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT);
      ResultSet rs = preparedStatement.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        if (id == idProduct) {
          String brand = rs.getString("brand");
          String model = rs.getString("model");
          String description = rs.getString("description");
          int price = rs.getInt("price");
          String imageName = rs.getString("name_image");
          int quantity = rs.getInt("quantity");
          ProductList.addProductToBasketList(
              new Product(id, brand, model, description, price, imageName, quantity));
        }
      }
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}