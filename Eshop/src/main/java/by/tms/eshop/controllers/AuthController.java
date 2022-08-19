package by.tms.eshop.controllers;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.dto.UserDto;
import by.tms.eshop.exceptions.AuthorizationException;
import by.tms.eshop.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
@Tag(name = "Login", description = "The login API")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @Operation(
      summary = "Login and open home page",
      description = "Login and open home page"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "Logged in",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = CategoryDto.class)))
      ),
      @ApiResponse(
          responseCode = "401",
          description = "Unauthorized - unauthorized"
      )
  })
  @PostMapping()
  public ResponseEntity login(@RequestBody UserDto user) throws AuthorizationException {
    return userService.authenticate(user);
  }
}
