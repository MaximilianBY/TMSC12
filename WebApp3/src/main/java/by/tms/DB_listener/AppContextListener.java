package by.tms.DB_listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AppContextListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContext ctx = servletContextEvent.getServletContext();

    String url = ctx.getInitParameter("DBURL");
    String login = ctx.getInitParameter("DBUSER");
    String password = ctx.getInitParameter("DBPWD");

    DBConnectionManager dbManager = new DBConnectionManager(url, login, password);
    ctx.setAttribute("DBManager", dbManager);
    System.out.println("Database connection initialized for application.");

  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    ServletContext ctx = servletContextEvent.getServletContext();
    DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute("DBManager");
    dbManager.closeConnection();
    System.out.println("Database connection closed for application.");
  }
}
