package by.tms.servlet_login;

import by.tms.DBUtils.DBUtils;
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

    String username = req.getParameter("user");
    String pass = req.getParameter("pass");

    if (!DBUtils.getDbUserName().equals(username) || !DBUtils.getDbPassword().equals(pass)) {
      resp.sendRedirect("/login.html");
    } else {
      req.getServletContext().getRequestDispatcher("/studentsDB.html").forward(req, resp);
    }
  }
}
