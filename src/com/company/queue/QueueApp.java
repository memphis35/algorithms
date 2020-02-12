package com.company.queue;

import com.company.exceptions.EmptyQueueException;
import com.company.exceptions.FullQueueException;

import java.util.Scanner;

public class QueueApp {

    private AbstractQueue queue;
    private Scanner scan = new Scanner(System.in);

    public QueueApp() {
        System.out.println("Choose a queue: ");
        System.out.println("1. Array Queue\t2.Countless Queue\t3.Priority Queue");
        int number = scan.nextInt();
        switch (number) {
            case 1:
                queue = new ArrayQueue(5);
                break;
            case 2:
                queue = new CountlessQueue(5);
                break;
            case 3:
                queue = new AnotherPriorityQueue(5);
                break;
            default:
                System.out.println("Wrong number. Please, re-enter the number.");
        }
    }

    private int getNumber() {
        int number = 0;
        number = scan.nextInt();
        return number;
    }

    public static void main(String[] args) {

        QueueApp test = new QueueApp();
        int element = 0;
        boolean exit = false;
        while (!exit) {
            System.out.println("Please, select an option: ");
            System.out.println("0. Exit\t1. Add to queue\t2.Remove from queue");
            int number = test.getNumber();
            switch (number) {
                case 1:
                    System.out.println("Enter a number ");
                    element = test.getNumber();
                    try {
                        test.queue.insert(element);
                        test.queue.display();
                    } catch (FullQueueException err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                case 2:
                    try {
                        test.queue.remove();
                        test.queue.display();
                    } catch (EmptyQueueException err) {
                        System.out.println(err.getMessage());
                    }
                    break;
                default:
                    test.scan.close();
                    exit = true;
                    break;
            }
        }
    }
}
