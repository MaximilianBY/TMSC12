package by.tms.shop.utils;

import by.tms.shop.module.Product;
import by.tms.shop.module.Shop;
import java.util.List;
import java.util.Scanner;
import lombok.experimental.UtilityClass;

@UtilityClass

public final class Application {

  private Scanner scanner = new Scanner(System.in);

  public void start(Shop shop) throws Malfunction {
    boolean isBreak = true;
    while (isBreak) {
      PrintList.messageChooseAction();
      isBreak = chooseAction(shop);
    }
  }

  private boolean chooseAction(Shop shop) throws Malfunction {
    switch (Integer.parseInt(scanner.nextLine())) {
      case 1:
        PrintList.messageForInputProduct();
        shop.addProductFromConsole();
        PrintList.printProductList(shop.getProductList());
        return true;
      case 2:
        PrintList.messageForDelOrEditProduct();
        shop.editProductInList();
        PrintList.printProductList(shop.getProductList());
        return true;
      case 3:
        PrintList.messageForDelOrEditProduct();
        shop.deleteProductFromList();
        PrintList.printProductList(shop.getProductList());
        return true;
      case 4:
        PrintList.messageForSortProductList();
        shop.sortProductPriceList();
        PrintList.printProductList(shop.getProductList());
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
