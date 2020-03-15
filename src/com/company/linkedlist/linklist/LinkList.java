package com.company.linkedlist.linklist;

import com.company.exceptions.EmptyListException;
import com.company.exceptions.NotExistException;

public class LinkList implements LinkListInterface {

    public Link first = null;

    public Link getFirst() {
        return first;
    }

    public void insert(String data) {
        Link newElement = new Link(data);
        newElement.next = first;
        first = newElement;
    }

    public Link delete() throws EmptyListException {
        Link result = first;
        if (!isEmpty()) {
            first = first.next;
            return result;
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
        throw new NotExistException("Element not found.");
    }

    private void delete(String key) throws NotExistException {

    }

    protected boolean isEmpty() {
        return first == null;
    }

    public void clear() {
        while (first != null) {
            delete();
        }
    }

    /*public static void main(String[] args) {
        LinkList example = new SortedLinkList();
        example.insert("Mike");
        example.insert("Alex");
        example.insert("Fiona");
        example.insert("Shaun");
        example.display();
        example.delete("Alex");
        example.display();

    }*/
}
