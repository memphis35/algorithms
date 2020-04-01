package com.company.arrays;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class OrderedArrayTest {
    private OrderedArray test = new OrderedArray(3);

    @Before
    public void setUp() {
        test.insertNumber(888);
        test.insertNumber(222);
    }
    @Test
    public void insertNumberTest() {
        test.insertNumber(555);
        int[] result = {222, 555, 888};
        assertArrayEquals(result, test.getTeam());
        assertEquals(3, test.getSize());
    }

    @Test(expected = Exception.class)
    public void insertNumberTestLimit() {
        test.insertNumber(555);
        test.insertNumber(105);
    }

    @Test
    public void displayTest() {
        test.clear();
        test.fillTeam();
        test.display();
    }

    @Test
    public void mergeTest() {
        int[] arr1 = {489, 490, 604, 727};
        int[] arr2 = {162, 168, 564};
        int[] result = {162, 168, 489, 490, 564, 604, 727};
        assertArrayEquals(result, test.merge(arr1, arr2));
    }
}
