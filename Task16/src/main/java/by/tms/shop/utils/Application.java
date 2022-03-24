package by.tms.shop.utils;

import by.tms.shop.exception.InputException;
import by.tms.shop.module.Product;
import by.tms.shop.module.ShopService;
import java.util.List;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass

public final class Application {
  private Scanner scanner = new Scanner(System.in);

  public void start(ShopService shopService) throws InputException {
    boolean isBreak = true;
    while (isBreak) {
      PrintList.messageChooseAction();
      isBreak = chooseAction(shopService);
    }
  }

  private boolean chooseAction(ShopService shopService) throws InputException {
    switch (Integer.parseInt(scanner.nextLine())) {
      case 1:
        PrintList.messageForInputProduct();
        shopService.addProductFromConsole();
        PrintList.printProductList(shopService.getProductList());
        return true;
      case 2:
        PrintList.messageForDelOrEditProduct();
        shopService.editProductInList();
        PrintList.printProductList(shopService.getProductList());
        return true;
      case 3:
        PrintList.messageForDelOrEditProduct();
        PrintList.printProductList(shopService.getProductList());
        shopService.deleteProductFromList();
        PrintList.printProductList(shopService.getProductList());
        return true;
      case 4:
        PrintList.messageForSortProductList();
        shopService.sortProductPriceList();
        PrintList.printProductList(shopService.getProductList());
        return true;
      case 5:
        return false;
    }
    return false;
  }

  @UtilityClass
  private final class PrintList {

    private static void printProductList(List<Product> productList) {
      for (Product item : productList) {
        System.out.println(item.toString());
      }
    }

    private static void messageForInputProduct() {
      System.out.println("""
          Введите данные нового товара в следующем порядке:
          1. ID товара
          2. Наименование товара
          3. Цена товара""");
    }

    private static void messageChooseAction() {
      System.out.println("""
          Выберите, что хотите сделать: 
          1. Добавить продукт в список
          2. Редактировать данные продукта из списка
          3. Удалить продукт из списка
          4. Отсортировать список по выбранному варианту
          5. Закончить выполнение программы""");
    }

    private static void messageForDelOrEditProduct() {
      System.out.println("Введите id товара, который хотите удалить/изменить:");
    }

    private static void messageForSortProductList() {
      System.out.println("""
          Выберите, по какому параметру сортировать:
          1. Сортировка по ID
          2. Сортировка по наименованию
          3. Сортировка по цене по возрастанию
          4. Сортировка по цене по убыванию
          5. Сортировка начиная с последних добавленных""");
    }
  }
}
