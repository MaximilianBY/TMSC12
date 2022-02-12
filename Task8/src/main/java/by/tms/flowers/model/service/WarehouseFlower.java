package by.tms.flowers.model.service;

import by.tms.flowers.model.Flower;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@ToString

public class WarehouseFlower {
    private static Map<String, Flower> flowersStock = new HashMap<>();

    public WarehouseFlower() {

    }

    public void purchaseFlower(String flowerConstants, Flower flower) {
        flowersStock.put(flowerConstants, flower);
    }

    public static Map<String, Flower> getFlowersStock() {
        return flowersStock;
    }
}
