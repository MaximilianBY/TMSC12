package by.tms.eshop.controllers;

import static by.tms.eshop.EshopConstants.USER;
import static by.tms.eshop.PagesPathConstants.SIGN_IN_PAGE;

import by.tms.eshop.dto.UserDto;
import by.tms.eshop.exceptions.AuthorizationException;
import by.tms.eshop.services.UserService;
import java.util.Objects;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@RestController
@SessionAttributes({USER})
@RequestMapping("/login")
public class AuthController {

  private final UserService userService;

  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping
  public ModelAndView openLoginPage() {
    return new ModelAndView(SIGN_IN_PAGE);
  }

  @PostMapping()
  public ResponseEntity<UserDto> login(@ModelAttribute(USER) @Valid UserDto user,
      BindingResult bindingResult,
      ModelAndView modelAndView) throws AuthorizationException, AuthorizationException {
    log.info("before check errors" + user.getLogin() + " " + user.getPassword());
    if (bindingResult.hasErrors()) {
      log.info("inside check errors");
      populateError("login", modelAndView, bindingResult);
      populateError("password", modelAndView, bindingResult);
      modelAndView.setViewName(SIGN_IN_PAGE);
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    log.info("credentials is valid, all ok. before authenticate");
    return userService.authenticate(user);
  }

  @ModelAttribute(USER)
  public UserDto setUpUserForm() {
    return new UserDto();
  }

  private void populateError(String field, ModelAndView modelAndView, BindingResult bindingResult) {
    if (bindingResult.hasFieldErrors(field)) {
      modelAndView.addObject(field + "Error",
          Objects.requireNonNull(bindingResult.getFieldError(field))
              .getDefaultMessage());
    }
  }
}
