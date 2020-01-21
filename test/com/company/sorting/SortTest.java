package com.company.sorting;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
    private Sort bubble;
    private int[] test = {99, 55, 22, 77, 44, 66, 88, 11, 33};
    private int[] result = {11, 22, 33, 44, 55, 66, 77, 88, 99};

    @Test
    public void bubbleSortTest() {
        bubble = new BubbleSort(10, false);
        bubble.setBox(test);
        bubble.sort();
        Assert.assertArrayEquals(result, bubble.getBox());
    }

    @Test
    public void selectSortTest() {
        bubble = new SelectSort(10, false);
        bubble.setBox(test);
        bubble.sort();
        Assert.assertArrayEquals(result, bubble.getBox());
    }

    @Test
    public void insertSortTest() {
        bubble = new InsertSort(10, false);
        bubble.setBox(test);
        bubble.sort();
        Assert.assertArrayEquals(result, bubble.getBox());
    }
}
