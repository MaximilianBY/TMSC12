package by.tms.eshop.controllers;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Set;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@RequestMapping("/home")
public class HomeController {

  private CategoryService categoryService;
  private ProductService productService;

  public HomeController(CategoryService categoryService, ProductService productService) {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @GetMapping()
  public ModelAndView openHomePage(HttpSession httpSession) throws Exception {
    return categoryService.openCategoryPage(httpSession);
  }

  @Operation(
      summary = "Find all categories",
      description = "Find all existed categories in Eshop",
      tags = {"category"})
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "All categories were found",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Categories not fount - forbidden operation"
      )
  })
  @GetMapping("/all")
  public ResponseEntity<Set<CategoryDto>> getAllCategories() {
    return new ResponseEntity<>(categoryService.getAllCategoriesDto(), HttpStatus.OK);
  }

  @Operation(
      summary = "Find category by id",
      description = "Find category if exist by id in Eshop",
      tags = {"category"})
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Category founded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Category not fount - forbidden operation"
      )
  })
  @GetMapping("/devices/{id}")
  public ModelAndView openDevicesPage(@PathVariable String id) throws Exception {
    log.info("category id is: " + id);
    int categoryId = Integer.parseInt(id);
    return productService.openDevicesPage(categoryId);
  }


}
