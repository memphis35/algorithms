package com.company.linkedlist;

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

    public static void main(String[] args) {
        DoubleSidedLinkList example = new DoubleSidedLinkList();
        example.insertLast("Shaun");
        example.insertFirst("Mike");
        example.insertFirst("Fiona");
        example.insertLast("Alex");
        example.display();
    }
}
