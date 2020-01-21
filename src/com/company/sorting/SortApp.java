package com.company.sorting;

public class SortApp {

    public static void main(String args[]) {
        InsertSort bubble = new InsertSort(6, true);
        System.out.println("Медиана равна " + bubble.median());
    }
}
