package by.tms.commands;

import static by.tms.utils.PagesPathEnum.HOME_PAGE;

import by.tms.exceptions.CommandException;
import by.tms.model.Author;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class AuthorPage implements BaseCommand {

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    return printAuthorInfo(request);
  }

  protected String printAuthorInfo(HttpServletRequest req) {
    req.setAttribute("actualDate", new Date());
    req.setAttribute("fullName", Author.getFirstName() + " " + Author.getLastName());
    req.setAttribute("age", Author.getAge());
    req.setAttribute("nationality", Author.getCitizenship());
    req.setAttribute("aboutMe", Author.getAboutMe());
    return HOME_PAGE.getPath();
  }
}
