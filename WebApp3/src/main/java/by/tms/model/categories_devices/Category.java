package by.tms.model.categories_devices;

import java.util.Objects;

public class Category {

  private String name;
  private String imageName;

  private String type;

  public Category(String name, String imageName, String type) {
    this.name = name;
    this.imageName = imageName;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public String getImageName() {
    return imageName;
  }

  public String getType() {
    return type;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return getName().equals(category.getName()) && getImageName().equals(category.getImageName())
        && getType().equals(category.getType());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getImageName(), getType());
  }
}
