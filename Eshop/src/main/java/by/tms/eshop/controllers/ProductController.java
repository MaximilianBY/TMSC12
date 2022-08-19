package by.tms.eshop.controllers;

import static by.tms.eshop.EshopConstants.PRODUCT_ID;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@Tag(name = "Product", description = "The Product API")
public class ProductController {

  private final ProductService productService;

  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(
      summary = "Open product page",
      description = "Open product page"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Product founded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "400",
          description = "Product not exist - forbidden operation"
      )
  })
  @GetMapping()
  public ResponseEntity<ProductDto> openProductPage(@RequestParam(PRODUCT_ID) String id)
      throws Exception {
    int productId = Integer.parseInt(id);
    return productService.getProductData(productId);
  }

}
