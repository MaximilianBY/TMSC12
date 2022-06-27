package by.tms.eshop.controllers;

import by.tms.eshop.services.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/devices")
public class DeviceController {

  private CategoryService categoryService;

  public DeviceController(CategoryService categoryService) {
    this.categoryService = categoryService;
  }

  @GetMapping("/{id}")
  public ModelAndView openCategoryPage(@PathVariable int id) throws Exception {
    return categoryService.getCategoryData(id);
  }
}
