package by.tms.flowers.model.service;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class WarehouseFlower {

  private Map<String, WarehouseFlower> flowersStock = new HashMap<>();
  private double price;
  private int purchasedFlowers;
  private int quantityFlowers;

  public WarehouseFlower(double price, int purchasedFlowers) {
    this.price = price;
    this.purchasedFlowers = purchasedFlowers;
  }

  public int restFlower(int quantity) {
    this.purchasedFlowers = purchasedFlowers - quantity;
    return this.purchasedFlowers;
  }

  public WarehouseFlower() {

  }

  public void purchaseFlower(String flower, WarehouseFlower warehouseFlower) {
    flowersStock.put(flower, warehouseFlower);
  }

  public Map<String, WarehouseFlower> getFlowersStock() {
    return this.flowersStock;
  }
}
