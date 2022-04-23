package by.tms.model;

import java.util.Objects;

public class Category {

  private String name;
  private String imageName;

  private String link;

  public Category(String name, String imageName, String link) {
    this.name = name;
    this.imageName = imageName;
    this.link = link;
  }

  public String getName() {
    return name;
  }

  public String getImageName() {
    return imageName;
  }

  public String getLink() {
    return link;
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
        && getLink().equals(category.getLink());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getImageName(), getLink());
  }
}
