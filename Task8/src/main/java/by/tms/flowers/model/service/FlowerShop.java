package by.tms.flowers.model.service;

import by.tms.flowers.model.constants.FlowerConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlowerShop {

  private Florist florist;
  private Scanner scanner = new Scanner(System.in);
  private boolean isFinished;

  public FlowerShop(Florist florist) {
    this.florist = florist;
  }

  public void order() {
    System.out.println("Добрый день!");
    List<String> sellList = new ArrayList<>();
    isFinished = true;
    while (isFinished) {
      FlowerConstants.greetings();
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
      System.out.println("Всего приобретено " + florist.getFlowerCounter() + " цветов" + "\n");
      break;
    }
  }
}
