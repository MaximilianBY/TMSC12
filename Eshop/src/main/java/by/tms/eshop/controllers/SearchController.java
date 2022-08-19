package by.tms.eshop.controllers;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.services.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Set;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search")
public class SearchController {

  private ProductService productService;

  public SearchController(ProductService productService) {
    this.productService = productService;
  }

  @Operation(
      summary = "Open devices from search",
      description = "Open devices from search"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Devices founded",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "400",
          description = "Devices not fount - forbidden operation"
      )
  })
  @GetMapping
  public ResponseEntity<Set<ProductDto>> getResultFromSearchRequest(
      @RequestParam("searchField") String searchField)
      throws Exception {
    return productService.findProductsFromRequest(searchField);
  }
}
