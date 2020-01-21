package com.company.arrays;

import com.company.exceptions.NumberDuplicatedException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class HighArrayTest {
    HighArray test = new HighArray(3);

    @Before
    public void setUp() throws Exception {
        this.test.insertNumber(345);
        this.test.insertNumber(666);
    }

    @After
    public void closeDown() {
        test.clear();
        test = new HighArray(3);
    }

    @Test
    public void insertNumberTest() {
        test.insertNumber(777);
        int[] result = {345, 666, 777};
        assertArrayEquals(result, test.getTeam());
        assertEquals(3, test.getSize());
    }

    @Test(expected = NumberDuplicatedException.class)
    public void insertNumberTestFail() {
        test.insertNumber(666);
        int[] result = {345, 666, 777};
        assertArrayEquals(result, test.getTeam());
        assertEquals(3, test.getSize());
    }

    @Test
    public void insertNumberTestDupsOn() {
        test.dupsOn();
        test.insertNumber(666);
        int[] result = {345, 666, 666};
        assertArrayEquals(result, test.getTeam());
        assertEquals(3, test.getSize());
    }


    @Test
    public void findNumberSuccess() {
        assertEquals(1, test.searchIndex(666));
    }

    @Test
    public void findNumberFail() {
        assertEquals(-1, test.searchIndex(777));
    }

    @Test
    public void deleteNumberTest() {
        test.deleteNumber(345);
        int[] result = {666, 0, 0};
        assertArrayEquals(result, test.getTeam());
        assertEquals(1, test.getSize());
    }

    @Test
    public void displayTest() {
        test.clear();
        test.fillTeam();
        test.display();
    }

    @Test
    public void noDupsTest() {
        int[] dups = {54, 97, 97, 61, 23, 75, 61, 99, 48, 44, 38, 12, 48, 48};
        int[] result = {54, 97, 61, 23, 75, 99, 48, 44, 38, 12,  0,  0,  0,  0};
        test.team = dups;
        test.noDups();
        assertArrayEquals(result, test.getTeam());
        assertEquals(10, test.getSize());
    }
}
