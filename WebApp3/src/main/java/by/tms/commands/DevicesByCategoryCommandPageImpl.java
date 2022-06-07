package by.tms.commands;

import static by.tms.utils.PagesPathEnum.DEVICES_PAGE;
import static by.tms.utils.RequestParamsEnum.CATEGORY;
import static by.tms.utils.RequestParamsEnum.CATEGORY_ID;
import static by.tms.utils.RequestParamsEnum.DEVICES;

import by.tms.exceptions.CommandException;
import by.tms.services.impl.CategoryServiceImpl;
import by.tms.services.impl.ProductServiceImpl;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DevicesByCategoryCommandPageImpl implements BaseCommand {

  private static final Logger log = LogManager.getLogger(DevicesByCategoryCommandPageImpl.class);
  private CategoryServiceImpl categoryService = new CategoryServiceImpl();
  private ProductServiceImpl productService = new ProductServiceImpl();

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    return getDevicesFromType(request);
  }

  private String getDevicesFromType(HttpServletRequest request) {
    int category_id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
    request.setAttribute(DEVICES.getValue(),
        productService.getAllProductsByCategory(category_id).values().stream().toList());
    request.setAttribute(CATEGORY.getValue(), categoryService.getAllCategories());
    log.info("taking category id: " + category_id);
    return DEVICES_PAGE.getPath();
  }
}