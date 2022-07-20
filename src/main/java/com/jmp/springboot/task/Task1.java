package com.jmp.springboot.task;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static Map<Integer, Integer> values;
    static {
        Map<Integer, Integer>  data=new HashMap<>();
        data.put(1, 1);
        data.put(2, 2);
        data.put(3, 3);
        data.put(4, 4);
        data.put(5, 5);
        values = Collections.synchronizedMap(data);
    }

    private static class MyThread1 extends Thread {
        public void run() {
            values.put(6, 6);

            System.out.println(values);
        }
    }

    private static class MyThread2 extends Thread {
        public void run() {
            int sum = 0;
            for (int i : values.values()) {
                sum += i;
            }
            System.out.println("sum = " + sum);
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread1());
        t1.start();

        Thread t2 = new Thread(new MyThread2());
        t2.start();
    }
}
