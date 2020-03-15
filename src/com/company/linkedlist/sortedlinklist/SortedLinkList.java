package com.company.linkedlist.sortedlinklist;

import com.company.linkedlist.iterator.LinkListIterator;
import com.company.linkedlist.linklist.Link;
import com.company.linkedlist.linklist.LinkList;

public class SortedLinkList extends LinkList {

    public SortedLinkList() {
        super();
    }

    @Override
    public void insert(String data) {
        if (isEmpty()) {
            super.insert(data);
        } else {
            Link element = new Link(data);
            Link current = this.first;
            Link previous = this.first;
            while (current != null && data.compareTo(current.getData()) >= 0) {
                previous = current;
                current = current.next;
            }
            if (current == null) {
                previous.next = element;
            } else if (current.equals(this.first)) {
                element.next = first;
                first = element;
            } else {
                element.next = current;
                previous.next = element;
            }
        }
    }
}
