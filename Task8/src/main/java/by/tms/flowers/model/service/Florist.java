package by.tms.flowers.model.service;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Florist {

  private WarehouseFlower warehouseFlower;
  private Scanner scanner = new Scanner(System.in);
  private int count;
  private double totalPrice;

  public Florist(WarehouseFlower warehouseFlower) {
    this.warehouseFlower = warehouseFlower;
  }

  public void ArrangementBouquet(String flowerName, List<String> sellList) {
    for (Map.Entry entry : warehouseFlower.getFlowersStock().entrySet()) {
      if (entry.getKey().equals(flowerName)) {
        WarehouseFlower warehouseFlower = (WarehouseFlower) entry.getValue();
        if (warehouseFlower.getPurchasedFlowers() > 0) {
          System.out.println(
              "Сколько цветов отобрать в букет? В наличии " + warehouseFlower.getPurchasedFlowers()
                  + " шт.");
          int quantity = scanner.nextInt();
          if (quantity <= warehouseFlower.getPurchasedFlowers()) {
            warehouseFlower.restFlower(quantity);
            count += quantity;
            sellList.add(flowerName + " " + "в количестве " + quantity + " шт.");
            setTotalPrice(getTotalPrice() + quantity * warehouseFlower.getPrice());
          } else {
            System.out.println("у нас столько нет " + entry.getKey());
          }
        } else {
          System.out.println("Извините, но " + entry.getKey() + " распроданы!");
        }
      }
    }
  }

  public void infoBouquet(List<String> sellList) {
    System.out.println("Вы приобрели:");
    for (String flower : sellList) {
      System.out.println(flower + "\n");
    }
  }
}
