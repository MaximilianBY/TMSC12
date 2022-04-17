package by.tms.servlet_student_add;

import by.tms.DBUtils.CRUDUtils;
import by.tms.student.Student;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletStudentAdd extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getServletContext().getRequestDispatcher("/studAdd.jsp").forward(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    String firstName = req.getParameter("firstName");
    String lastName = req.getParameter("lastName");
    String cityFrom = req.getParameter("cityFrom");
    String cityStudy = req.getParameter("cityStudy");
    int course = Integer.parseInt(req.getParameter("course"));
    CRUDUtils.saveStudent(new Student(firstName, lastName, cityFrom, cityStudy, course));
    req.getServletContext().getRequestDispatcher("/studAdd.jsp").forward(req, resp);
  }
}
