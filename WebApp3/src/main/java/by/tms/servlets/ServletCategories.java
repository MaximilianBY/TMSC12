package by.tms.servlets;

import by.tms.model.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Devices")
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

    req.getServletContext().getRequestDispatcher("/Devices.jsp").forward(req, resp);
  }
}
