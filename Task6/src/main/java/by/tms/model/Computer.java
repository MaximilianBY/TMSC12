package by.tms.model;

import java.util.Random;
import java.util.Scanner;

public class Computer {
    private String cpu;
    private int ddr;
    private int hdd;
    private int resource;
    private boolean burned;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();

    public Computer(String cpu, int ddr, int hdd, int resource) {
        this.cpu = cpu;
        this.ddr = ddr;
        this.hdd = hdd;
        this.resource = resource;
    }

    @Override
    public String toString() {
        return "Данные о компьютере: \n" +
                "Процессор: " + cpu + "\n" +
                "Размер оперативной памяти Gb: '" + ddr + "\n" +
                "Размер жесткого диска Gb: " + hdd + "\n" +
                "Ресурс компьютера составляет: " + resource;
    }

    public void switchOn() {
        if (this.burned) {
            System.out.println("Computer burned out");
        } else {
            System.out.println("Computer switched on");
        }
    }

    public void switchOff() {
        System.out.println("Внимание! Введите 0 или 1: ");
        while (!this.burned) {
            if (this.resource > 0 && scanner.nextInt() == random.nextInt(2)) {
                System.out.println("Computer shutdown");
                this.resource--;
                switchOn();
            } else {
                this.burned = true;
                System.out.println("Computer burned out");
            }
        }
    }


    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public int getDdr() {
        return ddr;
    }

    public void setDdr(int ddr) {
        this.ddr = ddr;
    }

    public int getHdd() {
        return hdd;
    }

    public void setHdd(int hdd) {
        this.hdd = hdd;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
}