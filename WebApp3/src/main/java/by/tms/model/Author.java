package by.tms.model;

public class Author {

  private static String firstName;
  private static String lastName;
  private static int age;
  private static String citizenship;
  private static String aboutMe;

  static {
    firstName = "Maximilian";
    lastName = "Poltorzhickiy";
    age = 32;
    citizenship = "Беларус, но это не точно!!!";
    aboutMe =
        "Всем привет, спасибо что посетили мою пробную странчику! Я только учусь на JavaEE программиста, "
            + "думаю делаю определенные успехи, но этого пока недостаточно, есть куда стремиться";
  }

  public static String getFirstName() {
    return firstName;
  }

  public static String getLastName() {
    return lastName;
  }

  public static int getAge() {
    return age;
  }

  public static String getCitizenship() {
    return citizenship;
  }

  public static String getAboutMe() {
    return aboutMe;
  }
}
