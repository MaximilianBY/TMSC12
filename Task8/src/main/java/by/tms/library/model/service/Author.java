package by.tms.library.model.service;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Author {

  private String name;
  private String book;

  public Author(String name, String book) {
    this.name = name;
    this.book = book;
  }

  public String getTitle() {
    return "Автор: " + getName() + ". Название: " + getBook();
  }
}
