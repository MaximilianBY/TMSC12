package by.tms.model.categories.servlet;

import static by.tms.db_utils.CRUDProduct.getProductsFromDB;

import by.tms.model.categories.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/categories")
public class ServletCategories extends HttpServlet {


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
    HttpSession session = req.getSession();

    List<Category> categories = new ArrayList<>();

    Category mobilePhones = new Category("Mobile phones", "mobile.jpg", "Smartphone");
    Category laptops = new Category("Laptops", "laptop.jpg", "Laptop");
    Category jpsNavigators = new Category("GPS Navigators", "jps_nav.jpg", "GPS Navigator");
    Category fridges = new Category("Fridges", "fridge.jpg", "Fridge");
    Category car = new Category("Cars", "car.jpg", "Cars.html");
    Category camera = new Category("Cameras", "camera.jpg", "Camera");

    categories.add(mobilePhones);
    categories.add(laptops);
    categories.add(jpsNavigators);
    categories.add(fridges);
    categories.add(car);
    categories.add(camera);

    session.setAttribute("categories", categories);
    getProductsFromDB();

    session.getServletContext().getRequestDispatcher("/categories.jsp").forward(req, resp);
  }
}
