package com.jmp.springboot.task;

import java.util.concurrent.atomic.AtomicInteger;

public class Obj {
    private static final AtomicInteger counter = new AtomicInteger(0);

    private final int id;

    public Obj() {
        id = counter.incrementAndGet();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Object id=%d", id);
    }
}
