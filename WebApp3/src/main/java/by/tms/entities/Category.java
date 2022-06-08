package by.tms.entities;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@Getter
public class Category extends BaseEntity {

  private String name;
  private String imageName;

  public Category(Category category) {
    super(category);
    this.name = category.getName();
    this.imageName = category.getImageName();
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
    return getName().equals(category.getName()) && getImageName().equals(category.getImageName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getName(), getImageName());
  }
}
