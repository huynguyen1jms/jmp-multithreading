package com.jmp.springboot.task;

import java.util.HashSet;
import java.util.Set;

public class ObjectPool {
    private int size;
    private final Set<Obj> available = new HashSet<>();
    private final Set<Obj> inUse = new HashSet<>();

    public ObjectPool(int size) {
        this.size = size;
    }

    public synchronized Obj get() {
        if (available.isEmpty()) {
            return null;
        }
        Obj instance = available.iterator().next();
        available.remove(instance);
        inUse.add(instance);
        return instance;
    }

    public synchronized void put() {
        if (available.size() < size) {
            available.add(create());
        }
    }

    public synchronized void take(Obj instance) {
        inUse.remove(instance);
        available.add(instance);
    }

    private Obj create() {
        return new Obj();
    }

    @Override
    public synchronized String toString() {
        return String.format("Pool available=%d inUse=%d", available.size(), inUse.size());
    }
}