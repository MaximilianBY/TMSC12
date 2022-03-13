package by.tms.shop.module;

import by.tms.shop.utils.Malfunction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Shop {

  private List<Product> productList = new ArrayList<>();
  private Scanner inData = new Scanner(System.in);

  public void sortProductPriceList() throws Malfunction {
    if (!checkProductList()) {
      switch (Integer.parseInt(inData.nextLine())) {
        case 1:
          Collections.sort(productList, Product.IDSorting);
          break;
        case 2:
          Collections.sort(productList, Product.NameSorting);
          break;
        case 3:
          Collections.sort(productList, Product.PriceAscending);
          break;
        case 4:
          Collections.sort(productList, Product.PriceDescending);
          break;
        case 5:
          Collections.reverse(productList);
          break;
        default:
      }
    } else {
      throw new Malfunction("Список продуктов пуст");
    }
  }

  public void editProductInList() throws Malfunction {
    deleteProductFromList();
    addProductFromConsole();
  }

  public void deleteProductFromList() throws Malfunction {
    int id = Integer.parseInt(inData.nextLine());
    if (!checkInID(id)) {
      for (Iterator<Product> iterator = productList.iterator(); iterator.hasNext(); ) {
        if (iterator.next().getId() == id) {
          iterator.remove();
        }
      }
    }
  }

  public void addProductToList(Product product) throws Malfunction {
    boolean isId = false;
    for (Product item : productList) {
      if (item.getId() == product.getId()) {
        isId = true;
      }
    }
    if (!isId) {
      productList.add(product);
    } else {
      throw new Malfunction("Данный товар уже имеется в списке!");
    }
  }

  public void addProductFromConsole() throws Malfunction {
    int newID = Integer.parseInt(inData.nextLine());
    String newName = inData.nextLine();
    int newPrice = Integer.parseInt(inData.nextLine());
    if (!checkInID(newID) && !checkInName(newName) && !checkInPrice(newPrice)) {
      addProductToList(new Product(newID, newName, newPrice));
    }
  }

  private boolean checkInID(int newID) throws Malfunction {
    if (newID <= 0) {
      throw new Malfunction("Введено значение меньше нуля!");
    }
    return false;
  }

  private boolean checkInName(String newName) throws Malfunction {
    if (newName == null || newName.isEmpty() || newName.isBlank()) {
      throw new Malfunction("Введена пустая строка");
    }
    return false;
  }

  private boolean checkInPrice(int newPrice) throws Malfunction {
    if (newPrice <= 0) {
      throw new Malfunction("Введено значение меньше нуля!");
    }
    return false;
  }


  public List<Product> getProductList() throws Malfunction {
    if (!checkProductList()) {
      return productList;
    } else {
      throw new Malfunction("Заполните список продуктов для начала");
    }
  }

  private boolean checkProductList() throws Malfunction {
    if (productList.isEmpty()) {
      throw new Malfunction("Список продуктов пуст!");
    }
    return false;
  }
}
