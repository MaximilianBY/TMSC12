package by.tms.model.categories.servlet;

import by.tms.DB_listener.DBConnectionManager;
import by.tms.model.basket.ProductList;
import by.tms.model.categories.Category;
import by.tms.model.product.Product;
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

@WebServlet("/devices")
public class ServletCategories extends HttpServlet {

  private static String GET_ALL_PRODUCT =
      "SELECT * FROM online_shop_pc.product_db JOIN online_shop_pc.product_image_db scd on product_db.id = scd.id ";

  @Override
  protected void doGet(
      HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    checkReceivedUser(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    checkReceivedUser(req, resp);
  }

  private void checkReceivedUser(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    List<Category> categories = new ArrayList<>();

    Category mobilePhones = new Category("Mobile phones", "mobile.jpg", "mobPhones");
    Category laptops = new Category("Laptops", "laptop.jpg", "laptops.html");
    Category jpsNavigators = new Category("GPS Navigators", "jps_nav.jpg", "gpsNavigators.html");
    Category fridges = new Category("Fridges", "fridge.jpg", "fridges.html");
    Category car = new Category("Cars", "car.jpg", "cars.html");
    Category camera = new Category("Cameras", "camera.jpg", "cameras.html");

    categories.add(mobilePhones);
    categories.add(laptops);
    categories.add(jpsNavigators);
    categories.add(fridges);
    categories.add(car);
    categories.add(camera);

    req.setAttribute("categories", categories);
    getProductsFromDB();

    req.getServletContext().getRequestDispatcher("/devices.jsp").forward(req, resp);
  }

  private void getProductsFromDB() {
    ServletContext ctx = getServletContext();
    List<Product> products = new ArrayList<>();
    try {
      DBConnectionManager dbConnectionManager = (DBConnectionManager) ctx.getAttribute("DBManager");
      Connection connection = dbConnectionManager.getConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCT);
      ResultSet rs = preparedStatement.executeQuery();

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
      ProductList.addProductToListFromDB(products);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }
}
