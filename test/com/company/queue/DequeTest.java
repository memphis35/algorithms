package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DequeTest {

    CustomDeque test;

    @Before
    public void setUp() {
        test = new CustomDeque(10);
        test.insertLeft(11);
        test.insertLeft(55);
        test.insertRight(22);
        test.insertRight(88);
    }

    @Test
    public void insertTest() {
        test.insertLeft(44);
        test.insertRight(99);
        test.insertRight(84);
        test.insertRight(84);
        test.insertRight(84);
        test.insertLeft(97);
        int[] result = {22, 88, 99, 84, 84, 84, 97, 44, 55, 11};
        assertArrayEquals(result, test.getQueue());
        assertEquals(10, test.size());
    }

    @Test
    public void removeTest() {
        test.removeLeft();
        test.removeRight();
        int[] result = {22, 0, 0, 0, 0, 0, 0, 0, 0, 11};
        assertArrayEquals(result, test.getQueue());
        assertEquals(2, test.size());
    }

    @Test(expected = EmptyQueueException.class)
    public void removeFailTest() {
        while (true) {
            test.removeLeft();
        }
    }
    @Test(expected = FullQueueException.class)
    public void insertFailTest() {
        while (true) {
            test.insertRight(111);
            test.insertLeft(222);
        }
    }
}
