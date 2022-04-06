package by.tms.user.service;

import static by.tms.user.model.UserMetrics.changeSex;
import static by.tms.user.model.UserMetrics.increaseAge;
import static by.tms.user.model.UserMetrics.printUserInfo;

import by.tms.user.model.User;

public class Main {

  public static void main(String[] args) {
    User user1 = new User("Илья", "Иванов", 24, 'М');
    User user2 = new User();
    user2.setFirstName("Петя");
    user2.setLastName("Петров");
    user2.setAge(35);
    user2.setSex('М');
    System.out.println(printUserInfo(user1) + "\n");
    System.out.println(printUserInfo(user2) + "\n");
    increaseAge(user1);
    increaseAge(user2);
    System.out.println(printUserInfo(user1) + "\n");
    System.out.println(printUserInfo(user2) + "\n");
    changeSex(user1);
    System.out.println(printUserInfo(user1) + "\n");
  }
}
