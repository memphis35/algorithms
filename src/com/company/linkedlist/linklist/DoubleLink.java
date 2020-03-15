package com.company.linkedlist.linklist;

import com.company.linkedlist.linklist.Link;

public class DoubleLink extends Link {

    public Link previous;

    public DoubleLink(String data) {
        super(data);
        previous = null;
    }
}
