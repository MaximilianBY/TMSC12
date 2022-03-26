package by.tms.voenkomat;
/*
Класс наследуется от персона и принимает его конструктор с методом, по сути в этот метод можно кучу всякой доп инфы
еще толкать.
 */

class PersonRegistry extends Person {

    public PersonRegistry(String name, int age, String sex, String citizenship, String city) {
        super(name, age, sex, citizenship, city);
    }

    @Override
    public String personInfo() {
        return "имя: " + getName() + "\n" +
                "возраст: " + getAge() + "\n" +
                "пол: " + getSex() + "\n" +
                "гражданство: " + getCitizenship() + "\n" +
                "город прописки: " + getCity();
    }
}