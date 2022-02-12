package by.tms.flowers.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Flower {
    private double price;
    private int purchasedFlowers;
    private int quantityFlowers;

//    public Flower(String name, double price) {
//        this.name = name;
//        this.price = price;
//    }

    public Flower(double price, int purchasedFlowers) {
        this.price = price;
        this.purchasedFlowers = purchasedFlowers;
    }

    public Flower(int quantityFlowers, double price, int purchasedFlowers) {
        this.quantityFlowers = quantityFlowers;
        this.price = price;
        this.purchasedFlowers = purchasedFlowers;
    }

    public int restFlower(int quantity) {
        this.purchasedFlowers = purchasedFlowers - quantity;
        return this.purchasedFlowers;
    }
}
