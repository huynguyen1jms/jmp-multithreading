package com.jmp.springboot.task;

public class Task4 {
    public static void main(String[] args) {
        ObjectPool pool = new ObjectPool(3);

        pool.put();
        pool.put();
        pool.put();

        Obj obj1 = pool.get();
        Obj obj2 = pool.get();
        Obj obj3 = pool.get();
        System.out.println("obj1 : " + obj1);
        System.out.println("obj2 : " + obj2);
        System.out.println("obj3 : " + obj3);

        pool.take(obj1);
        pool.take(obj2);

        Obj obj4 = pool.get();
        Obj obj5 = pool.get();
        System.out.println("obj4 : " + obj4);
        System.out.println("obj5 : " + obj5);
    }
}
