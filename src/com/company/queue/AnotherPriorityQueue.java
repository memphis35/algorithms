package com.company.queue;

/**
 * 4.4. Реализация приоритетной очереди из листинга 4.6 обеспечивает быстрое
 * извлечение высокоприоритетных элементов, но вставка новых элементов выпол-
 * няется относительно медленно. Напишите программу с видоизмененным классом
 * PriorityQ, быстро выполняющим вставку (за время O(1)) с медленным извлече-
 * нием высокоприоритетного элемента. Включите метод для вывода содержимого
 * приоритетной очереди (см. п. 4.1).
 */

public class AnotherPriorityQueue extends AbstractQueue {

    public AnotherPriorityQueue(int size) {
        super(size);
        maxSize = size;
        queue = new int[size];
        count = 0;
    }

    private int getMinIndex(int[] queue) {
        int min = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (queue[i] < min && queue[i] != -1) {
                min = queue[i];
                index = i;
            }
        }
        return index;
    }

    @Override
    void add(int element) {
        queue[count++] = element;
    }

    @Override
    int delete() {
        int i = getMinIndex(queue);
        int element = queue[i];
        for (; i < count - 1; i++) {
            queue[i] = queue[i + 1];
        }
        queue[i] = 0;
        count--;
        return element;
    }

    @Override
    int peek() {
        return queue[0];
    }

    @Override
    void display() {
        int[] clone = queue.clone();
        for (int i = 0; i < count; i++) {
            int index = getMinIndex(clone);
            System.out.print(clone[index] + "\t");
            clone[index] = -1;
        }
        System.out.println(System.lineSeparator());
    }
}