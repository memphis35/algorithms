package com.company.stack;

import com.company.exceptions.EmptyStackException;
import com.company.exceptions.FullStackException;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;

public class StackTest {
    private ArrayStack stack;

    @Before
    public void setUp() {
        stack = new ArrayStack(3);
        stack.push(345);
        stack.push(98);
    }

    @After
    public void close() {
        stack.clear();
    }

    @Test
    public void pushTest() {
        int[] result = {345, 98, 0};
        Assert.assertArrayEquals(result, stack.getStack());
        Assert.assertEquals(1, stack.getPosition());
    }

    @Test(expected = FullStackException.class)
    public void pushTestFail() {
        stack.push(99);
        stack.push(1100);
    }


    @Test
    public void popTest() {
        int[] result = {345, 98, 0};
        Assert.assertEquals(98, stack.pop());
        Assert.assertArrayEquals(result, stack.getStack());
        Assert.assertEquals(0, stack.getPosition());
    }

    @Test(expected = EmptyStackException.class)
    public void popTestFail() {
        stack.pop();
        stack.pop();
        stack.pop();
    }

    @Test
    public void peekTest() {
        stack.peek();
    }
}
