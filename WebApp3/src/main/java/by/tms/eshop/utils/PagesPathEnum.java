package by.tms.eshop.utils;

public enum PagesPathEnum {

  SIGN_IN_PAGE("login"),
  REGISTRATION_PAGE("registration"),
  ACCOUNT_PAGE("account"),
  CATEGORY_PAGE("category"),
  DEVICES_PAGE("devices"),
  CART_PAGE("cart"),
  PRODUCT_PAGE("product"),
  SEARCH_PAGE("resultOfSearch");

  private final String path;

  PagesPathEnum(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
