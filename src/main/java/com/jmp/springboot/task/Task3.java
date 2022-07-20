package com.jmp.springboot.task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Task3 {
    public static void main(String[] args) {
        BlockingQueue servingLine = new ArrayBlockingQueue<String>(5);
        new Consumer(servingLine).start();
        new Consumer(servingLine).start();
        new Producer(servingLine).start();
    }
}
