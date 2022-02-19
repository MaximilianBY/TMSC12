package by.tms.flowers.model.service;

import java.util.List;
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

  public void arrangementBouquet(String flowerName, List<String> sellList) {
    if (warehouseFlower.getFlowersStock().get(flowerName).getPurchasedFlowers() > 0) {
      System.out.println(
          "Сколько цветов отобрать в букет? В наличии " + warehouseFlower.getFlowersStock()
              .get(flowerName).getPurchasedFlowers()
              + " шт.");
      int quantity = scanner.nextInt();
      if (quantity <= warehouseFlower.getFlowersStock().get(flowerName).getPurchasedFlowers()) {
        warehouseFlower.getFlowersStock().get(flowerName).restFlower(quantity);
        count += quantity;
        sellList.add(flowerName + " " + "в количестве " + quantity + " шт.");
        setTotalPrice(getTotalPrice() + quantity * warehouseFlower.getFlowersStock().get(flowerName)
            .getPrice());
      } else {
        System.out.println("у нас столько нет " + flowerName);
      }
    } else {
      System.out.println("Извините, но " + flowerName + " распроданы!");
    }
  }

  public void infoBouquet(List<String> sellList) {
    System.out.println("Вы приобрели:");
    for (String flower : sellList) {
      System.out.println(flower + "\n");
    }
  }
}
