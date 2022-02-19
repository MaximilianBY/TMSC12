package by.tms.flowers.model.service;

import by.tms.flowers.model.constants.FlowerConstants;

public class Main {

  public static void main(String[] args) {
    WarehouseFlower warehouseFlower = new WarehouseFlower();
    warehouseFlower.purchaseFlower(FlowerConstants.ROSE,
        new WarehouseFlower(FlowerConstants.PRICE_ROSE, 100));
    warehouseFlower.purchaseFlower(FlowerConstants.ASTER,
        new WarehouseFlower(FlowerConstants.PRICE_ASTER, 80));
    warehouseFlower.purchaseFlower(FlowerConstants.TULIP,
        new WarehouseFlower(FlowerConstants.PRICE_TULIP, 120));
    warehouseFlower.purchaseFlower(FlowerConstants.HERBERA,
        new WarehouseFlower(FlowerConstants.PRICE_HERBERA, 60));
    Florist florist = new Florist(warehouseFlower);
    FlowerShop buyer = new FlowerShop(florist);
    buyer.order();
    FlowerShop buyer1 = new FlowerShop(florist);
    buyer1.order();
  }
}
