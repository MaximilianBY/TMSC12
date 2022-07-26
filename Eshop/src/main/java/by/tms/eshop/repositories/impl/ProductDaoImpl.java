package by.tms.eshop.repositories.impl;

import by.tms.eshop.entities.Product;
import by.tms.eshop.repositories.ProductDao;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Transactional
@Repository
public class ProductDaoImpl implements ProductDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Set<Product> getAllProducts() {
    Query products = entityManager.createQuery(
        "select u from Product u where u.quantity >0");
    return new HashSet<>(products.getResultList());
  }

  @Override
  public Set<Product> getProductsByCategory(int categoryId) {
    Query products = entityManager.createQuery(
        "select u from Product u where u.category.id=:categoryId and u.quantity >0");
    products.setParameter("categoryId", categoryId);
    log.info(products.getResultList().toString());
    return new HashSet<>(products.getResultList());
  }

  @Override
  public Product getProductById(int productId) {
    Query product = entityManager.createQuery(
        "select u from Product u where u.id=:productId");
    product.setParameter("productId", productId);
    return (Product) product.getSingleResult();
  }

  @Override
  public Set<Product> searchProducts(String[] searchArray) {
    Set<Product> products = new HashSet<>();

    for (Product product : getAllProducts()) {
      int count = 0;
      for (String request : searchArray) {
        if (product.getBrand().toLowerCase().contains(request.toLowerCase()) || product.getModel()
            .toLowerCase().contains(request.toLowerCase())) {
          count++;
        }
        if (count >= searchArray.length) {
          products.add(product);
        }
      }
    }
    return products;
  }

  @Override
  public void updateProductQuantity(Product entity) {
    Product product = entityManager.find(Product.class, entity.getId());
    product.setQuantity(product.getQuantity() - entity.getQuantity());
    entityManager.merge(product);
  }
}