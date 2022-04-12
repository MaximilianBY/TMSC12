package by.tms.servlet_login;

import by.tms.user.User;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
    requestDispatcher.forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = new User();

    String username = req.getParameter("email");
    String pass = req.getParameter("pass");

    System.out.println("User: " + username);
    System.out.println("Password: " + pass);

    if (!user.getEmail().equals(username) || !user.getPassword().equals(pass)) {
      resp.sendRedirect("/login.html");
    } else {
      resp.getWriter().println(
          "Пользователь с Email: " + username + " и паролем: " + pass + " вошёл в систему!");
    }
  }
}
