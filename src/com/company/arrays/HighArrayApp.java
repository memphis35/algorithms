package com.company.arrays;

public class HighArrayApp {
    /**
     * @homework 2.3. Метод removeMax() из пункта 2.2 может использоваться для сортировки
     * содержимого массива по ключу. Реализуйте алгоритм сортировки, который не изменяет класса HighArray
     * (а изменяет только код main()). Вам потребуется второй массив для хранения отсортированных данных.
     */

    public static void main(String args[]) {
        int size = 10;
        HighArray example = new HighArray(size);
        HighArray sorted = new HighArray(size);
        example.dupsOn();
        sorted.dupsOn();
        example.fillTeam();
        example.display();
        System.out.println("\n");
        for (int i = 0; i < size; i++) {
            sorted.insertNumber(example.removeMax());
        }
        sorted.display();
        sorted.findNumber(666);
    }
}
