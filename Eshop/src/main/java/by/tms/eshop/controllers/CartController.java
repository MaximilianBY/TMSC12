package by.tms.eshop.controllers;

import static by.tms.eshop.EshopConstants.PRODUCT_ID;
import static by.tms.eshop.EshopConstants.SHOPPING_CART;
import static by.tms.eshop.EshopConstants.USER;

import by.tms.eshop.dto.ProductDto;
import by.tms.eshop.entities.Cart;
import by.tms.eshop.entities.User;
import by.tms.eshop.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.Set;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;

@Slf4j
@RestController
@RequestMapping("/cart")
@Tag(name = "Cart", description = "The Cart API")
public class CartController {

  private final CartService cartService;

  public CartController(CartService cartService) {
    this.cartService = cartService;
  }

  @Operation(
      summary = "Open cart page",
      description = "Open cart page"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Cart open",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Unauthorized - unauthorized"
      )
  })
  @GetMapping("/open")
  public ResponseEntity<Set<ProductDto>> openCartPage(@SessionAttribute Cart cart) {
    return cartService.openCartPage(cart);
  }

  @Operation(
      summary = "Add product to cart",
      description = "Add product to cart"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Product added",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Product not added"
      )
  })
  @GetMapping("/add")
  public ResponseEntity<Set<ProductDto>> addProductToCart(@RequestParam(PRODUCT_ID) String id,
      @ModelAttribute(SHOPPING_CART) Cart cart) throws Exception {
    int productId = Integer.parseInt(id);
    return cartService.addProductToCart(productId, cart);
  }

  @Operation(
      summary = "Delete product from cart",
      description = "Delete product from cart"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Product deleted",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = ProductDto.class)))
      ),
      @ApiResponse(
          responseCode = "400",
          description = "Product not deleted"
      )
  })
  @GetMapping("/delete")
  public ResponseEntity<Set<ProductDto>> delProductFromCart(@RequestParam(PRODUCT_ID) String id,
      @SessionAttribute(SHOPPING_CART) Cart cart) throws Exception {
    int productId = Integer.parseInt(id);
    return cartService.deleteProductFromCart(productId, cart);
  }

  @Operation(
      summary = "Clear user cart",
      description = "Clear user cart"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Cart cleared"
      ),
      @ApiResponse(
          responseCode = "403",
          description = "Cart not cleared"
      )
  })
  @GetMapping("/reset")
  public ResponseEntity clearUserCart(@SessionAttribute(SHOPPING_CART) Cart cart) {
    return cartService.clearUserCart(cart);
  }

  @Operation(
      summary = "Confirm user order",
      description = "Confirm user order"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Order saved"
      ),
      @ApiResponse(
          responseCode = "401",
          description = "Unauthorized - unauthorized"
      ),
      @ApiResponse(
          responseCode = "400",
          description = "Order not saved"
      )
  })
  @GetMapping("/confirmOrder")
  public ResponseEntity confirmOrder(@SessionAttribute(SHOPPING_CART) Cart cart,
      HttpSession session)
      throws Exception {
    if (Optional.ofNullable(session.getAttribute(USER)).isEmpty()) {
      log.info("inside abort confirm order");
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    return cartService.confirmOrder((User) session.getAttribute(USER), cart);
  }
}
