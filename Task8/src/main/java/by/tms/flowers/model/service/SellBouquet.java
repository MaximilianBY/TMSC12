package by.tms.flowers.model.service;

import by.tms.flowers.model.Flower;
import by.tms.flowers.model.constants.FlowerConstants;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

@Getter
@Setter

public class SellBouquet {
    private String name;
    private int quantity;
    private double totalPrice;
    private Scanner scanner = new Scanner(System.in);
    private List<String> sellList = new ArrayList<>();
    private int count;
    /*
    возможно счетчик следовало бы сделать статическим, тогда он считал бы сколько всего было продано
    цветов независимо от объекта вызывающего его
    */

    public SellBouquet() {
    }

    public void bouquetArrangement(String flowerName, List<String> list) {
        for (Map.Entry entry : WarehouseFlower.getFlowersStock().entrySet()) {
            if (entry.getKey().equals(flowerName)) {
                Flower flower = (Flower) entry.getValue();
                if (flower.getPurchasedFlowers() > 0) {
                    System.out.println("Сколько роз Вы хотите? В наличии " + flower.getPurchasedFlowers() + " шт.");
                    int quantity = scanner.nextInt();
                    if (quantity <= flower.getPurchasedFlowers()) {
                        flower.restFlower(quantity);
                        count += quantity;
                        list.add(flowerName + " " + "в количестве " + quantity + " шт.");
                        setTotalPrice(getTotalPrice() + quantity * flower.getPrice());
                    } else {
                        System.out.println("у нас столько нет " + entry.getKey());
                    }
                } else {
                    System.out.println("Извините, но " + entry.getKey() + " распроданы!");
                }
            }
        }
    }
    /*
    хотел вынести отдельно свитч, но он у меня закрывает сразу цикл после окончания, так и не получилось остаться в цикле
    пришлось откатить назад, но на всякий случай оставлю идею тут, возможно вы подскажете как остаться в цикле
     */

//    private void caseFlower(int caseNum, FlowerConstants flowerConstants) {
//            if (caseNum >= 1 && caseNum <= 5) {
//                switch (caseNum) {
//                    case 1:
//                        bouquetArrangement(flowerConstants.getROSE(), sellList);
//                        break;
//                    case 2:
//                        bouquetArrangement(flowerConstants.getTULIP(), sellList);
//                        break;
//                    case 3:
//                        bouquetArrangement(flowerConstants.getASTER(), sellList);
//                        break;
//                    case 4:
//                        bouquetArrangement(flowerConstants.getHERBERA(), sellList);
//                        break;
//                    case 5:
//                        System.out.println("Спасибо за покупку!" + "\n");
//                        break;
//                }
//            } else {
//                System.out.println("Вы ввели неверный номер, повторите попытку");
//            }
//    }

    public void order(FlowerConstants flowerConstants) {
        while (true) {
            System.out.println("Выберите цветок:" + "\n" + "1. Роза " + flowerConstants.getPRICEROSE() + " цена за шт." + "\n"
                    + "2. Тюльпан " + flowerConstants.getPRICETULIP() + " цена за шт." + "\n" + "3. Астра "
                    + flowerConstants.getPRICEASTER() + " цена за шт." + "\n" + "4. Гербера "
                    + flowerConstants.getPRICEHERBERA() + " цена за шт." + "\n" + "5. Если Выбор окончен");
            int caseNum = scanner.nextInt();
            if (caseNum >= 1 && caseNum <= 5) {
                switch (caseNum) {
                    case 1:
                        bouquetArrangement(flowerConstants.getROSE(), sellList);
                        continue;
                    case 2:
                        bouquetArrangement(flowerConstants.getTULIP(), sellList);
                        continue;
                    case 3:
                        bouquetArrangement(flowerConstants.getASTER(), sellList);
                        continue;
                    case 4:
                        bouquetArrangement(flowerConstants.getHERBERA(), sellList);
                        continue;
                    case 5:
                        System.out.println("Спасибо за покупку!" + "\n");
                        break;
                }
            } else {
                System.out.println("Вы ввели неверный номер, повторите попытку");
                continue;
            }
            infoBouquet(sellList);
            System.out.println("К оплате: " + getTotalPrice() + " рублей" + "\n");
            System.out.println("Всего приобретено " + count + " цветов" + "\n");
            break;
        }
    }

    private void infoBouquet(List<String> listBouquet) {
        System.out.println("Вы приобрели:");
        for (String flower : listBouquet) {
            System.out.println(flower + "\n");
        }
    }
}
