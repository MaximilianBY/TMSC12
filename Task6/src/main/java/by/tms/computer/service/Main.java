package by.tms.computer.service;

import static by.tms.computer.utils.ComputerUtils.turnOff;
import static by.tms.computer.utils.ComputerUtils.turnOn;

import by.tms.computer.model.Computer;

public class Main {
    public static void main(String[] args) {
        Computer computer1 = new Computer("Ryzen 7", 16, 580, 10);
        turnOn(computer1);
        turnOff(computer1);
    }
}
