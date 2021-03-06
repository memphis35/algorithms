package com.company.sorting;

import java.util.Arrays;

public class InsertSort extends Sort {

    InsertSort(int size, boolean fill) {
        super(size, fill);
    }

    protected void sort() {
        int temp;
        int j;
        int length = getBox().length;
        for (int i = 1; i < length; i++) {
            temp = box[i];
            j = i;
            while (j > 0 && temp < box[j - 1]) {
                box[j] = box[j - 1];
                j--;
            }
            box[j] = temp;
        }
    }

    /**
     * 3.2. Добавьте в класс ArrayIns программы insertSort.java (листинг 3.3) метод с именем median(), возвращающий
     * медиану массива. (Напомним, что в группе чисел половина меньше медианы, а другая половина больше.)
     * Найдите простое решение этой задачи.
     */

    int median() {
        sort();
        display();
        int l = box.length;
        return l % 2 != 0 ? box[(l - 1) / 2] : (box[l / 2] + box[(l / 2) - 1]) / 2;
    }

    /**
     * @homework 3.3. Добавьте в программу insertSort.java метод noDups(), который удаляет дубликаты из ранее
     * отсортированного массива без нарушения порядка элементов. Нетрудно представить себе схему,
     * в которой все элементы от позиции обнаружения дубликата до конца массива сдвигаются на одну
     * позицию, но это замедлит работу алгоритма до времени O(N^2) — по крайней мере при большом
     * количестве дубликатов. Проследите за тем, чтобы в вашем алгоритме ни один элемент не
     * перемещался более одного раза независимо от количества дубликатов — это обеспечит выполнение
     * алгоритма за время O(N).
     */
    void noDups() {
        int z = 0;
        for (int i = 0; i < box.length; i++) {
            if (box[i] > 0) {
                for (int j = i + 1; j < box.length; j++) {
                    if (box[i] == box[j]) {
                        box[j] = -1;
                    }
                }
                box[z++] = box[i];
            }
        }
        while (z < box.length) {
            box[z++] = 0;
        }
    }

    /**
     * @homework 3.5. Измените метод insertionSort() в программе insertSort.java, чтобы он подсчитывал
     * количество копирований и сравнений в ходе сортировки, а затем выводил полученные результаты.
     * Для подсчета сравнений необходимо разбить надвое сложное условие во внутреннем цикле while.
     * Используйте программу для измерения количества копирований и сравнения для разных объемов
     * данных, отсортированных в обратном порядке. Подтверждают ли результаты теоретическую
     * сложность O(N^2)? Проделайте то же самое для почти отсортированных данных (в которых только
     * несколько элементов находятся не на своих местах). Какие выводы можно сделать об
     * эффективности этого алгоритма для почти отсортированных данных?
     */

    void insertionSort() {
        int temp;
        int j;
        int copy = 0;
        int equations = 0;
        int sumEquations = 0;
        int length = getBox().length;
        for (int i = 1; i < length; i++) {
            temp = box[i];
            j = i - 1;
            while (j >= 0 && temp < box[j]) {
                if (temp < box[j]) {
                    equations++;
                    box[j + 1] = box[j];

                }
                j--;
            }
            box[j + 1] = temp;
            if (equations > 0) copy++;
            sumEquations += equations;
            equations = 0;
        }
        System.out.println("Число копирований: " + copy + ". Число сравнений " + sumEquations);
    }

    /**
     * @homework 3.6. Существует один интересный способ удаления дубликатов из массива. Со-
     * ртировка методом вставки использует алгоритм с вложенными циклами, который
     * сравнивает каждый элемент массива с каждым другим элементом. Если вы хотите
     * удалить дубликаты, это одно из возможных решений. Измените метод insertionSort()
     * в программе insertSort.java, чтобы он удалял дубликаты в ходе сортировки.
     * Например, при обнаружении дубликата можно заменить один из экземпляров ключевым
     * значением, которое заведомо меньше ключей других элементов (скажем, –1, если все
     * нормальные ключи положительны). Затем обычный алгоритм сортировки методом вставки,
     * рассматривающий новый ключ наравне со всеми остальными, размещает его в элементе
     * с индексом 0. дальнейшем он будет игнорироваться алгоритмом. Следующий дубликат
     * размещается в ячейке с индексом 1 и т. д. После завершения сортировки все удаленные
     * дубликаты (теперь представленные ключом –1) будут располагаться в начале массива.
     * Остается лишь сдвинуть недублированные элементы, чтобы они начинались с индекса 0,
     * и изменить размеры массива.
     */

    public void sortNoDups() {
        int temp;
        int j;
        int count = 0;
        for (int i = 1; i < box.length; i++) {
            temp = box[i];
            j = i;
            while (j > 0 && box[j - 1] > temp && box[j - 1] != -1) {
                box[j] = box[j - 1];
                j--;
            }
            box[j] = temp;
            if (j > 0 && box[j - 1] == temp) {
                for (int z = j - 1; z > 0; z--) {
                    box[z] = box[z - 1];
                }
                box[0] = -1;
                count++;
            }
        }
        int[] result = Arrays.copyOfRange(box, count, box.length);
        box = result;
    }
}
