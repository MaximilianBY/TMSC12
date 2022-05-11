package by.tms.model.user.servlet;

import static by.tms.model.user.AccountData.addUserToList;
import static by.tms.model.user.AccountData.isExistUser;

import by.tms.model.user.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/registration")
public class ServletRegistration extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    session.getServletContext().getRequestDispatcher("/registration.html").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    getNewUserData(req, resp);
  }

  private void getNewUserData(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    HttpSession session = req.getSession();
    String userName = req.getParameter("username");
    String pass = req.getParameter("password");
    String confPass = req.getParameter("confirm_password");
    String email = req.getParameter("email");
    String phoneNumber = req.getParameter("phoneNumber");
    if (pass.equals(confPass)) {
      User user = new User(userName, pass, email, phoneNumber);
      if (!isExistUser(user)) {
        addUserToList(user);
      }
    }
    session.getServletContext().getRequestDispatcher("/registration.html").forward(req, resp);
  }
}