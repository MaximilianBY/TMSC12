package by.tms.eshop.repositories;

import by.tms.eshop.entities.User;

public interface UserRepository extends BaseRepository<User> {

  int getUserIDByLogin(String login) throws Exception;

  User getUserByLogin(String login) throws Exception;
}
