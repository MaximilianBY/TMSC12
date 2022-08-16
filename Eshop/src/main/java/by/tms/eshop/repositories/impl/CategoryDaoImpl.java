package by.tms.eshop.repositories.impl;

import by.tms.eshop.dto.CategoryDto;
import by.tms.eshop.entities.Category;
import by.tms.eshop.repositories.CategoryDao;
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
public class CategoryDaoImpl implements CategoryDao {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Set<CategoryDto> getAllCategories() {
    return new HashSet<>(entityManager.createQuery("select c from Category c")
        .getResultList());
  }

  @Override
  public Category findById(int id) {
    return entityManager.getReference(Category.class, id);
  }

  @Override
  public Category findByName(String name) {
    Query query = entityManager.createQuery("select c from Category c where c.name=:name");
    query.setParameter("name", name);
    return (Category) query.getSingleResult();
  }

  @Override
  public Category createCategory(Category category) {
    entityManager.persist(category);
    return category;
  }
}
