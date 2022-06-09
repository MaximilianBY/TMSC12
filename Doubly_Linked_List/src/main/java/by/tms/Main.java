package by.tms;

import by.tms.exception.ListException;
import by.tms.model.DoublyLinkedList;

public class Main {

  public static void main(String[] args) throws ListException {
    DoublyLinkedList<Integer> linkedNums = new DoublyLinkedList<>();

    linkedNums.add(1);
    linkedNums.add(2);
    linkedNums.add(10);

    linkedNums.printList(linkedNums.getNode(0));
  }
}