package by.tms.model;

import by.tms.exception.ListException;
import java.util.Optional;

public class DoublyLinkedList<T> {

  private Node head;
  private Node tail;
  private int count;

  public void add(T data) {
    Node node = new Node(data);
    if (Optional.ofNullable(head).isEmpty()) {
      head = node;
    } else {
      tail.setNext(node);
      node.setFront(tail);
    }
    tail = node;
    count++;
  }

  public Node getNode(int index) throws ListException {
    if (index < 0 || index >= size()) {
      throw new ListException("Index out of bound");
    }
    int num = 0;
    Node node = head;
    while (Optional.ofNullable(node).isPresent()) {
      if (num == index) {
        break;
      }
      num++;
      node = node.getNext();
    }
    return node;
  }

  public T get(int index) throws ListException {
    if (index < 0 || index >= size()) {
      throw new ListException("Index out of bound");
    }
    int num = 0;
    Node node = head;
    while (Optional.ofNullable(node).isPresent()) {
      if (num == index) {
        break;
      }
      num++;
      node = node.getNext();
    }
    T data = (T) node.getData();
    return data;
  }

  public Node getNode(T data) throws ListException {
    int num = 0;
    T dataHead = (T) head.getData();
    if (data == dataHead) {
      Node node = getNode(num);
      return head;
    } else {
      num = 1;
      dataHead = get(num);
      while (dataHead.equals(data)) {
        if (dataHead.equals(data)) {
          break;
        }
        num++;
        dataHead = get(num);
      }
    }
    Node node = getNode(num);
    return node;
  }

  public void add(T data, int index) throws ListException {
    if (index < 0 || index >= size()) {
      throw new ListException("Index out of bound");
    }
    int num = 0;
    Node node = head;
    while (Optional.ofNullable(node).isPresent()) {
      if (num == index) {
        break;
      }
      num++;
      node = node.getNext();
    }
    Node node1 = new Node(data);
    if (node.equals(tail)) {
      node.setNext(node1);
      node1.setFront(node);
      tail = node1;
    } else {
      node1.setNext(node.getNext());
      node.getNext().setFront(node1);
      node.setNext(node1);
      node1.setFront(node);
    }
    count++;
  }

  public void delete(int index) throws ListException {
    Node node = getNode(index);
    if (node.equals(tail)) {
      node.getFront().setNext(null);
    } else {
      node.getFront().setNext(node.getNext());
      node.getNext().setFront(node.getFront());
    }
    count--;
  }

  public void delete(T data) throws ListException {
    Node node = getNode(data);
    if (node.equals(tail)) {
      node.getFront().setNext(null);
    } else {
      node.getFront().setNext(node.getNext());
      node.getNext().setFront(node.getFront());
    }
    count--;
  }

  public void printList(Node node) {
    if (Optional.ofNullable(node).isPresent()) {
      T data = (T) node.getData();
      System.out.println(data);
      printList(node.getNext());
    }
  }

  public int size() {
    return count;
  }
}
