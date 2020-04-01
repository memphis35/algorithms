package com.company.recursion;

import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RecursionPractice {

    /**
     * A: От 1 до n
     * Дано натуральное число n. Выведите все числа от 1 до n.
     */

    private void fromOneToN(int n) {
        if (n > 1) {
            fromOneToN(n - 1);
        }
        System.out.print(n);
    }

    /**
     * B: От A до B
     * Даны два целых числа A и В (каждое в отдельной строке).
     * Выведите все числа от A до B включительно, в порядке возрастания,
     * если A < B, или в порядке убывания в противном случае.
     */

    private void fromAtoB(int a, int b) {
        if (a < b) {
            System.out.println(a);
            fromAtoB(a + 1, b);
        } else if (b < a) {
            System.out.println(a);
            fromAtoB(a - 1, b);
        } else {
            System.out.println(a);
        }
    }

    /**
     * C: Функция Аккермана
     * В теории вычислимости важную роль играет функция Аккермана A(m,n), определенная следующим образом:
     * { n + 1,               m = 0 }
     * A(m, n) = { A(m-1, 1)            m > 0, n = 0 }
     * { A(m-1, A(m, n-1),    m > 0, n > 0 }
     */
    private int functionOfAckermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return functionOfAckermann(m - 1, 1);
        } else {
            return functionOfAckermann(m - 1, functionOfAckermann(m, n - 1));
        }
    }

    /**
     * D: Точная степень двойки
     * Дано натуральное число N. Выведите слово YES, если число N является точной степенью двойки, или слово NO в противном случае.
     * Операцией возведения в степень пользоваться нельзя!
     */

    private boolean isLogOfTwo(double n) {
        n = Math.sqrt(n);
        if (n % 2 != 0) {
            return false;
        } else if (n == 2) {
            return true;
        } else {
            return isLogOfTwo(n);
        }
    }

    /**
     * E: Дано натуральное число N. Вычислите сумму его цифр.
     * При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
     */
    private int sumOfDigits(int n) {
        if (n > 0) {
            return n % 10 + sumOfDigits(n / 10);
        }
        return 0;
    }

    /**
     * F: Цифры числа справа налево
     * Дано натуральное число N. Выведите все его цифры по одной, в ОБРАТНОМ порядке,
     * разделяя их пробелами или новыми строками. При решении этой задачи нельзя использовать
     * строки, списки, массивы (ну и циклы, разумеется). Разрешена только рекурсия и целочисленная арифметика.
     */

    private void revertDigits(int n) {
        if (n > 0) {
            System.out.print(n % 10 + "\t");
            revertDigits(n / 10);
        }
    }

    /**
     * G: Цифры числа слева направо
     * Дано натуральное число N. Выведите все его цифры по одной, в ОБЫЧНОМ порядке, разделяя их пробелами или новыми строками.
     * При решении этой задачи нельзя использовать строки, списки, массивы (ну и циклы, разумеется).
     * Разрешена только рекурсия и целочисленная арифметика.
     */

    private void straightDigits(int n) {
        if (n > 0) {
            straightDigits(n / 10);
            System.out.print(n % 10 + "\t");
        }
    }

    /**
     * H: Проверка числа на простоту
     * Дано натуральное число n > 1. Проверьте, является ли оно простым. Программа должна вывести слово YES,
     * если число простое и NO, если число составное. Алгоритм должен иметь сложность O(logn).
     * Указание. Понятно, что задача сама по себе нерекурсивна, т.к. проверка числа n на простоту
     * никак не сводится к проверке на простоту меньших чисел. Поэтому нужно сделать еще один параметр рекурсии:
     * делитель числа, и именно по этому параметру и делать рекурсию.
     */
    private boolean checkSimpleNumber(int number, int div) { // решение за время O(N), при больших значениях падает StackOverFlow
        if (div != number && number % div == 0) {
            return false;
        } else if (div == number) {
            return true;
        } else {
            return checkSimpleNumber(number, div + 1);
        }
    }

    /**
     * I: Разложение на множители
     * Дано натуральное число n>1. Выведите все простые множители этого числа в порядке
     * возрастания с учетом кратности. Алгоритм должен иметь сложность O(logN).
     */

    private void showDividers(int number, int div) { // решение за время O(N), при больших значениях падает StackOverFlow
        if (number % div == 0 && div != number) {
            System.out.println(div + "\t");
            showDividers(number / div, div);
        } else if (div == number) {
            System.out.println(div + "\t");
        } else {
            showDividers(number, div + 1);
        }
    }

    /**
     * J: Палиндром
     * Дано слово, состоящее только из строчных латинских букв. Проверьте, является ли это слово палиндромом. Выведите YES или NO.
     * При решении этой задачи нельзя пользоваться циклами, в решениях на питоне нельзя использовать срезы с шагом, отличным от 1.
     */

    private boolean checkPalindrome(String word) {
        if (word.length() < 2) {
            return true;
        } else if (word.charAt(0) == word.charAt(word.length() - 1)) {
            return checkPalindrome(word.substring(1, word.length() - 1));
        } else {
            return false;
        }
    }

    /**
     * K: Вывести нечетные числа последовательности
     * Дана последовательность натуральных чисел (одно число в строке), завершающаяся числом 0.
     * Выведите все нечетные числа из этой последовательности, сохраняя их порядок.
     * В этой задаче нельзя использовать глобальные переменные и передавать какие-либо параметры
     * в рекурсивную функцию. Функция получает данные, считывая их с клавиатуры.
     * Функция не возвращает значение, а сразу же выводит результат на экран. Основная программа
     * должна состоять только из вызова этой функции.
     */

    private void showOddDigits() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int digit = reader.read();
        if (digit == 0 ) {
            reader.close();
            return;
        }
        if (digit % 2 != 0) {
            System.out.print(digit);
        }
        showOddDigits();
    }

    public static void main(String[] args) throws IOException {
        RecursionPractice test = new RecursionPractice();
        test.showOddDigits();
    }
}
