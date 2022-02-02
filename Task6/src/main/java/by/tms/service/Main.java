package by.tms.service;

import by.tms.model.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer("Ryzen 7", 16, 580, 10);
        System.out.println(computer1);
        System.out.println();
        computer1.switchOn();
        computer1.switchOff();
    }
}
