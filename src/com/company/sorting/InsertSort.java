package com.company.sorting;

public class InsertSort extends Sort {

    public InsertSort(int size, boolean fill) {
        super(size, fill);
    }

    protected void sort() {
        int temp;
        int j = 0;
        int length = getBox().length;
        for (int i = 1; i < length; i++) {
            temp = box[i];
            j = i - 1;
            while (j >= 0 && temp < box[j]) {
                box[j+1] = box[j];
                j--;
            }
            box[j+1] = temp;
        }
    }
}
