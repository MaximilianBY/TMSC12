package by.tms.voenkomat;
/*
аналогичен предыдущему классу, только с укороченным конструктором, в который поступает уже отсортированная инфа ну и вывод.
 */

class MilitaryOfficeMinsk extends Person {

    public MilitaryOfficeMinsk(String name, int age, String city) {
        super(name, age, city);
    }

    @Override
    public String personInfo() {
        return "имя: " + getName() + "\n" +
                "возраст: " + getAge() + "\n" +
                "город прописки: " + getCity();
    }
}
