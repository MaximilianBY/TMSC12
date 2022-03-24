public class User {
    private String firstName;
    private String lastName;
    private int age;
    private char sex;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public User(String firstName, String lastName, int age, char sex) {
        this(firstName, lastName);
        this.age = age;
        this.sex = sex;
    }

    public void increaseAge() {
        this.age++;
    }

    public void changeSex() {
        Character character = new Character('F');
        this.sex = character;
    }

    @Override
    public String toString() {
        return "Данные о пользователе: \n" +
                "Имя: " + firstName + "\n" +
                "Фамилия: - " + lastName + "\n" +
                "Возраст: " + age + "\n" +
                "Пол: " + sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
}
