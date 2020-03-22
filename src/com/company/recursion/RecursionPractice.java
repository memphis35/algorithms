package com.company.recursion;

public class RecursionPractice {

    /**
     * A: От 1 до n
     * Дано натуральное число n. Выведите все числа от 1 до n.
     */

    public void fromOneToN(int n) {
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

    public void fromAtoB(int a, int b) {
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
    public int functionOfAckermann(int m, int n) {
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

    public boolean isLogOfTwo(double n) {
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
    public int sumOfDigits(int n) {
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

    public void revertDigits(int n) {
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

    public void straightDigits(int n) {
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
    public boolean checkSimpleNumber(int number, int div) { // решение за время O(N), при больших значениях падает StackOverFlow
        if ( div != number && number % div == 0) {
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

    public void showDividers(int number, int div) { // решение за время O(N), при больших значениях падает StackOverFlow
        if (number % div == 0 && div != number) {
            System.out.println(div + "\t");
            showDividers(number/div, div);
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

    public void checkPalindrome(String word) {
    }

    public static void main(String[] args) {
        RecursionPractice test = new RecursionPractice();

    }
}
