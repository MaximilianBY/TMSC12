package by.tms.utils;

public enum RequestParamsEnum {

  LOGIN("login"),
  PASSWORD("password"),
  CONFIRM_PASSWORD("confirm_password"),
  USER_NAME("user_name"),
  SURNAME("surname"),
  BIRTHDAY("birthday"),
  EMAIL("email"),
  PHONE_NUMBER("phone_number"),
  CURRENT_USER("current_user"),
  CURRENT_USER_CART("user_cart"),
  COMMAND("command"),
  CATEGORY("category"),
  CATEGORY_ID("category_id"),
  DEVICES("devices"),
  PRODUCT_ID("product_id"),
  PRODUCT("product"),
  SHOPPING_CART_PRODUCTS("user_shopping_cart"),
  ORDER_STORY("order_story"),
  STATUS("status"),
  TOTAL_PRICE("total_price");

  private final String value;

  RequestParamsEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
