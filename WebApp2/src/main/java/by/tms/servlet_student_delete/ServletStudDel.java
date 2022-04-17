package by.tms.servlet_student_delete;

import by.tms.DBUtils.CRUDUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletStudDel extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getServletContext().getRequestDispatcher("/studDEL.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    CRUDUtils.deleteStudent(id);
    req.getServletContext().getRequestDispatcher("/studDEL.jsp").forward(req, resp);
  }
}
