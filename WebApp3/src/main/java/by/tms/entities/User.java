package by.tms.entities;

import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@SuperBuilder
public class User extends BaseEntity {

  private String login;
  private @Setter String name;
  private @Setter String surname;
  private @Setter String birthday;
  private @Setter String email;
  private @Setter String phoneNumber;
  private @Setter String password;
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
