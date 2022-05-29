package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;

import by.tms.exceptions.CommandException;
import by.tms.utils.CategoryList;
import javax.servlet.http.HttpServletRequest;

public class AllCategoryPage implements BaseCommand {

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    request.setAttribute(CATEGORY.getValue(), CategoryList.getCategoryList());
    return CATEGORY_PAGE.getPath();
  }
}
