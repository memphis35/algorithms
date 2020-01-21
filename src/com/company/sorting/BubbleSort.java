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

    /**
     * 3.1. В программе bubbleSort.java индекс in всегда перемещается слева направо, находит наибольший
     * элемент и перемещает его к позиции out справа. Измените метод bubbleSort() так, чтобы в нем выполнялись
     * двусторонние перемещения, иначе говоря, индекс in сначала, как и прежде, переносит наибольший элемент слева
     * направо, но затем он меняет направление и переносит наименьший элемент справа налево. Вам понадобятся
     * два внешних индекса: справа (старый индекс out) и слева.
     */

    public void bubbleSort() { // взят из книги
        int out, in;
        for (out = getBox().length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (box[in] > box[in + 1]) {
                    swap(in, in + 1);
                }
            }
            for (in = out; in > 0; in--) {
                if (box[in] <= box[in - 1]) {
                    swap(in, in - 1);
                }
            }
        }
    }

    private void swap(int one, int two) {
        int temp = box[one];
        box[one] = box[two];
        box[two] = temp;
    }
}

