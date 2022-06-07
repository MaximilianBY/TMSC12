package by.tms.utils;

public enum CommandsEnum {

  SIGN_IN_COMMAND("sign-in"),
  REGISTRATION_COMMAND("register"),
  ACCOUNT_COMMAND("user-account"),
  HOME_COMMAND("home-page"),
  CATEGORY_COMMAND("category-redirect"),
  DEVICES_COMMAND("devices-redirect"),
  REDIRECT_PRODUCT_COMMAND("product-redirect"),
  ADD_PRODUCT_TO_CART_COMMAND("add-product-to-cart"),
  REDIRECT_SHOPPING_CART_COMMAND("redirect-to-shopping-cart"),
  ACTION_SHOPPING_CART_COMMAND("action-shopping-cart"),
  SEARCH_PRODUCT("search-product");

  private final String command;

  CommandsEnum(String command) {
    this.command = command;
  }

  public String getCommand() {
    return command;
  }
}
