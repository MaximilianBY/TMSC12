package by.tms.voenkomat;
/*
Класс Person сделал абстрактным, чтобы переменные и конструкторы не подвергались изменениям и никто не мог их повредить,
дополнительно проставил private. На всякий случай добавил геттеры сеттеры ну и 2 конструктора базовых запилил +
абстрактный метод по выводу инфы вписал, вместо тустринга.
 */

abstract class Person {
    public static final String MALE = "мужчина";
    public static final String FEMALE = "женщина";
    private String name;
    private int age;
    private String sex;
    private String citizenship;
    private String city;

    public Person(String name, int age, String city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public Person(String name, int age, String sex, String citizenship, String city) {
        this.name = name;
        this.age = age;
        this.sex = sex.equals("М") ? MALE : sex.equals("Ж") ? FEMALE : "";
        this.citizenship = citizenship;
        this.city = city;
    }

    public abstract String personInfo();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
