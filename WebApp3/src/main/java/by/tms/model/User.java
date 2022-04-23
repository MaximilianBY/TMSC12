package by.tms.model;

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

//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj) return true;
//    if (obj == null || getClass() != obj.getClass()) return false;
//    User user = (User) obj;
//    return Objects.equals(name, user.name) &&
//        Objects.equals(password, user.password);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(name, password);
//  }
}
