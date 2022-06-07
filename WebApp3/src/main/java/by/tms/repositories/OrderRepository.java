package by.tms.repositories;

import by.tms.entities.Order;
import by.tms.entities.Product;
import java.util.Map;

public interface OrderRepository extends BaseRepository<Order> {

  Map<Integer, Order> getUserOrdersFromRepository(int userID);

  Map<Integer, Order> addNewUserOrder(int userID, Product product);
}
