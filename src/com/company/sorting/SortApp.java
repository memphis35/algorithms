package com.company.sorting;

public class SortApp {

    public static void main(String[] args) {
        InsertSort bubble = new InsertSort(20, true);
        int[] almostSorted = {5, 2, 3, 8, 9, 2, 4, 6, 3, 9, 1};
        //bubble.setBox(almostSorted);
        bubble.display();
        bubble.sortNoDups();
        bubble.display();
        System.out.println("Статус сортировки: " + bubble.checkSortNoDups());
    }
}
