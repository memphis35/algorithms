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

    /**
     * 3.2. Добавьте в класс ArrayIns программы insertSort.java (листинг 3.3) метод с именем median(), возвращающий
     * медиану массива. (Напомним, что в группе чисел половина меньше медианы, а другая половина больше.)
     * Найдите простое решение этой задачи.
     */

    protected int median() {
        sort();
        display();
        int l = box.length;
        return l % 2 != 0 ? box[(l-1)/2] : (box[l/2] + box[(l/2) - 1]) / 2;
    }
}
