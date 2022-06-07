package by.tms.services;

import by.tms.entities.BaseEntity;
import java.util.Map;

public interface BaseService<T extends BaseEntity> {

  void create(T entity);

  Map<Integer, T> read();

  T update(T entity);

  void delete(int id);
}
