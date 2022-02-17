package by.tms.flowers.model.service;

import by.tms.flowers.model.constants.FlowerConstants;
import lombok.ToString;

@ToString

public class Main {

  public static void main(String[] args) {
    FlowerConstants flowerConstants = new FlowerConstants();
    WarehouseFlower warehouseFlower = new WarehouseFlower();
    warehouseFlower.purchaseFlower(flowerConstants.getROSE(),
        new WarehouseFlower(flowerConstants.getPRICE_ROSE(), 100));
    warehouseFlower.purchaseFlower(flowerConstants.getASTER(),
        new WarehouseFlower(flowerConstants.getPRICE_ASTER(), 80));
    warehouseFlower.purchaseFlower(flowerConstants.getTULIP(),
        new WarehouseFlower(flowerConstants.getPRICE_TULIP(), 120));
    warehouseFlower.purchaseFlower(flowerConstants.getHERBERA(),
        new WarehouseFlower(flowerConstants.getPRICE_HERBERA(), 60));
    Florist florist = new Florist(warehouseFlower);
    FlowerShop buyer = new FlowerShop(florist);
    buyer.order(flowerConstants);
    FlowerShop buyer1 = new FlowerShop(florist);
    buyer1.order(flowerConstants);
  }
}
