package by.tms.servlet;

import by.tms.commands.BaseCommand;
import by.tms.utils.CommandFactory;
import by.tms.utils.PagesPathEnum;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet("/eshop")
public class ApplicationServlet extends HttpServlet {

  private static final Logger log = LogManager.getLogger(ApplicationServlet.class);

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

  private void processRequest(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    BaseCommand command = CommandFactory.defineCommand(req);

    String path;

    try {
      path = command.execute(req);
      RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
      requestDispatcher.forward(req, resp);
    } catch (Exception e) {
      log.info("some problem in request params: " + e.getMessage());
      req.getRequestDispatcher(PagesPathEnum.SIGN_IN_PAGE.getPath()).forward(req, resp);
    }
  }
}
