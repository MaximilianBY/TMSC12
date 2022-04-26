package by.tms.model.author.servlet;

import by.tms.model.author.Author;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myPage")
public class ServletMyPage extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getServletContext().getRequestDispatcher("/myPage.jsp").forward(req, resp);
  }

  protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setAttribute("actualDate", new Date());
    req.setAttribute("fullName", Author.getFirstName() + " " + Author.getLastName());
    req.setAttribute("age", Author.getAge());
    req.setAttribute("nationality", Author.getCitizenship());
    req.setAttribute("aboutMe", Author.getAboutMe());
    req.getServletContext().getRequestDispatcher("/myPage.jsp").forward(req, resp);
  }
}
