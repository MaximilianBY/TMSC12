package by.tms.repositories.impl;

import by.tms.entities.User;
import by.tms.repositories.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class UserRepositoryImpl implements UserRepository {

  private static final String GET_ALL_USERS = "SELECT * FROM eshop.user";
  private static final String ADD_NEW_USER = "INSERT INTO eshop.user(login, user_name, surname, birthday, email, phone_number, password) value (?, ?, ?, ?, ?, ?, ?)";
  private static final String UPDATE_USER_DATA = "UPDATE eshop.user SET user_name=?, surname=?, birthday=?, email=?, phone_number=?, password=? WHERE id=?";
  private static final String DELETE_USER = "DELETE FROM eshop.user WHERE id=?";
  private static final String GET_USER_ID = "SELECT eshop.user.id FROM eshop.user WHERE login=?";
  private static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM eshop.user WHERE login=? AND password=?";

  @Override
  public Map<Integer, User> create(User user) {
    Map<Integer, User> userList = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement addUser = connection.prepareStatement(ADD_NEW_USER);

      addUser.setString(1, user.getLogin());
      addUser.setString(2, user.getName());
      addUser.setString(3, user.getSurname());
      addUser.setString(4, user.getBirthday());
      addUser.setString(5, user.getEmail());
      addUser.setString(6, user.getPhoneNumber());
      addUser.setString(7, user.getPassword());

      addUser.executeUpdate();

      userList = read();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return userList;
  }

  @Override
  public Map<Integer, User> read() {
    Map<Integer, User> userList = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getUsers = connection.prepareStatement(GET_ALL_USERS);
      ResultSet rs = getUsers.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String login = rs.getString("login");
        String name = rs.getString("user_name");
        String surname = rs.getString("surname");
        String birthday = rs.getString("birthday");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phone_number");
        String password = rs.getString("password");
        userList.put(id, User.builder()
            .id(id)
            .login(login)
            .name(name)
            .surname(surname)
            .birthday(birthday)
            .email(email)
            .phoneNumber(phoneNumber)
            .password(password)
            .build());
      }
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
    return userList;
  }

  @Override
  public Map<Integer, User> update(User user) {
    Map<Integer, User> userList = new HashMap<>();
    try (Connection connection = pool.getConnection()) {
      PreparedStatement updateUser = connection.prepareStatement(UPDATE_USER_DATA);

      updateUser.setString(1, user.getName());
      updateUser.setString(2, user.getSurname());
      updateUser.setString(3, user.getBirthday());
      updateUser.setString(4, user.getEmail());
      updateUser.setString(5, user.getPhoneNumber());
      updateUser.setString(6, user.getPassword());
      updateUser.setInt(7, user.getId());

      updateUser.executeUpdate();

      userList = read();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return userList;
  }

  @Override
  public void delete(int id) {
    try (Connection connection = pool.getConnection()) {
      PreparedStatement deleteUser = connection.prepareStatement(DELETE_USER);

      deleteUser.setInt(1, id);

      deleteUser.execute();

    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public int getUserIDByLogin(String login) {
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getUserID = connection.prepareStatement(GET_USER_ID);
      getUserID.setString(1, login);
      ResultSet rs = getUserID.executeQuery();

      if (rs.next()) {
        return rs.getInt("id");
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return 0;
  }

  @Override
  public User findByLoginAndPassword(String login, String password) {
    User user = null;
    try (Connection connection = pool.getConnection()) {
      PreparedStatement getUser = connection.prepareStatement(GET_USER_BY_LOGIN_AND_PASSWORD);
      getUser.setString(1, login);
      getUser.setString(2, password);
      ResultSet rs = getUser.executeQuery();

      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("user_name");
        String surname = rs.getString("surname");
        String birthday = rs.getString("birthday");
        String email = rs.getString("email");
        String phoneNumber = rs.getString("phone_number");
        user = User.builder()
            .id(id)
            .login(login)
            .name(name)
            .surname(surname)
            .birthday(birthday)
            .email(email)
            .phoneNumber(phoneNumber)
            .password(password)
            .build();
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return user;
  }
}
