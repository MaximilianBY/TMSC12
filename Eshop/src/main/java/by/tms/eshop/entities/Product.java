package by.tms.eshop.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.Hibernate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@RequiredArgsConstructor
@SuperBuilder
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

  @Column(name = "BRAND", nullable = false)
  private String brand;
  @Column(name = "MODEL", nullable = false)
  private String model;
  @Column(name = "DESCRIPTION", nullable = false)
  private String description;
  @Column(name = "PRICE", nullable = false)
  private int price;
  @Column(name = "QUANTITY", nullable = false)
  private int quantity;
  @ManyToOne(optional = false)
  @JoinColumn(name = "CATEGORY_ID", nullable = false, referencedColumnName = "id")
  private Category category;
  @Column(name = "IMAGE_PATH", nullable = false)
  private String imagePath;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Product product = (Product) o;
    return id != null && Objects.equals(id, product.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
