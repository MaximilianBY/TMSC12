package by.tms.eshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@Entity
@Table(name = "order_details")
public class OrderDetails {

  @EmbeddedId
  @JsonIgnore
  private OrderDetailsId orderDetailsId;

  @Column(name = "PRODUCT_QUANTITY", nullable = false)
  private Integer quantity;
}
