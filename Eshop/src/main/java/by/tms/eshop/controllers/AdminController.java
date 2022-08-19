package by.tms.eshop.controllers;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.services.CategoryService;
import by.tms.eshop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
@RequestMapping("/db.eshop")
@Tag(name = "Admin", description = "The Admin API")
public class AdminController {

  private final CategoryService categoryService;
  private final ProductService productService;

  public AdminController(CategoryService categoryService, ProductService productService) {
    this.categoryService = categoryService;
    this.productService = productService;
  }

  @Operation(
      summary = "Upload a category File",
      description = "Upload all categories from file"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "201",
          description = "Category file uploaded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Categories not uploaded - forbidden operation"
      )
  })
  @PostMapping(value = "/upload/category", consumes = {
      "multipart/form-data"
  })
  public ResponseEntity<Set<CategoryDto>> uploadCategoriesFromFile(
      @RequestParam("file") MultipartFile file) throws Exception {
    return categoryService.saveCategoriesFromFile(file);
  }

  @Operation(
      summary = "Upload a product File",
      description = "Upload all products from file"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "201",
          description = "Product file uploaded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Products not uploaded - forbidden operation"
      )
  })
  @PostMapping(value = "/upload/product", consumes = {
      "multipart/form-data"
  })
  public ResponseEntity<Set<ProductDto>> uploadProductsFromFile(
      @RequestParam("file") MultipartFile file)
      throws Exception {
    return productService.saveProductsFromFile(file);
  }

  @Operation(
      summary = "Download a product File",
      description = "Download all products"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Product file downloaded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Can't download products file - forbidden operation"
      )
  })
  @GetMapping(value = "/download/products.csv")
  public ResponseEntity<Set<ProductDto>> downloadProductsCsv(HttpServletResponse response)
      throws Exception {
    response.setHeader("Content-Disposition", "attachment; file=products.csv");
    return productService.downloadProductsCSV(response.getWriter());
  }

  @Operation(
      summary = "Download a category File",
      description = "Download all categories"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Category file downloaded",
          content = @Content(
              mediaType = "application/json",
              array = @ArraySchema(schema = @Schema(implementation = CategoryDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Can't download categories file - forbidden operation"
      )
  })
  @GetMapping(value = "/download/categories.csv")
  public ResponseEntity<Set<CategoryDto>> downloadCategoriesCsv(HttpServletResponse response)
      throws Exception {
    response.setHeader("Content-Disposition", "attachment; file=categories.csv");
    return categoryService.downloadCategoriesCSV(response.getWriter());
  }
}
