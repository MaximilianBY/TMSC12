package by.tms.servlet_calculator;

import static by.tms.calc_model.CalculatorOperations.calculations;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletCalculator extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    int num1 = Integer.parseInt(req.getParameter("num1"));
    int num2 = Integer.parseInt(req.getParameter("num2"));
    String operator = req.getParameter("operator");
    int result = 0;
    resp.setContentType("text/html");
    PrintWriter printResult = resp.getWriter();
    try {
      printResult.println(
          "Результат операции: " + num1 + operator + num2 + " = " + calculations(num1, num2,
              operator));
    } finally {
      printResult.close();
    }
  }
}
