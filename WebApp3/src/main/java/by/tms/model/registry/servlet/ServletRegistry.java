package by.tms.model.registry.servlet;

import static by.tms.model.registry.AccountData.addUserToList;
import static by.tms.model.registry.AccountData.isExistUser;

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
    String chooseAction = req.getParameter("Registry-btn");
    switch (chooseAction) {
      case "Login":
        HttpSession session = req.getSession();
        session.getServletContext().getRequestDispatcher("/signin.html").forward(req, resp);
        break;
      case "Register":
        getNewUserData(req, resp);
        break;
    }
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
    session.getServletContext().getRequestDispatcher("/registry.html").forward(req, resp);
  }
}
