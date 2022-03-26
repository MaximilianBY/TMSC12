package by.tms.info;

public class Main {

  public static void main(String[] args) {
    UserInfo userInfo = new UserInfo();
    userInfo.setLogin();
    System.out.println(userInfo.checkLogin());
    userInfo.setNewPassword();
    userInfo.setConfirmPassword();
    System.out.println(userInfo.checkPassword());
  }
}
