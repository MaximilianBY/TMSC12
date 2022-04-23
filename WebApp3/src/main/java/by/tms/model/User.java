package by.tms.model;

import java.util.Objects;

public class User {

  private String name;
  private String password;

  {
    name = "Max";
    password = "1234";
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return getName().equals(user.getName()) && getPassword().equals(user.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getPassword());
  }
}
