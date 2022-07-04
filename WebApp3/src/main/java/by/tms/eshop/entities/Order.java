package by.tms.eshop.entities;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Getter
public class Order extends BaseEntity {

  private int userID;
  private Date orderDate;
  private int orderPrice;
  private int productID;
  private Product product;
  private int productQuantity;

  public Order(Order order) {
    super(order);
    if (Optional.ofNullable(order).isPresent()) {
      this.userID = order.getUserID();
      this.orderDate = order.getOrderDate();
      this.orderPrice = order.getOrderPrice();
      this.productID = order.getProductID();
      this.productQuantity = order.getProductQuantity();
    }
  }

  @Override
  public BaseEntity clone() {
    return new Order(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    Order order = (Order) o;
    return getUserID() == order.getUserID() && getOrderPrice() == order.getOrderPrice()
        && getProductID() == order.getProductID()
        && getProductQuantity() == order.getProductQuantity() && getOrderDate().equals(
        order.getOrderDate());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getUserID(), getOrderDate(), getOrderPrice(),
        getProductID(), getProductQuantity());
  }
}
