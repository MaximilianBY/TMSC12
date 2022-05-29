package by.tms.commands;

import static by.tms.utils.PagesPathEnum.DEVICES_PAGE;
import static by.tms.utils.ProductList.getProductListByCategory;
import static by.tms.utils.RequestParamsEnum.CATEGORY_ID;
import static by.tms.utils.RequestParamsEnum.DEVICES;

import by.tms.exceptions.CommandException;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DevicesByCategoryPage implements BaseCommand {

  private static final Logger log = LogManager.getLogger(DevicesByCategoryPage.class);

  @Override
  public String execute(HttpServletRequest request) throws CommandException {
    return getDevicesFromType(request);
  }

  private String getDevicesFromType(HttpServletRequest request) {
    int category_id = Integer.parseInt(request.getParameter(CATEGORY_ID.getValue()));
    request.setAttribute(DEVICES.getValue(), getProductListByCategory(category_id));
    log.info("taking category id: " + category_id);
    return DEVICES_PAGE.getPath();
  }
}