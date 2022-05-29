package by.tms.commands;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

  String execute(HttpServletRequest request) throws Exception;
}
