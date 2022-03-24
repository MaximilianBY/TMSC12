package by.tms.voenkomat;
/*
Решил всю логику расписать в этом классе, хотя в целом можно было создать дополнительно отдельный класс с 2 методами, который
занимался бы внесением и проверкой. чтобы не вносить инфу вручную через консоль, решил подвязать простой txt файл
с заранее подготовленной инфой. Все классы с модификатором package protected.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        System.out.println("Данные о населении: " + "\n");
        for (PersonRegistry value : populationCensus()) {
            System.out.println(value.personInfo() + "\n");
        }
        System.out.println("Данные о всех призывниках: " + "\n");
        for (MilitaryOfficeMinsk value : censusConscripts()) {
            System.out.println(value.personInfo() + "\n");
        }
        System.out.println("Данные о призывника только города Минска: " + "\n");
        for (MilitaryOfficeMinsk value : censusConscripts()) {
            if (value.getCity().equals("Минск")) {
                System.out.println(value.personInfo() + "\n");
            }
        }
        System.out.println("Данные о всех призывниках в возрасте от 25 до 27: " + "\n");
        for (MilitaryOfficeMinsk value : censusConscripts()) {
            if (value.getAge() >= 25 && value.getAge() <= 27) {
                System.out.println(value.personInfo() + "\n");
            }
        }
        System.out.println("Данные о всех призывниках с именем Александр: " + "\n");
        for (MilitaryOfficeMinsk value : censusConscripts()) {
            if (value.getName().equals("Александр")) {
                System.out.println(value.personInfo() + "\n");
            }
        }
    }

    public static List<PersonRegistry> populationCensus() {
        List<PersonRegistry> personRegistries = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\hitch\\Desktop\\personRegistry.txt"))) {
            while (reader.ready()) {
                String[] inPersonData = reader.readLine().split(" ");
                personRegistries.add(new PersonRegistry(inPersonData[0], Integer.parseInt(inPersonData[1]),
                        inPersonData[2], inPersonData[3], inPersonData[4]));
            }
        } catch (IOException e) {

        }
        return personRegistries;
    }

    public static List<MilitaryOfficeMinsk> censusConscripts() {
        List<MilitaryOfficeMinsk> militaryOfficeMinsks = new ArrayList<>();
        for (PersonRegistry value : populationCensus()) {
            if (value.getSex().equals(Person.MALE) && value.getCitizenship().equals("РБ") &&
                    value.getAge() >= 18 && value.getAge() <= 27) {
                militaryOfficeMinsks.add(new MilitaryOfficeMinsk(value.getName(), value.getAge(), value.getCity()));
            }
        }
        return militaryOfficeMinsks;
    }
}