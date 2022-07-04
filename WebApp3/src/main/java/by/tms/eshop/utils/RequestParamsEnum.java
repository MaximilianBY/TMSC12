package by.tms.eshop.utils;

public enum RequestParamsEnum {

  CATEGORY("category"),
  DEVICES("devices"),
  PRODUCT("product"),
  ORDER_STORY("order_story"),
  TOTAL_PRICE("total_price");

  private final String value;

  RequestParamsEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
