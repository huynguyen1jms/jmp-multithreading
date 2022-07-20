package com.jmp.springboot.task;

import java.util.concurrent.BlockingQueue;

public class Producer extends Thread{
    private BlockingQueue servingLine;

    public Producer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    public void run() {
        for (int i = 0; i<20; i++) {
            try {
                servingLine.add("Bowl #" + i);
                System.out.format("Serving bowl #%d - remaining capacity: %d\n", i, servingLine.remainingCapacity());
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
