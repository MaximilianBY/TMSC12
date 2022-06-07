package by.tms.commands;

import static by.tms.utils.PagesPathEnum.HOME_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;

import by.tms.entities.Author;
import by.tms.exceptions.CommandException;
import by.tms.services.impl.CategoryServiceImpl;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

public class AuthorCommandPageImpl implements BaseCommand {

  private CategoryServiceImpl categoryService = new CategoryServiceImpl();

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
    req.setAttribute(CATEGORY.getValue(), categoryService.getAllCategories());
    return HOME_PAGE.getPath();
  }
}
