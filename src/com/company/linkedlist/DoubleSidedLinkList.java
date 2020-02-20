package com.company.linkedlist;

import com.company.exceptions.EmptyListException;

public class DoubleSidedLinkList extends LinkList {
    private Link last;

    @Override
    public void insertFirst(String data) {
        Link newElement = new Link(data);
        if (isEmpty()) {
            last = newElement;
        }
        newElement.next = first;
        first = newElement;
    }

    public void insertLast(String data) {
        if (isEmpty()) {
            insertFirst(data);
        } else {
            Link newElement = new Link(data);
            last.next = newElement;
            last = newElement;
        }
    }
    @Override
    public void deleteFirst() throws EmptyListException {
        if (!isEmpty()) {
            first = first.next;
            if(isEmpty()) {
                last = null;
            }
        } else {
            throw new EmptyListException("Empty list.");
        }
    }

    public static void main(String[] args) {
        DoubleSidedLinkList example = new DoubleSidedLinkList();
        example.insertLast("Shaun");
        example.insertFirst("Mike");
        example.insertFirst("Fiona");
        example.insertLast("Alex");
        example.display();
    }
}
