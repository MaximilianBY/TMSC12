package by.tms.flowers.model.service;

import java.util.List;
import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Florist {

  private FlowerWarehouse flowerWarehouse;
  private Scanner scanner = new Scanner(System.in);
  private int flowerCounter;
  private double totalPrice;

  public Florist(FlowerWarehouse flowerWarehouse) {
    this.flowerWarehouse = flowerWarehouse;
  }

  public void arrangementBouquet(String flowerName, List<String> sellList) {
    if (flowerWarehouse.getFlowersStock().get(flowerName).getPurchasedFlowers() > 0) {
      System.out.println(
          "Сколько цветов отобрать в букет? В наличии " + flowerWarehouse.getFlowersStock()
              .get(flowerName).getPurchasedFlowers()
              + " шт.");
      int quantity = scanner.nextInt();
      if (quantity <= flowerWarehouse.getFlowersStock().get(flowerName).getPurchasedFlowers()) {
        flowerWarehouse.getFlowersStock().get(flowerName).restFlower(quantity);
        flowerCounter += quantity;
        sellList.add(flowerName + " " + "в количестве " + quantity + " шт.");
        setTotalPrice(getTotalPrice() + quantity * flowerWarehouse.getFlowersStock().get(flowerName)
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
