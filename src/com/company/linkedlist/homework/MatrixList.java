package com.company.linkedlist.homework;

/**
 * @homework 5.6. Попробуйте реализовать несколько иную структуру данных: двумерный
 * связанный список, который мы будем называть матрицей. Она представляет собой
 * списковый аналог двумерных массивов и может использоваться в различных при-
 * ложениях, например в электронных таблицах. Если электронная таблица постро-
 * ена на базе массива, то вставка нового элемента в начале потребует перемещения
 * каждой из N × M нижележащих ячеек, что, вероятно, займет много времени. Если
 * электронная таблица реализована на базе матрицы, то при вставке достаточно будет
 * изменить N указателей.
 * Для простоты будет использоваться односвязный список (хотя двусвязный
 * список в данном случае был бы более уместным). На каждый элемент (кроме на-
 * ходящихся в верхней строке и левом столбце) указывают ссылки элементов, нахо-
 * дящихся непосредственно над ним и слева от него. Скажем, можно начать с левого
 * верхнего угла и перейти к элементу в третьей строке и пятом столбце — для этого
 * достаточно переместиться на две строки вниз и четыре столбца вправо. Матрица
 * создается с изначально заданными размерами (допустим, 7 × 10). Ваша реализация
 * должна поддерживать вставку значений в заданных позициях и вывод текущего
 * содержимого матрицы.
 */

public class MatrixList {
    private int rows;
    private int columns;
    private Cell first;

    public MatrixList(int i, int j) {
        rows = i;
        columns = j;
        createMatrix(i);
    }

    private void createMatrix(int i) {
        createRow();
        while (--i > 0) {
            createUpperRow(rows - i);
        }
    }

    private void createRow() {
        int j = 1;
        first = new Cell(rows, j++);
        Cell temp = first;
        while (j <= columns) {
            first.setRight(new Cell(rows, j++));
            first = first.getRight();
        }
        first = temp;
    }

    private void createUpperRow(int row) {
        int j = 1;
        Cell firstUpper = new Cell(rows - row, j++);
        firstUpper.setDown(first);
        Cell temp = firstUpper;
        while (j <= columns) {
            firstUpper.setRight(new Cell(rows - row, j++));
            firstUpper = firstUpper.getRight();
            first = first.getRight();
            firstUpper.setDown(first);
        }
        first = temp;
    }

    private void displayRow(Cell begin) {
        Cell temp = begin;
        while (temp != null) {
            System.out.print(temp.getCoordinates() + "\t");
            temp = temp.getRight();
        }
    }

    private void displayMatrix() {
        Cell temp = first;
        int i = rows;
        while (i-- > 0) {
            displayRow(temp);
            System.out.println("\n");
            temp = temp.getDown();
        }
    }

    public void insertInPosition(int i, int j, int x, int y) {
        Cell changed = new Cell(x, y);
        Cell temp = getFromCoordinates(i, j);
        Cell fromLeft = getPreviousInRow(i, j);
        Cell fromTop = getPreviousInColumn(i, j);
        if (i == 1 && j == 1) {
            changed.setRight(first.getRight());
            changed.setDown(first.getDown());
            first = changed;
        } else {
            changed.setRight(temp.getRight());
            changed.setDown(temp.getDown());
            fromLeft.setRight(changed);
            fromTop.setDown(changed);
        }
    }

    private Cell getFromCoordinates(int i, int j) {
        Cell temp = first;
        while (--j > 0) {
            temp = temp.getRight();
        }
        while (--i > 0) {
            temp = temp.getDown();
        }
        return temp;
    }

    private Cell getPreviousInColumn(int i, int j) {
        Cell temp = first;
        while (--j > 0) {
            temp = temp.getRight();
        }
        while (--i - 1 > 0) {
            temp = temp.getDown();
        }
        return temp;
    }

    private Cell getPreviousInRow(int i, int j) {
        Cell temp = first;
        while (--i > 0) {
            temp = temp.getDown();
        }
        while (--j - 1 > 0) {
            temp = temp.getRight();
        }
        return temp;
    }

    private class Cell {
        private String coordinates;
        private Cell right;
        private Cell down;

        Cell(int x, int y) {
            coordinates = x + "/" + y;
        }

        private void setRight(Cell left) {
            this.right = left;
        }

        private void setDown(Cell up) {
            this.down = up;
        }

        private Cell getRight() {
            return right;
        }

        private Cell getDown() {
            return down;
        }

        private String getCoordinates() {
            return coordinates;
        }
    }

    public static void main(String[] args) {
        MatrixList test = new MatrixList(5, 5);
        test.insertInPosition(1, 3, 9, 9);
        test.displayMatrix();
    }
}
