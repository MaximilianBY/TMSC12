package by.tms.entities;

import java.io.Serializable;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity implements Serializable {

  @Getter
  private String login;
  private String name;
  private String surname;
  private String birthday;
  private String email;
  private String phoneNumber;
  private String password;
  private Cart cart;

  @Override
  public BaseEntity clone() {
    return null;
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
    User user = (User) o;
    return getLogin().equals(user.getLogin()) && getName().equals(user.getName())
        && getSurname().equals(user.getSurname()) && getBirthday().equals(user.getBirthday())
        && getEmail().equals(user.getEmail()) && getPhoneNumber().equals(user.getPhoneNumber())
        && getPassword().equals(user.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(super.hashCode(), getLogin(), getName(), getSurname(), getBirthday(),
        getEmail(), getPhoneNumber(), getPassword());
  }
}
