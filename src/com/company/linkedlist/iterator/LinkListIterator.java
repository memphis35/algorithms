package com.company.linkedlist.iterator;

import com.company.linkedlist.linklist.Link;
import com.company.linkedlist.linklist.LinkListInterface;

public class LinkListIterator {

    private LinkListInterface list;
    private Link current;
    private Link previous;

    public LinkListIterator(LinkListInterface list) {
        this.list = list;
        current = list.getFirst();
        previous = list.getFirst();
    }

    public boolean hasNext() {
        return current.getNext() != null;
    }

    public Link next() {
        previous = current;
        current = current.getNext();
        return current;
    }
}
