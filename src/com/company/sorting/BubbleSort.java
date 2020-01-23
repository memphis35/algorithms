package com.company.sorting;

public class BubbleSort extends Sort {

    BubbleSort(int size, boolean fill) {
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

    void bubbleSort() { // взят из книги
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

    /**
     * 3.4. Еще один простой алгоритм сортировки — сортировка методом четно-нечетных перестановок —
     * основан на многократном выполнении двух проходов по массиву. На первом проходе ищутся все
     * пары элементов a[j] и a[j+1], где j — нечетное число (j = 1, 3, 5, …). Если ключи
     * следуют в неверном порядке, элементы меняются местами. На втором проходе то же самое
     *  делается для всех четных значений (j = 2, 4, 6, …). Двухпроходная обработка выполняется
     * многократно до тех пор, пока массив не будет полностью отсортирован. Замените метод
     * bubbleSort() в bubbleSort.java методом четно-нечетных перестановок oddEvenSort().
     * Убедитесь в том, что он работает для произвольных объемов данных. Требуется определить,
     * сколько раз будет выполняться двухпроходная обработка.
     */

   void oddEvenSort() {
        int count = 0;
        boolean even = true;
        boolean sorted = true;
        do {
            sorted = true;
            for (int i = even ? 0 : 1; i < box.length - 1; i = i + 2) {
                if (box[i] > box[i+1]) {
                    sorted = false;
                    swap(i, i+1);
                }
            }
            count++;
            even = !even;
        } while (!sorted | count < 2);
       System.out.println("Потребовалось " + count + " прохода(-ов). Длина массива " + box.length);
    }
}

