package by.tms.servlets;

import by.tms.DB_listener.DBConnectionManager;
import by.tms.model.Product;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mobPhones")
public class ServletMobPhones extends HttpServlet {

  private static String GET_ALL_PRODUCT =
      "SELECT * FROM online_shop_pc.product_db JOIN online_shop_pc.product_image_db scd on product_db.id = scd.id "
          + "WHERE online_shop_pc.product_db.description = 'smartphone'";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getPhonesFromDB(req, resp);
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getPhonesFromDB(req, resp);
  }

  protected void getPhonesFromDB(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ServletContext ctx = getServletContext();
    try {
      DBConnectionManager dbConnectionManager = (DBConnectionManager) ctx.getAttribute("DBManager");
      Connection connection = dbConnectionManager.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
      ResultSet rs = preparedStatement.executeQuery();
      List<Product> products = new ArrayList<>();

      while (rs.next()) {
        int id = rs.getInt("id");
        String brand = rs.getString("brand");
        String model = rs.getString("model");
        String description = rs.getString("description");
        int price = rs.getInt("price");
        String imageName = rs.getString("name_image");
        int quantity = rs.getInt("quantity");
        products.add(new Product(id, brand, model, description, price, imageName, quantity));
      }
      req.setAttribute("products", products);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
    getServletContext().getRequestDispatcher("/mobPhones.jsp").forward(req, resp);
  }
}