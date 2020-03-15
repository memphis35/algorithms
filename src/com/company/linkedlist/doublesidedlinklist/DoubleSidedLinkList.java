package com.company.linkedlist.doublesidedlinklist;

import com.company.exceptions.EmptyListException;
import com.company.linkedlist.linklist.Link;
import com.company.linkedlist.linklist.LinkList;

public class DoubleSidedLinkList extends LinkList {
    private Link last;

    public Link getLast() {
        return last;
    }

    @Override
    public void insert(String data) {
        Link newElement = new Link(data);
        if (isEmpty()) {
            last = newElement;
        }
        newElement.next = first;
        first = newElement;
    }

    public void insertLast(String data) {
        if (isEmpty()) {
            insert(data);
        } else {
            Link newElement = new Link(data);
            last.next = newElement;
            last = newElement;
        }
    }

    @Override
    public Link delete() throws EmptyListException {
        Link result = first;
        if (!isEmpty()) {
            first = first.next;
            if (isEmpty()) {
                last = null;
            }
            return result;
        } else {
            throw new EmptyListException("Empty list.");
        }
    }

    public Link deleteLast() throws EmptyListException {
        Link current = first;
        Link previous = first;
        while (current.next != null) {
            previous = current;
            current = current.next;
        }
        Link result = current;
        if (current.equals(first)) {
            delete();
        } else {
            last = previous;
            previous.next = null;
        }
        return result;
    }
}
