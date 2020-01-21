package com.company.sorting;

public class SortApp {

    public static void main(String args[]) {
        Sort bubble = new SelectSort(10, true);
        bubble.display();
        bubble.sort();
        bubble.display();
    }
}
