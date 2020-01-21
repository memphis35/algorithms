package com.company.arrays;

import java.util.Arrays;

public class OrderedArrayApp {

    public static void main(String args[]) {
        OrderedArray example1 = new OrderedArray(5);
        example1.fillTeam();
        System.out.println(Arrays.toString(example1.getTeam()));
        System.out.println("\n");
        OrderedArray example2 = new OrderedArray(5);
        example2.fillTeam();
        System.out.println(Arrays.toString(example2.getTeam()));
        System.out.println("\n");
        example1.merge(example1.getTeam(), example2.getTeam());

    }
}
