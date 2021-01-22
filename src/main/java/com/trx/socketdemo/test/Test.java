package com.trx.socketdemo.test;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Test {

    public static void main(String[] args) {

        ConcurrentHashMap  concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("","");
        Semaphore  semaphore = new Semaphore(5);
        for (int i = 0; i <10 ; i++) {
            new Car(i,semaphore).start();
        }
    }
    static class Car extends Thread{

        private int num;
        private Semaphore semaphore;
        public Car(int num,Semaphore semaphore){

            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("第"+num+"占用一个停车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第"+num+"俩车走喽");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

















}
