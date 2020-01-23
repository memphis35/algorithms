package com.company.sorting;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    private Sort bubble;

    @Test
    public void bubbleSortTest1() {
        bubble = new BubbleSort(10, true);
        bubble.sort();
        Assert.assertTrue(bubble.checkSortNoDups());
    }

    @Test
    public void bubbleSortTest2() {
        BubbleSort bubble2 = new BubbleSort(10, true);
        bubble2.bubbleSort();
        Assert.assertTrue(bubble2.checkSortNoDups());
    }

    @Test
    public void selectSortTest() {
        bubble = new SelectSort(10, true);
        bubble.sort();
        Assert.assertTrue(bubble.checkSortNoDups());
    }

    @Test
    public void insertSortTest() {
        bubble = new InsertSort(10, true);
        bubble.sort();
        Assert.assertTrue(bubble.checkSortNoDups());
    }

    @Test
    public void noDupsTest() {
        InsertSort bubble2 = new InsertSort(1, false);
        int[] test = {11, 22, 22, 33, 33, 33, 55, 66, 77, 77, 88, 99};
        int[] result = {11, 22, 33, 55, 66, 77, 88, 99,  0,  0,  0,  0};
        bubble2.setBox(test);
        bubble2.noDups();
        Assert.assertArrayEquals(result, bubble2.getBox());
    }

    @Test
    public void sortNoDupsTest() {
        InsertSort bubble2 = new InsertSort(1, false);
        int[] test = {11, 22, 22, 33, 33, 33, 55, 66, 77, 77, 88, 99};
        int[] result = {11, 22, 33, 55, 66, 77, 88, 99};
        bubble2.setBox(test);
        bubble2.sortNoDups();
        Assert.assertArrayEquals(result, bubble2.getBox());
    }
    @Test
    public void oddEvenSortTest() {
        BubbleSort bubble = new BubbleSort(100, true);
        bubble.oddEvenSort();
        Assert.assertTrue(bubble.checkSortNoDups());
    }

}
