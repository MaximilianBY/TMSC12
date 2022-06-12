package by.tms.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node<T> {

  /**
   * создали нод с дженериком для работы с любым типом данных. прописали поля data, next, front data
   * - объект, который мы записываем в узел next - ссылка на следующий элемент в списке front -
   * ссылка на 1-й передний элемент после указанного
   */
  private T data;
  private Node next;
  private Node front;

  public Node(T data) {
    this.data = data;
  }
}
