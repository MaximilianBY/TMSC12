package by.tms.repositories;

import by.tms.entities.User;

public interface UserRepository extends BaseRepository<User> {

  int getUserIDByLogin(String login);

  User findByLoginAndPassword(String login, String password);
}
