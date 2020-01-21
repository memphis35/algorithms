package com.company.sorting;

public class BubbleSort extends Sort {

    public BubbleSort(int size, boolean fill) {
        super(size, fill);
    }

    @Override
    protected void sort() {
        int temp;
        int length = getBox().length;
        boolean isSwap = true;
        while (isSwap) {
            isSwap = false;
            for (int i = 0; i < length - 1; i++) {
                if (box[i] > box[i + 1]) {
                    temp = box[i];
                    box[i] = box[i + 1];
                    box[i + 1] = temp;
                    isSwap = true;
                }
            }
        }
    }
}
