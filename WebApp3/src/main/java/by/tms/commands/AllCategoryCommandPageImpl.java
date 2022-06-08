package by.tms.commands;

import static by.tms.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;

import by.tms.exceptions.CommandException;
import by.tms.services.impl.CategoryServiceImpl;
import javax.servlet.http.HttpServletRequest;

public class AllCategoryCommandPageImpl implements BaseCommand {

  private CategoryServiceImpl categoryService = new CategoryServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    request.setAttribute(CATEGORY.getValue(), categoryService.read().values().stream().toList());
    return CATEGORY_PAGE.getPath();
  }
}
