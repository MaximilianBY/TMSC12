package by.tms.servlet_student_update;

import by.tms.DBUtils.CRUDUtils;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletStudUpd extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getServletContext().getRequestDispatcher("/studUPD.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    int id = Integer.parseInt(req.getParameter("id"));
    String cityStudy = req.getParameter("cityStudy");
    int course = Integer.parseInt(req.getParameter("course"));
    CRUDUtils.updateStudent(id, course, cityStudy);
    req.getServletContext().getRequestDispatcher("/studUPD.jsp").forward(req, resp);
  }
}
