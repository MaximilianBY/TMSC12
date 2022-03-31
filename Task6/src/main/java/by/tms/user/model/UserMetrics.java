package by.tms.user.model;

public class UserMetrics {

  public static void increaseAge(User user) {
    user.setAge(user.getAge() + 1);
  }

  public static void changeSex(User user) {
    Character character = new Character('F');
    user.setSex(character);
  }

  public static String printUserInfo(User user) {
    return "Данные о пользователе: \n" +
        "Имя: " + user.getFirstName() + "\n" +
        "Фамилия: - " + user.getLastName() + "\n" +
        "Возраст: " + user.getAge() + "\n" +
        "Пол: " + user.getSex();
  }
}
