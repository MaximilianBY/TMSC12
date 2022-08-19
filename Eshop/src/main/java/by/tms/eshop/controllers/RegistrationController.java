package by.tms.eshop.controllers;

import by.tms.eshop.dto.UserDto;
import by.tms.eshop.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@Tag(name = "Registration", description = "The registration API")
public class RegistrationController {

  private final UserService userService;

  public RegistrationController(UserService userService) {
    this.userService = userService;
  }

  @Operation(
      summary = "Registration page",
      description = "Registration page"
  )
  @ApiResponses(value = {
      @ApiResponse(
          responseCode = "200",
          description = "User registered",
          content = @Content(array = @ArraySchema(schema = @Schema(implementation = UserDto.class)))
      ),
      @ApiResponse(
          responseCode = "400",
          description = "User existing"
      )
  })
  @PostMapping()
  public ResponseEntity<UserDto> addNewUser(@RequestBody @Valid UserDto user)
      throws Exception {
    return userService.registration(user);
  }
}
