package by.tms.repositories;

import by.tms.entities.BaseEntity;
import java.util.Map;

public interface BaseRepository<T extends BaseEntity> {

  Connection pool = Connection.getInstance();

  Map<Integer, T> create(T entity);

  Map<Integer, T> read();

  Map<Integer, T> update(T entity);

  void delete(int id);
}
