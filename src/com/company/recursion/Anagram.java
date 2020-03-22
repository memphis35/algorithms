package com.company.recursion;

import java.util.Arrays;

public class Anagram {

    private char[] word;
    private int length;

    public Anagram(String word) {
        this.word = word.toCharArray();
        length = this.word.length;
    }

    public void doAnagram(int i) {
        if (i < length) {
            for ( ; length - i < word.length; i++) {

            }
        }
    }

    public void shiftLetters(int i, int j) {
        char temp = word[i];
        for (; i < length - 1; i++) {
            word[i] = word[i + 1];
        }
        word[length - 1] = temp;
        displayWord();
    }

    public void displayWord() {
        System.out.println(Arrays.toString(word));
    }

    public static void main(String[] args) {
        Anagram test = new Anagram("ABC");
        test.doAnagram(0);
    }
}
