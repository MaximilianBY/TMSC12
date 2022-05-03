package by.tms.model.user.servlet;

import static by.tms.model.registry.AccountData.checkUser;
import static by.tms.model.registry.AccountData.setUsersList;

import by.tms.DB_listener.DBConnectionManager;
import java.io.IOException;
import javax.servlet.ServletContext;
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
    getUsers();
    session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String chooseAction = req.getParameter("login-btn");
    switch (chooseAction) {
      case "Login":
        checkInputUser(req, resp);
        break;
      case "Register":
        HttpSession session = req.getSession();
        session.getServletContext().getRequestDispatcher("/registry.html").forward(req, resp);
        break;
    }
  }

  private void checkInputUser(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String username = req.getParameter("username");
    String pass = req.getParameter("password");
    if (!checkUser(username, pass)) {
      getUsers();
      session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
    } else {
      session.setAttribute("currentUser", username);
      resp.sendRedirect("/myPage");
    }
  }

  private void getUsers() {
    ServletContext ctx = getServletContext();
    setUsersList((DBConnectionManager) ctx.getAttribute(
        "DBManager"));
  }
}