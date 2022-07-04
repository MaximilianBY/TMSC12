package by.tms.eshop.repositories;

import by.tms.eshop.entities.BaseEntity;
import java.util.Set;

public interface BaseRepository<T extends BaseEntity> {

  Connection pool = Connection.getInstance();

  Set<T> create(T entity) throws Exception;

  Set<T> read() throws Exception;

  Set<T> update(T entity) throws Exception;

  void delete(int id) throws Exception;
}
