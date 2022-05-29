package by.tms.model;

import java.util.Objects;

public class Category {

  private int id;
  private String name;
  private String imageName;

  public Category(int id, String name, String imageName) {
    this.id = id;
    this.name = name;
    this.imageName = imageName;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getImageName() {
    return imageName;
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
    return getId() == category.getId() && getName().equals(category.getName())
        && getImageName().equals(category.getImageName());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId(), getName(), getImageName());
  }
}
