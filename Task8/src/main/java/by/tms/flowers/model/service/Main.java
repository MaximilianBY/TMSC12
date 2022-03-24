package by.tms.flowers.model.service;

import by.tms.flowers.model.constants.FlowerConstants;

public class Main {

  public static void main(String[] args) {
    FlowerWarehouse flowerWarehouse = new FlowerWarehouse();
    flowerWarehouse.purchaseFlower(FlowerConstants.ROSE,
        new FlowerWarehouse(FlowerConstants.PRICE_ROSE, 100));
    flowerWarehouse.purchaseFlower(FlowerConstants.ASTER,
        new FlowerWarehouse(FlowerConstants.PRICE_ASTER, 80));
    flowerWarehouse.purchaseFlower(FlowerConstants.TULIP,
        new FlowerWarehouse(FlowerConstants.PRICE_TULIP, 120));
    flowerWarehouse.purchaseFlower(FlowerConstants.HERBERA,
        new FlowerWarehouse(FlowerConstants.PRICE_HERBERA, 60));
    Florist florist = new Florist(flowerWarehouse);
    FlowerShop buyer = new FlowerShop(florist);
    buyer.order();
    FlowerShop buyer1 = new FlowerShop(florist);
    buyer1.order();
  }
}
