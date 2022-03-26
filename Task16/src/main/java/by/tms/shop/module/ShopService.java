package by.tms.shop.module;

import by.tms.shop.exception.InputException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ShopService {

  private List<Product> productList = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public void sortProductPriceList() throws InputException {
    if (!checkProductList()) {
      switch (Integer.parseInt(scanner.nextLine())) {
        case 1:
          Collections.sort(productList, Product.idSorting);
          break;
        case 2:
          Collections.sort(productList, Product.nameSorting);
          break;
        case 3:
          Collections.sort(productList, Product.priceAscending);
          break;
        case 4:
          Collections.sort(productList, Product.priceDescending);
          break;
        case 5:
          Collections.reverse(productList);
          break;
        default:
      }
    }
  }

  public void editProductInList() throws InputException {
    deleteProductFromList();
    addProductFromConsole();
  }

  public void deleteProductFromList() throws InputException {
    int id = Integer.parseInt(scanner.nextLine());
    if (!checkInID(id)) {
      for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext(); ) {
        if (iterator.next().getId() == id) {
          iterator.remove();
        }
      }
    }
  }

  public void addProductToList(Product product) throws InputException {
    boolean isId = false;
    for (Product item : productList) {
      if (checkProductExist(item.getId(), product.getId())) {
        isId = true;
        break;
      }
    }
    if (!isId) {
      productList.add(product);
    } else {
      throw new InputException("Данный товар уже имеется в списке!");
    }
  }

  private boolean checkProductExist(int product, int product1) {
    return product == product1;
  }

  public void addProductFromConsole() throws InputException {
    int newID = Integer.parseInt(scanner.nextLine());
    String newName = scanner.nextLine();
    int newPrice = Integer.parseInt(scanner.nextLine());
    if (!checkInID(newID) && !checkInName(newName) && !checkInPrice(newPrice)) {
      addProductToList(new Product(newID, newName, newPrice));
    }
  }

  private boolean checkInID(int newID) throws InputException {
    if (newID <= 0) {
      throw new InputException("Введено значение меньше нуля!");
    }
    return false;
  }

  private boolean checkInName(String newName) throws InputException {
    if (newName == null || newName.isEmpty() || newName.isBlank()) {
      throw new InputException("Введена пустая строка");
    }
    return false;
  }

  private boolean checkInPrice(int newPrice) throws InputException {
    if (newPrice <= 0) {
      throw new InputException("Введено значение меньше нуля!");
    }
    return false;
  }


  public List<Product> getProductList() throws InputException {
    if (!checkProductList()) {
      return productList;
    } else {
      throw new InputException("Заполните список продуктов для начала");
    }
  }

  private boolean checkProductList() throws InputException {
    if (productList.isEmpty()) {
      throw new InputException("Список продуктов пуст!");
    }
    return false;
  }
}
