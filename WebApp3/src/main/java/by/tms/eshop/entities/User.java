package by.tms.eshop.entities;

import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

  private String login;
  private String name;
  private String surname;
  private String birthday;
  private String email;
  private String phoneNumber;
  private String password;
  private Cart cart;

  public User(User user) {
    super(user);
    if (Optional.ofNullable(user).isPresent()) {
      this.login = user.getLogin();
      this.name = user.getName();
      this.surname = user.surname;
      this.birthday = user.getBirthday();
      this.email = user.getEmail();
      this.phoneNumber = user.getPhoneNumber();
      this.password = user.getPassword();
      this.cart = user.getCart();
    }
  }

  @Override
  public BaseEntity clone() {
    return new User(this);
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
