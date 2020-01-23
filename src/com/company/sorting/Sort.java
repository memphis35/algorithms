package com.company.sorting;

import java.util.Arrays;

public abstract class Sort {

    int[] box;

    Sort(int size, boolean fill) {
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
        int random;
        for (int i = 0; i < box.length; i++) {
            random = (int) (Math.random() * 1000000.0);
            if (!checkDups(random)) {
                box[i] = random;
            } else {
                i--;
            }
        }
    }

    private boolean checkDups(int number) {
        boolean duplicate = false;
        for (int i = 0; i < box.length; i++) {
            if (box[i] == number) {
                duplicate = true;
                break;
            }
        }
        return duplicate;
    }

    void display() {
        System.out.println(Arrays.toString(box));
    }

    boolean checkSortNoDups() {
        boolean areSorted = true;
        for (int i = 0; i < box.length - 1; i++) {
            if (box[i+1] <= box[i]) {
                areSorted = false;
                break;
            }
        }
        return areSorted;
    }

    boolean checkSortDups() {
        boolean areSorted = true;
        for (int i = 0; i < box.length - 1; i++) {
            if (box[i+1] < box[i]) {
                areSorted = false;
                break;
            }
        }
        return areSorted;
    }



    protected abstract void sort();
}
