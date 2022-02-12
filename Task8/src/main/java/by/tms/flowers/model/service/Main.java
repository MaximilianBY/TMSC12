package by.tms.flowers.model.service;

import by.tms.flowers.model.Flower;
import by.tms.flowers.model.constants.FlowerConstants;
import lombok.ToString;

@ToString

public class Main {
    public static void main(String[] args) {
        FlowerConstants flowerConstants = new FlowerConstants();
        WarehouseFlower warehouseFlower = new WarehouseFlower();
        warehouseFlower.purchaseFlower(flowerConstants.getROSE(), new Flower(flowerConstants.getPRICEROSE(), 100));
        warehouseFlower.purchaseFlower(flowerConstants.getASTER(), new Flower(flowerConstants.getPRICEASTER(), 80));
        warehouseFlower.purchaseFlower(flowerConstants.getTULIP(), new Flower(flowerConstants.getPRICETULIP(), 120));
        warehouseFlower.purchaseFlower(flowerConstants.getHERBERA(), new Flower(flowerConstants.getPRICEHERBERA(), 60));
        SellBouquet sellBouquet = new SellBouquet();
        sellBouquet.order(flowerConstants);
        SellBouquet sellBouquet1 = new SellBouquet();
        sellBouquet1.order(flowerConstants);
    }
}
