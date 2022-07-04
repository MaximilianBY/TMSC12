package by.tms.eshop.services;

import by.tms.eshop.entities.BaseEntity;
import java.util.Set;

public interface BaseService<T extends BaseEntity> {

  void create(T entity) throws Exception;

  Set<T> read() throws Exception;

  T update(T entity) throws Exception;

  void delete(int id) throws Exception;
}
