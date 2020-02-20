package com.company.linkedlist;

import com.company.exceptions.EmptyListException;
import com.company.exceptions.NotExistException;

public class LinkList {

    public Link first;

    public void insertFirst(String data) {
        Link newElement = new Link(data);
        newElement.next = first;
        first = newElement;
    }

    public void deleteFirst() throws EmptyListException {
        if (!isEmpty()) {
            first = first.next;
        } else {
            throw new EmptyListException("Empty list.");
        }
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.print(System.lineSeparator());
    }

    public Link find(String key) throws NotExistException {
        Link keyLink = new Link(key);
        Link temp = first;
        if (!isEmpty()) {
            while (temp != null) {
                if (temp.equals(keyLink)) {
                    break;
                }
                temp = temp.next;
            }
        }
        if (temp != null) {
            System.out.println("Found element: " + temp.getData());
            return temp;
        } else {
            throw new NotExistException("Element not found.");
        }
    }

    public void delete(String key) {
        Link current = first;
        Link previous = first;
        while (current != null && !current.getData().equals(key)) {
            previous = current;
            current = current.next;
            }
        if (current == null) throw new NotExistException("Element not found.");
        if (current.equals(first)) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
    }

    boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        LinkList example = new LinkList();
        example.insertFirst("Mike");
        example.insertFirst("Shaun");
        example.insertFirst("Fiona");
        example.insertFirst("Alex");
        example.display();
        example.delete("Alex");
        example.display();

    }
}
