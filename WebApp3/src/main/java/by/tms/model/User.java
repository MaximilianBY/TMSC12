package by.tms.model;

import java.util.Objects;

public class User {

  private int userID;
  private String login;
  private String name;
  private String surname;
  private String birthday;
  private String email;
  private String phoneNumber;
  private String password;
  private Cart cart;

  public User(String login, String password) {
    this.login = login;
    this.password = password;
  }

  public User(String login, String name, String surname, String birthday, String email,
      String phoneNumber, String password) {
    this.login = login;
    this.name = name;
    this.surname = surname;
    this.birthday = birthday;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
  }

  public User(int userID, String login, String name, String surname, String birthday, String email,
      String phoneNumber, String password, Cart cart) {
    this.userID = userID;
    this.login = login;
    this.name = name;
    this.surname = surname;
    this.birthday = birthday;
    this.email = email;
    this.phoneNumber = phoneNumber;
    this.password = password;
    this.cart = cart;
  }

  public int getUserID() {
    return userID;
  }

  public String getLogin() {
    return login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Cart getCart() {
    return cart;
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
    return getUserID() == user.getUserID() && getLogin().equals(user.getLogin())
        && getName().equals(
        user.getName()) && getSurname().equals(user.getSurname()) && getBirthday().equals(
        user.getBirthday()) && getEmail().equals(user.getEmail()) && getPhoneNumber().equals(
        user.getPhoneNumber()) && getPassword().equals(user.getPassword()) && getCart().equals(
        user.getCart());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getUserID(), getLogin(), getName(), getSurname(), getBirthday(), getEmail(),
        getPhoneNumber(), getPassword(), getCart());
  }
}
