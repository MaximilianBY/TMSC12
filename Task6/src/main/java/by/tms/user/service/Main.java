package by.tms.user.service;

import by.tms.user.model.User;
import by.tms.user.model.UserMetrics;

public class Main {

  public static void main(String[] args) {
    User user1 = new User("Илья", "Иванов", 24, 'М');
    User user2 = new User();
    user2.setFirstName("Петя");
    user2.setLastName("Петров");
    user2.setAge(35);
    user2.setSex('М');
    System.out.println(UserMetrics.printUserInfo(user1) + "\n");
    System.out.println(UserMetrics.printUserInfo(user2) + "\n");
    UserMetrics.increaseAge(user1);
    UserMetrics.increaseAge(user2);
    System.out.println(UserMetrics.printUserInfo(user1) + "\n");
    System.out.println(UserMetrics.printUserInfo(user2) + "\n");
    UserMetrics.changeSex(user1);
    System.out.println(UserMetrics.printUserInfo(user1) + "\n");
  }
}
