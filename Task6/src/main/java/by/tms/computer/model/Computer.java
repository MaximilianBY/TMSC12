package by.tms.computer.model;

public class Computer {

  private String cpu;
  private int ddr;
  private int hdd;
  private int resource;
  private boolean isBurned;

  public Computer(String cpu, int ddr, int hdd, int resource) {
    this.cpu = cpu;
    this.ddr = ddr;
    this.hdd = hdd;
    this.resource = resource;
  }

  public int getResource() {
    return resource;
  }

  public void setResource(int resource) {
    this.resource = resource;
  }

  public boolean isBurned() {
    return isBurned;
  }

  public void setBurned(boolean burned) {
    isBurned = burned;
  }

  @Override
  public String toString() {
    return "Данные о компьютере: \n"
        + "Процессор: " + cpu + "\n"
        + "Размер оперативной памяти Gb: '" + ddr + "\n"
        + "Размер жесткого диска Gb: " + hdd + "\n"
        + "Ресурс компьютера составляет: " + resource;
  }
}
