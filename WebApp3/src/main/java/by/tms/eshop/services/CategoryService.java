package by.tms.eshop.services;

import by.tms.eshop.entities.Category;
import org.springframework.web.servlet.ModelAndView;

public interface CategoryService extends BaseService<Category> {

  ModelAndView getCategoryData(int id) throws Exception;
}
