package by.tms.carts;


import by.tms.entities.Cart;
import by.tms.entities.Product;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTests {

  private Cart cart1;
  private Cart cart2;
  private Cart cart3;
  private Product product1;
  private Product product2;
  private List<Product> actualUserCart;
  private List<Product> actualAfterDelete;

  @BeforeEach
  public void setUp() {
    product1 = Product.builder()
        .id(3)
        .brand("Xiaomi")
        .model("Redmi Note 8")
        .description(
            "Android, экран 6.3\" IPS (1080x2340), Qualcomm Snapdragon 665, ОЗУ 4 ГБ, флэш-память 64 ГБ, карты памяти, камера 48 Мп, аккумулятор 4000 мАч, 2 SIM")
        .price(300)
        .imagePath("xiaomi_rn8.jpg")
        .quantity(5)
        .categoryID(1)
        .build();
    product2 = Product.builder()
        .id(1)
        .brand("Asus")
        .model("N75SF")
        .description(
            "17.3\" 1920 x 1080 TN+Film, несенсорный, 2310M 2100 МГц, 4 ГБ DDR3, HDD 750 ГБ, Windows 7 Home Premium, DVD, цвет крышки черный")
        .price(1500)
        .imagePath("asus_n75sf.jpg")
        .quantity(6)
        .categoryID(2)
        .build();

    cart1 = new Cart();
    cart2 = new Cart();
    cart3 = new Cart();

    cart1.addProductToCart(product1);
    cart2.addProductToCart(product2);
    cart3.addProductToCart(product1);
    cart3.addProductToCart(product2);

    actualUserCart = cart1.getUsersCart();
    actualAfterDelete = cart3.getUsersCart();
  }

  @Test
  public void getUsersCart() {
    Product cloneProduct = new Product(product1);
    Cart cart = new Cart();
    cart.addProductToCart(cloneProduct);
    Assertions.assertEquals(cart, cart1);
  }

  @Test
  public void addProductToUserCart() {
    Product cloneProduct2 = new Product(product2);
    cart2.addProductToCart(product2);
    Cart cart = new Cart();
    cart.addProductToCart(cloneProduct2);
    Assertions.assertEquals(cart, cart2);
  }

  @Test
  public void deleteProductFromUserCart() {
    Product cloneProduct1 = new Product(product1);
    Product cloneProduct2 = new Product(product2);
    Cart cart = new Cart();
    cart.addProductToCart(cloneProduct1);
    cart.addProductToCart(cloneProduct2);
    cart.addProductToCart(cloneProduct1);
    cart.delUnnecessaryProduct(cloneProduct1);
    Assertions.assertEquals(cart, cart3);
  }
}
