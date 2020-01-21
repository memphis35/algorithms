package com.company.sorting;

import java.util.Arrays;

public abstract class Sort {

    int[] box;

    public Sort(int size, boolean fill) {
        this.box = new int[size];
        if (fill) fillRandom();
    }

    void setBox(int[] newBox) {
        box = newBox;
    }

    int[] getBox() {
        return box;
    }

    private void fillRandom() {
        for (int i = 0; i < box.length; i++) {
            box[i] = (int) (Math.random() * 100.0);
        }
    }

    void display() {
        System.out.println(Arrays.toString(box));
    }

    protected abstract void sort();
}
