package by.tms.entities;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class Product extends BaseEntity {

  private String brand;
  private String model;
  private String description;
  private int price;
  private String imagePath;
  private int quantity;
  @Getter
  private int categoryID;

  public Product(Product product) {
    super(product);
    if (Optional.ofNullable(product).isPresent()) {
      this.brand = product.getBrand();
      this.model = product.getModel();
      this.description = product.getDescription();
      this.price = product.getPrice();
      this.imagePath = product.getImagePath();
      this.quantity = product.getQuantity();
      this.categoryID = product.getCategoryID();
    }
  }

  @Override
  public BaseEntity clone() {
    return new Product(this);
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
    Product product = (Product) o;
    return getCategoryID() == product.getCategoryID() && getBrand().equals(product.getBrand())
        && getModel().equals(product.getModel()) && getDescription().equals(
        product.getDescription());
  }
}
