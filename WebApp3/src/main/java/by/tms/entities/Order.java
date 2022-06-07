package by.tms.entities;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@SuperBuilder
public class Order extends BaseEntity {

  private int userID;
  private Date orderDate;
  private int orderPrice;
  private int productID;
  private int productQuantity;

  @Override
  public BaseEntity clone() {
    return null;
  }
}
