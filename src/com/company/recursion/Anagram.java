package com.company.recursion;

import java.util.Arrays;

public class Anagram {
    private static int count = 0;
    private char[] word;
    private int length;

    private Anagram(String word) {
        this.word = word.toCharArray();
        length = this.word.length;
    }

    private int getLength() {
        return length;
    }

    private void doAnagram(int newSize) {
        for (int i = newSize; i < length; i++) {
            doAnagram(newSize + 1);
            shiftLetters(newSize);
            if (newSize == 2) {
                displayWord();
            }
        }
    }

    public void shiftLetters(int i) {
        char temp = word[i];
        for (; i < length; i++) {
            if (i == length - 1) {
                break;
            }
            word[i] = word[i + 1];
        }
        word[length - 1] = temp;
    }

    public void displayWord() {
        System.out.println(Arrays.toString(word));
    }

    public static void main(String[] args) {
        Anagram test = new Anagram("ABC");
        test.doAnagram(0);
    }
}
