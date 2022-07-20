package com.jmp.springboot.task;

import java.util.*;

public class Task2 {
    private static List<Integer> values = Collections.synchronizedList(new ArrayList<>());

    private static class MyThread1 extends Thread {
        public void run() {
            for (int i = 1; i <= 1000; i++) {
                int randomInt = (int) Math.random();
                values.add(randomInt);
            }
        }
    }

    private static class MyThread2 extends Thread {
        public void run() {
            int sum = 0;
            for (int i : values) {
                sum += i;
            }
            System.out.println("sum = " + sum);
        }
    }

    private static class MyThread3 extends Thread {
        public void run() {

            int sum = 0;
            for (int i : values) {
                int square = i * i;
                sum += square;
            }
            double sqrt = Math.sqrt(sum);
            System.out.println("sqrt = " + sqrt);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());
        t1.start();

        Thread t2 = new Thread(new MyThread2());
        t2.start();

        Thread t3 = new Thread(new MyThread3());
        t3.start();
    }
}
