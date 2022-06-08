package by.tms.commands;

import static by.tms.utils.PagesPathEnum.SEARCH_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;
import static by.tms.utils.RequestParamsEnum.DEVICES;

import by.tms.services.impl.CategoryServiceImpl;
import by.tms.services.impl.ProductServiceImpl;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchProductCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(SearchProductCommandPageImpl.class);
  private CategoryServiceImpl categoryService = new CategoryServiceImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public String execute(HttpServletRequest request) {
    String[] search = String.valueOf(request.getParameter("search")).split("\\W");
    if (Optional.ofNullable(search).isPresent()) {
      request.setAttribute(DEVICES.getValue(),
          productService.findProductByRequestFromSearch(search).values().stream().toList());
    }
    request.setAttribute(CATEGORY.getValue(), categoryService.read().values().stream().toList());
    log.info("log search class");
    return SEARCH_PAGE.getPath();
  }
}
