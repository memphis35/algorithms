package com.company.arrays;

import com.company.exceptions.NumberDuplicatedException;

import java.util.Arrays;

/**
 * @homework 2.4. Измените программу orderedArray.java (листинг 2.4) так, чтобы методы
 * insert() и delete(), а также метод find() использовали двоичный поиск.
 */
class OrderedArray extends HighArray {

    OrderedArray(int size) {
        super(size);
    }

    /**
     * Реализован бинарный поиск.
     */
    @Override
    int searchIndex(int searchNumber) {
        int min = 0;
        int max = currentSize - 1;
        int temp = (min + max) / 2;
        while (team[temp] != searchNumber && min < max) {
            if (team[temp] > searchNumber) {
                max = temp - 1;
            } else {
                min = temp + 1;
            }
            temp = (min + max) / 2;
        }
        if (team[temp] < searchNumber) {
            temp = -temp - 1;
        } else if (team[temp] > searchNumber) {
            temp = -temp;
        }
        return temp;
    }

    @Override
    protected void addNew(int index, int number) {
        if (currentSize == 0) {
            team[0] = number;
        } else if (index > 0 & noDuplicate) {
            throw new NumberDuplicatedException("Error. Number already exist.");
        } else {
            index *= -1;
            for (int i = currentSize - 1; i >= index; i--) {
                team[i + 1] = team[i];
            }
            team[index] = number;
        }
        currentSize++;
    }

    /**
     * Программный проект 2.5. Добавьте в класс OrdArray программы orderedArray.java (листинг 2.4) метод merge(),
     * объединяющий два упорядоченных исходных массива в один упорядоченный приемный массив.
     * Включите в main() фрагмент кода, который заполняет два исходных массива случайными числами, вызывает merge() и выводит содержимое
     * полученного массива. Исходные массивы могут содержать разное количество элементов. Ваш алгоритм должен
     * сравнивать ключи исходных массивов и копировать меньший в приемный массив. Также необходимо предусмотреть
     * ситуацию, когда элементы в одном исходном массиве заканчиваются раньше, чем в другом.
     */
    int[] merge(int[] array1, int[] array2) {
        int[] temp;
        if (array1[array1.length - 1] < array2[array2.length - 1]) {
            temp = array2;
            array2 = array1;
            array1 = temp;
        }
        int[] merged = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int z = 0;
        for (; z < merged.length; z++) {
            if (j >= array2.length || array1[i] <= array2[j]) {
                merged[z] = array1[i++];
            } else {
                merged[z] = array2[j++];
            }
        }
        System.out.println(Arrays.toString(merged));
        return merged;
    }

}

