package by.tms.utils;

public enum PagesPathEnum {

  HOME_PAGE("myPage.jsp"),
  SIGN_IN_PAGE("signin.jsp"),
  REGISTRATION_PAGE("registration.jsp"),
  ACCOUNT_PAGE("account.jsp"),
  CATEGORY_PAGE("category.jsp"),
  DEVICES_PAGE("devices.jsp"),
  CART_PAGE("cart.jsp"),
  PRODUCT_PAGE("product.jsp"),
  SEARCH_PAGE("search.jsp");

  private final String path;

  PagesPathEnum(String path) {
    this.path = path;
  }

  public String getPath() {
    return path;
  }
}
