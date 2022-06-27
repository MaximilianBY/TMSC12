package by.tms.eshop.entities;

import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Category extends BaseEntity {

  private String name;
  private String imagePath;
  private Set<Product> productSet;

  public Category(Category category) {
    super(category);
    this.name = category.getName();
    this.imagePath = category.getImagePath();
  }

  @Override
  public BaseEntity clone() {
    return new Category(this);
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
    Category category = (Category) o;
    return getName().equals(category.getName()) && getImagePath().equals(category.getImagePath())
        && getProductSet().equals(category.getProductSet());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName(), getImagePath(), getProductSet());
  }
}
