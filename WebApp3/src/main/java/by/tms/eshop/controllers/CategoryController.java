package by.tms.eshop.controllers;

import static by.tms.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.CATEGORY;

import by.tms.eshop.entities.Category;
import by.tms.eshop.services.CategoryService;
import java.util.List;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SessionAttributes(value = "category")
@RequestMapping("/category")
public class CategoryController {

  private CategoryService categoryService;

  public CategoryController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping()
  public ModelAndView getCategoryPage() throws Exception {
    ModelMap modelMap = new ModelMap();

    List<Category> categorySet = categoryService.read().stream().toList();
    modelMap.addAttribute(CATEGORY.getValue(), categorySet);

    return new ModelAndView(CATEGORY_PAGE.getPath(), modelMap);
  }
}
