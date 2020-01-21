package com.company.arrays;

import com.company.exceptions.FullArrayException;
import com.company.exceptions.NumberDuplicatedException;
import com.company.exceptions.NumberNotFoundException;

class HighArray {

    int[] team;
    int currentSize = 0;
    protected boolean noDuplicate = true;

    HighArray(int size) {
        team = new int[size];
    }

    int[] getTeam() {
        return team;
    }

    int getSize() {
        return currentSize;
    }

    void dupsOn() {
        this.noDuplicate = false;
    }

    void dupsOff() {
        this.noDuplicate = true;
    }

    void insertNumber(int number) throws NumberDuplicatedException, FullArrayException {
        int index = searchIndex(number);
        if (currentSize == team.length) {
            throw new FullArrayException("Error. Array is full.");
        } else
            addNew(index, number);
    }

    protected void addNew(int index, int number) {
        if (index >= 0 & noDuplicate) {
            throw new NumberDuplicatedException("Error. Number already exist.");
        } else {
            team[currentSize++] = number;
        }
    }

    void findNumber(int number) {
        int index = searchIndex(number);
        if (index >= 0) {
            System.out.println("Число " + number + " находится на позиции <" + index + ">");
        } else {
            System.out.println("Not found");
        }
    }

    void deleteNumber(int number) {
        int index = searchIndex(number);
        if (index < 0)
            throw new NumberNotFoundException("Error. Number not exist.");
        else
            for (int i = index; i < currentSize - 1; i++) {
                team[i] = team[i + 1];
            }
        team[currentSize - 1] = 0;
        currentSize--;
    }

    int searchIndex(int number) {
        int index = -1;
        for (int i = 0; i < currentSize; i++) {
            if (team[i] == number) {
                index = i;
                break;
            }
        }
        return index;
    }

    void display() {
        for (int i = 0; i < currentSize; i++) {
            System.out.print(team[i] + "<" + i + ">\t");
        }
    }

    void fillTeam() {
        int var;
        for (int i = 0; i < team.length; i++) {
            var = (int) (Math.round(Math.random() * 1000.0));
            if (var != 0) {
                insertNumber(var);
            } else {
                i--;
            }
        }
    }

    void clear() {
        for (int i = 0; i < currentSize; i++) {
            team[i] = 0;
        }
        currentSize = 0;
    }

    /**
     * Программный проект 2.1. Добавьте в класс HighArray из програмы highArray.java (листинг 2.3) метод
     * getMax(), который возвращает наибольшее значение ключа в массиве или – 1, если массив пуст. Добавьте
     * в main() код для тестирования нового метода. Считайте, что все ключи являются положительными числами.
     */

    private int getMax() {
        int max = -1;
        for (int i = 0; i < currentSize; i++) {
            if (team[i] > max) {
                max = team[i];
            }
        }
        return max;
    }

    /**
     * Программный проект 2.2. Измените метод из проекта 2.1 так, чтобы элемент с наибольшим ключом не
     * только возвращался методом, но и удалялся из массива. Присвойте новой версии имя removeMax().
     */
    int removeMax() {
        int max = getMax();
        deleteNumber(max);
        return max;
    }

    void noDups() {
        int[] result = new int[team.length];
        int z = 0;
        for (int i = 0; i < team.length; i++) {
            if (team[i] > 0) {
                result[z++] = team[i];
                for (int j = i + 1; j < team.length; j++) {
                    if (team[i] == team[j]) {
                        team[j] = -1;
                    }
                }
            }
        }
        team = result;
        currentSize = z;
    }
}