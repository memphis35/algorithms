package com.company.sorting;

public class SelectSort extends Sort {

    public SelectSort(int size, boolean fill) {
        super(size, fill);
    }

    @Override
    protected void sort() {
        int temp;
        int min;
        int index;
        int length = getBox().length;
        for (int i = 0; i < length; i++) {
            min = box[i];
            index = -1;
            for (int j = i + 1; j < length; j++) {
                if (min > box[j]) {
                    min = box[j];
                    index = j;
                }
            }
            if (index >= 0) {
                temp = box[i];
                box[i] = box[index];
                box[index] = temp;
            }

        }
    }


}
