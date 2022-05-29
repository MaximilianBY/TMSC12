package by.tms.utils;

import static by.tms.utils.CommandsEnum.SIGN_IN_COMMAND;

import by.tms.commands.AccountPage;
import by.tms.commands.ActionWithUserCart;
import by.tms.commands.AddProductToCart;
import by.tms.commands.AllCategoryPage;
import by.tms.commands.AuthorPage;
import by.tms.commands.BaseCommand;
import by.tms.commands.DevicesByCategoryPage;
import by.tms.commands.ProductPage;
import by.tms.commands.RegistrationPage;
import by.tms.commands.SignInPage;
import by.tms.commands.UserCartPage;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;

public class CommandFactory {

  private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

  /**
   * заполняем мапу, где ключ стринговая переменная Enum,
   * а значение - создается новый экземпляр объекта, класс которого реализует интерфейс BaseCommand
   * */

  static {
    COMMAND_LIST.put(SIGN_IN_COMMAND.getCommand(), new SignInPage());
    COMMAND_LIST.put(CommandsEnum.REGISTRATION_COMMAND.getCommand(),
        new RegistrationPage());
    COMMAND_LIST.put(CommandsEnum.HOME_COMMAND.getCommand(), new AuthorPage());
    COMMAND_LIST.put(CommandsEnum.ACCOUNT_COMMAND.getCommand(), new AccountPage());
    COMMAND_LIST.put(CommandsEnum.CATEGORY_COMMAND.getCommand(), new AllCategoryPage());
    COMMAND_LIST.put(CommandsEnum.DEVICES_COMMAND.getCommand(), new DevicesByCategoryPage());
    COMMAND_LIST.put(CommandsEnum.REDIRECT_PRODUCT_COMMAND.getCommand(), new ProductPage());
    COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART_COMMAND.getCommand(), new AddProductToCart());
    COMMAND_LIST.put(CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND.getCommand(), new UserCartPage());
    COMMAND_LIST.put(CommandsEnum.ACTION_SHOPPING_CART_COMMAND.getCommand(),
        new ActionWithUserCart());
  }

  /**
   * @defineCommand получаем параметр из запроса проверяем если параметр существовал, то он
   * записался в переменную и тогда просто возврат объекта по ключу enum, в случае несуществования
   * параметра из запроса, мы передаем в переменую стартовый объект по ключу enum. возврат объекта,
   * который имплементит интерфейс BaseCommand
   */

  public static BaseCommand defineCommand(HttpServletRequest request) {
    String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
    if (Optional.ofNullable(commandKey).isEmpty()) {
      commandKey = SIGN_IN_COMMAND.getCommand();
    }
    return COMMAND_LIST.get(commandKey);
  }
}
