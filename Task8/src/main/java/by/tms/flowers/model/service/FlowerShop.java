package by.tms.flowers.model.service;

import by.tms.flowers.model.constants.FlowerConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {

  private Florist florist;
  private Scanner scanner = new Scanner(System.in);

  public FlowerShop(Florist florist) {
    this.florist = florist;
  }

  private void greetings() {
    System.out.println("Из каких цветов собрать Вам букет?:" + "\n" +
        "1. Роза " + FlowerConstants.PRICE_ROSE + " цена за шт." + "\n" +
        "2. Тюльпан " + FlowerConstants.PRICE_TULIP + " цена за шт." + "\n" +
        "3. Астра " + FlowerConstants.PRICE_ASTER + " цена за шт." + "\n" +
        "4. Гербера " + FlowerConstants.PRICE_HERBERA + " цена за шт." + "\n" +
        "5. Если Выбор окончен");
  }

  public void order() {
    System.out.println("Добрый день!");
    List<String> sellList = new ArrayList<>();
    florist.setCount(0);
    florist.setTotalPrice(0);
    while (true) {
      greetings();
      int caseNum = scanner.nextInt();
      if (caseNum >= 1 && caseNum <= 5) {
        switch (caseNum) {
          case 1:
            florist.arrangementBouquet(FlowerConstants.ROSE, sellList);
            continue;
          case 2:
            florist.arrangementBouquet(FlowerConstants.TULIP, sellList);
            continue;
          case 3:
            florist.arrangementBouquet(FlowerConstants.ASTER, sellList);
            continue;
          case 4:
            florist.arrangementBouquet(FlowerConstants.HERBERA, sellList);
            continue;
          case 5:
            System.out.println("Спасибо за покупку!" + "\n");
            break;
        }
      } else {
        System.out.println("Вы ввели неверный номер, повторите попытку");
        continue;
      }
      florist.infoBouquet(sellList);
      System.out.println("К оплате: " + florist.getTotalPrice() + " рублей" + "\n");
      System.out.println("Всего приобретено " + florist.getCount() + " цветов" + "\n");
      break;
    }
  }
}
