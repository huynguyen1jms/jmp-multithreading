package com.jmp.springboot.task;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread {
    private BlockingQueue servingLine;

    public Consumer(BlockingQueue servingLine) {
        this.servingLine = servingLine;
    }

    public void run() {
        while(true) {
            try {
                String bowl = (String)servingLine.take();
                System.out.format("Ate %s\n", bowl);
                Thread.sleep(300);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
