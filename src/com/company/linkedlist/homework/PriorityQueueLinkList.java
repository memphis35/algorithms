package com.company.linkedlist.homework;

import com.company.linkedlist.sortedlinklist.SortedLinkList;
import com.company.linkedlist.linklist.LinkList;

/**
 * @homework 5.1. Реализуйте приоритетную очередь на базе сортированного связанного
 * списка. Операция извлечения из приоритетной очереди должна извлекать элемент
 * с наименьшим ключом.
 */

public class PriorityQueueLinkList {

    LinkList queue;

    public PriorityQueueLinkList() {
        queue = new SortedLinkList();
    }

    public void insert(String data) {
        queue.insert(data);
    }

    public void remove() {
        queue.delete();
    }

    public String peek() {
        return queue.first.getData();
    }

    public void display() {
        queue.display();
    }

    public static void main(String[] args) {
        PriorityQueueLinkList test = new PriorityQueueLinkList();
        test.insert("2. This must be second");
        test.insert("1. This must be first");
        test.insert("6. This must be last");
        test.insert("3. This must be third");
        test.insert("5. This must be fourth");
        test.display();
        while (test.queue.first != null) {
            System.out.println("Deleting " + test.peek().substring(0, 1));
            test.remove();
            test.display();
        }

    }
}
