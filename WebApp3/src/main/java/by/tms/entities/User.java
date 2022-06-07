package by.tms.entities;

import java.io.Serializable;
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

  @Override
  public BaseEntity clone() {
    return null;
  }
}
