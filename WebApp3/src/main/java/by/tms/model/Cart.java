package by.tms.model;

import static by.tms.db_utils.CRUDCart.getUserCart;
import static by.tms.db_utils.CRUDCart.updateOrder;
import static by.tms.db_utils.CRUDProduct.updateQuantityProducts;
import static by.tms.utils.ProductList.getProductByID;
import static by.tms.utils.RequestParamsEnum.SHOPPING_CART_PRODUCTS;
import static by.tms.utils.RequestParamsEnum.TOTAL_PRICE;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Cart {

  private Map<Integer, Product> userCart;

  public Cart() {
    this.userCart = new HashMap<>();
  }


  public String getProductListFromUserCart(HttpSession session, String url) {
    session.setAttribute(SHOPPING_CART_PRODUCTS.getValue(), userCart.values().stream().toList());
    session.setAttribute(TOTAL_PRICE.getValue(), getTotalPrice(userCart));
    return url;
  }

  public void addProductToCart(int productID) {
    Product product = getProductByID(productID);
    if (userCart.containsKey(productID)) {
      userCart.get(productID).setQuantity(userCart.get(productID).getQuantity() + 1);
      userCart.get(productID)
          .setPrice(userCart.get(productID).getPrice() + product.getPrice());
    } else {
      userCart.put(productID, product);
      userCart.get(productID).setQuantity(1);
    }
  }

  public String getRedeemedProduct(HttpServletRequest request, int userID, String url) {
    Map<Integer, Product> redeemedProducts = getUserCart(userID);
    request.setAttribute(SHOPPING_CART_PRODUCTS.getValue(),
        redeemedProducts.values().stream().toList());

    request.setAttribute(TOTAL_PRICE.getValue(), getTotalPrice(redeemedProducts));

    return url;
  }

  private static int getTotalPrice(Map<Integer, Product> productMap) {
    if (Optional.ofNullable(productMap).isPresent()) {
      return productMap.values().stream()
          .mapToInt(Product::getPrice)
          .sum();
    }
    return 0;
  }

  public void confirmOrder(int userID) {
    for (Product product : userCart.values()) {
      updateQuantityProducts(product);
      updateOrder(userID, product);
    }
    flushUserCart();
  }

  public void flushUserCart() {
    userCart.clear();
  }

  public void delUnnecessaryProduct(int productID) {
    Product product = getProductByID(productID);
    if (userCart.get(productID).getQuantity() == 1) {
      userCart.remove(productID);
    } else {
      userCart.get(productID).setQuantity(userCart.get(productID).getQuantity() - 1);
      userCart.get(productID)
          .setPrice(userCart.get(productID).getPrice() - product.getPrice());
    }
  }
}
