package by.tms.eshop.repositories;

import by.tms.eshop.entities.Order;
import by.tms.eshop.entities.Product;
import java.util.Set;

public interface OrderRepository extends BaseRepository<Order> {

  Set<Order> getUserOrdersFromRepository(int userID) throws Exception;

  Set<Order> addNewUserOrder(int userID, Product product) throws Exception;
}
