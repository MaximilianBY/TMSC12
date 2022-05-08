package by.tms.model.user.servlet;

import static by.tms.model.user.AccountData.isExistUser;
import static by.tms.model.user.AccountData.setUsersList;

import by.tms.db_listener_connector.DBConnectionManager;
import by.tms.model.user.User;
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
    getUsers();
    preLoadSignInPage(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    checkInputUser(req, resp);
  }

  private void checkInputUser(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String username = req.getParameter("username");
    String pass = req.getParameter("password");
    User user = new User(username, pass);
    if (!isExistUser(user)) {
      getUsers();
      preLoadSignInPage(req, resp);
    } else {
      session.setAttribute("currentUser", username);
      resp.sendRedirect("/myPage");
    }
  }

  public static void preLoadSignInPage(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
  }

  private void getUsers() {
    ServletContext ctx = getServletContext();
    setUsersList((DBConnectionManager) ctx.getAttribute(
        "DBManager"));
  }
}