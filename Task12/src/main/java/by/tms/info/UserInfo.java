package by.tms.info;

import java.util.Scanner;

public class UserInfo {

  private static final String DATA_PATTERN = "[a-zA-Z0-9_]{8,20}";
  private String login;
  private String newPassword;
  private String confirmPassword;
  private Scanner scanner = new Scanner(System.in);

  public String checkLogin() {
    if (!isValid(login)) {
      try {
        throw new WrongLoginException();
      } catch (WrongLoginException e) {
        return e.message();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return "Логин соответствует требованиям!";
  }

  public String checkPassword() {
    if ((isValid(newPassword) && isValid(confirmPassword)) && !equalsPasswords()) {
      try {
        throw new WrongPasswordException();
      } catch (WrongPasswordException e) {
        return e.message();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return "Пароль соответствует требованиям";
  }

  private boolean equalsPasswords() {
    return newPassword.equals(confirmPassword);
  }

  private boolean isValid(String str) {
    return str.matches(DATA_PATTERN);
  }

  private static class WrongLoginException extends Exception {

    public String message() {
      return "Логин не соответствует требованиям";
    }
  }

  private static class WrongPasswordException extends Exception {

    public String message() {
      return "Пароль не соответствует требованиям";
    }
  }

  public String getLogin() {
    return login;
  }

  public void setLogin() {
    System.out.println("Введите логин: ");
    this.login = scanner.nextLine();
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword() {
    System.out.println(
        "Введите пароль, он должен состоять из латинских букв, цифр и нижнего подчеркивания, длина от 8 до 20 символов");
    this.newPassword = scanner.nextLine();
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }

  public void setConfirmPassword() {
    System.out.println("Повторите введенный пароль!");
    this.confirmPassword = scanner.nextLine();
  }
}
