package by.tms.model.registry.servlet;

import static by.tms.model.registry.AccountData.addUserToList;
import static by.tms.model.registry.AccountData.checkUser;

import by.tms.model.user.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registry")
public class ServletRegistry extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.getServletContext().getRequestDispatcher("/registry.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String userName = req.getParameter("username");
    String pass = req.getParameter("password");
    String saveBtn = req.getParameter("saveBtn");
    User user = new User(userName, pass);
    if (saveBtn.equals("saveUser") && !checkUser(user)) {
      addUserToList(user);
    }
    HttpSession session = req.getSession();
    session.getServletContext().getRequestDispatcher("/registry.html").forward(req, resp);
  }
}
