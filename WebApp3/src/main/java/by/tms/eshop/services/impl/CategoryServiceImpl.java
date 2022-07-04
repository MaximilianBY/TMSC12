package by.tms.eshop.services.impl;

import static by.tms.eshop.utils.PagesPathEnum.CATEGORY_PAGE;
import static by.tms.eshop.utils.PagesPathEnum.DEVICES_PAGE;
import static by.tms.eshop.utils.RequestParamsEnum.CATEGORY;
import static by.tms.eshop.utils.RequestParamsEnum.DEVICES;

import by.tms.eshop.entities.Category;
import by.tms.eshop.entities.Product;
import by.tms.eshop.repositories.impl.CategoryRepositoryImpl;
import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.ProductService;
import java.util.Optional;
import java.util.Set;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

@Service
public class CategoryServiceImpl implements CategoryService {

  private CategoryRepositoryImpl categoryRepository;
  private ProductService productService;

  public CategoryServiceImpl(CategoryRepositoryImpl categoryRepository,
      ProductService productService) {
    this.categoryRepository = categoryRepository;
    this.productService = productService;
  }

  @Override
  public void create(Category entity) throws Exception {
    categoryRepository.create(entity);
  }

  @Override
  public Set<Category> read() throws Exception {
    return categoryRepository.read();
  }

  @Override
  public Category update(Category entity) throws Exception {
    return categoryRepository.update(entity).stream()
        .filter(category -> category.getName().equals(entity.getName()))
        .findAny()
        .get();
  }

  @Override
  public void delete(int id) throws Exception {
    categoryRepository.delete(id);
  }

  @Override
  public ModelAndView getCategoryData(int id) throws Exception {
    ModelMap modelMap = new ModelMap();

    Category category = categoryRepository.findCategoryById(id);
    if (Optional.ofNullable(category).isPresent()) {
      Set<Product> products = productService.getAllProductsByCategory(category.getId());
      category.setProductSet(products);
      modelMap.addAttribute(DEVICES.getValue(), category.getProductSet());
    }
    return new ModelAndView(DEVICES_PAGE.getPath(), modelMap);
  }

  @Override
  public ModelAndView getCategories() throws Exception {
    ModelAndView modelAndView = new ModelAndView();
    ModelMap modelMap = new ModelMap();

    Set<Category> categorySet = categoryRepository.read();
    modelMap.addAttribute(CATEGORY.getValue(), categorySet);

    modelAndView.setViewName(CATEGORY_PAGE.getPath());

    modelAndView.addAllObjects(modelMap);

    return modelAndView;
  }
}
