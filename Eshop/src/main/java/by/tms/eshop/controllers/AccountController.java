package by.tms.eshop.controllers;

import by.tms.eshop.dto.UserDto;
import by.tms.eshop.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/account")
@Tag(name = "Account", description = "The account API")
public class AccountController {

  private final OrderService orderService;

  public AccountController(OrderService orderService) {
    this.orderService = orderService;
  }

  @Operation(
      summary = "Get user data and orders history",
      description = "Get user data and orders history"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "User data and orders history",
          content =
          @Content(schema = @Schema(implementation = UserDto.class))
      ),
      @ApiResponse(
          responseCode = "400",
          description = "No user information"
      )
  })
  @GetMapping
  public ResponseEntity<UserDto> openAccountPage(@RequestBody UserDto userDto) throws Exception {
    if (Optional.ofNullable(userDto).isPresent()) {
      return orderService.getUserOrders(userDto);
    }
    return new ResponseEntity(HttpStatus.UNAUTHORIZED);
  }
}