package by.tms.flowers.model.service;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FlowerWarehouse {

  private Map<String, FlowerWarehouse> flowersStock = new HashMap<>();
  private double price;
  private int purchasedFlowers;
  private int quantityFlowers;

  public FlowerWarehouse(double price, int purchasedFlowers) {
    this.price = price;
    this.purchasedFlowers = purchasedFlowers;
  }

  public int restFlower(int quantity) {
    this.purchasedFlowers = purchasedFlowers - quantity;
    return this.purchasedFlowers;
  }

  public FlowerWarehouse() {

  }

  public void purchaseFlower(String flower, FlowerWarehouse flowerWarehouse) {
    flowersStock.put(flower, flowerWarehouse);
  }

  public Map<String, FlowerWarehouse> getFlowersStock() {
    return this.flowersStock;
  }
}
