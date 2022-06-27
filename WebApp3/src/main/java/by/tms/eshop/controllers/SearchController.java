package by.tms.eshop.controllers;

import static by.tms.eshop.utils.PagesPathEnum.SEARCH_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.DEVICES;

import by.tms.eshop.services.ProductService;
import java.util.Optional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/search")
public class SearchController {

  private ProductService productService;

  public SearchController(ProductService productService) {
    this.productService = productService;
  }

  @GetMapping
  public ModelAndView getResultFromSearchRequest(@RequestParam("searchField") String searchField)
      throws Exception {
    ModelMap modelMap = new ModelMap();
    if (Optional.ofNullable(searchField).isPresent()) {
      String[] searchArr = searchField.split("\\W");
      modelMap.addAttribute(DEVICES.getValue(),
          productService.findProductByRequestFromSearch(searchArr));
    }
    return new ModelAndView(SEARCH_PAGE.getPath(), modelMap);
  }
}
