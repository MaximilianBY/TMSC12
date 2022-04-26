package by.tms.model.user.servlet;

import static by.tms.model.registry.AccountData.checkUser;

import by.tms.model.user.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/signin")
public class ServletSignIn extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String username = req.getParameter("username");
    String pass = req.getParameter("password");
    User user = new User(username, pass);
    if (!checkUser(user)) {
      session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
    } else {
      resp.sendRedirect("/myPage");
    }
  }
}