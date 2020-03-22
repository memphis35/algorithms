package com.company.recursion;

public class TriangleNumbers {

    public int calcNumbers(int lastNumber) {

        while (lastNumber > 0) {
            return lastNumber + calcNumbers(lastNumber - 1);
        }
        return 0;
    }

    public int factorial(int x) {
        while (x > 0) {
            return x * factorial(x - 1);
        }
        return 1;
    }

    public static void main(String[] args) {
        TriangleNumbers test = new TriangleNumbers();
        System.out.println(test.calcNumbers(10));
        System.out.println(test.factorial(4));
    }
}
