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
        newElement.setNext(first);
        first = newElement;
    }

    public Link delete() throws EmptyListException {
        Link result = first;
        if (!isEmpty()) {
            first = first.getNext();
            return result;
        } else {
            throw new EmptyListException("Empty list.");
        }
    }

    public void display() {
        Link current = first;
        while (current != null) {
            current.displayLink();
            current = current.getNext();
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
}
