package by.tms.servlets;

import by.tms.model.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class ServletSignIn extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getRequestDispatcher("/signin.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    User user = new User();
    String username = req.getParameter("username");
    String pass = req.getParameter("password");

    if (!user.getName().equals(username) || !user.getPassword().equals(pass)) {
      req.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
    } else {
      resp.sendRedirect("/myPage");
    }
  }
}