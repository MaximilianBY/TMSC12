package by.tms.commands;

import by.tms.exceptions.CommandException;
import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

  String execute(HttpServletRequest request) throws CommandException;
}
