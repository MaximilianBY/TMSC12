package by.tms.utils;

import static by.tms.utils.CommandsEnum.SIGN_IN_COMMAND;

import by.tms.commands.AccountCommandPageImpl;
import by.tms.commands.ActionWithUserCartCommandPageImpl;
import by.tms.commands.AddProductToCartCommandPageImpl;
import by.tms.commands.AllCategoryCommandPageImpl;
import by.tms.commands.AuthorCommandPageImpl;
import by.tms.commands.BaseCommand;
import by.tms.commands.DevicesByCategoryCommandPageImpl;
import by.tms.commands.ProductCommandPageImpl;
import by.tms.commands.RegistrationCommandPageImpl;
import by.tms.commands.SearchProductCommandPageImpl;
import by.tms.commands.SignInCommandPageImpl;
import by.tms.commands.UserCartCommandPageImpl;
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
    COMMAND_LIST.put(SIGN_IN_COMMAND.getCommand(), new SignInCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.REGISTRATION_COMMAND.getCommand(),
        new RegistrationCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.HOME_COMMAND.getCommand(), new AuthorCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.ACCOUNT_COMMAND.getCommand(), new AccountCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.CATEGORY_COMMAND.getCommand(), new AllCategoryCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.DEVICES_COMMAND.getCommand(),
        new DevicesByCategoryCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.REDIRECT_PRODUCT_COMMAND.getCommand(),
        new ProductCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.ADD_PRODUCT_TO_CART_COMMAND.getCommand(),
        new AddProductToCartCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND.getCommand(),
        new UserCartCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.ACTION_SHOPPING_CART_COMMAND.getCommand(),
        new ActionWithUserCartCommandPageImpl());
    COMMAND_LIST.put(CommandsEnum.SEARCH_PRODUCT.getCommand(), new SearchProductCommandPageImpl());
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
