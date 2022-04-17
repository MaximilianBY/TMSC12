package by.tms.servlet_show_db;

import by.tms.DBUtils.CRUDUtils;
import by.tms.student.Student;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletShowDB extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    processRequest(req, resp);
  }

  protected void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    ArrayList<Student> students = CRUDUtils.getAllStudents();
    req.setAttribute("students", students);
    getServletContext().getRequestDispatcher("/showDB.jsp").forward(req,
        resp);//база данных приходит пустая, вероятно надо заводить напрямую, проверить!!!
  }
}
