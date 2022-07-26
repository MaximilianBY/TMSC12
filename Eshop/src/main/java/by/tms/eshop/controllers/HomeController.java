package by.tms.eshop.controllers;

import static by.tms.eshop.EshopConstants.CATEGORY_ID;

import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/category")
public class HomeController {

  private CategoryService categoryService;
  private ProductService productService;

  public HomeController(CategoryService categoryService, ProductService productService) {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @GetMapping()
  public ModelAndView openHomePage() throws Exception {
    return categoryService.openCategoryPage();
  }

  @GetMapping("/devices")
  public ModelAndView openDevicesPage(@RequestParam(CATEGORY_ID) String id) throws Exception {
    log.info("category id is: " + id);
    int categoryId = Integer.parseInt(id);
    return productService.openDevicesPage(categoryId);
  }
}
