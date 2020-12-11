package com.trx.socketdemo.jvmcase;

public class Test {

    public static void main(String[] args) {
        Worker  work = new Worker();
        work.setId(1);
        work.setUsername("test");
        work.setPassword("password");
        System.out.println(work);
        Worker.printf(work);
        System.out.println(work.hashCode());
    }
}
