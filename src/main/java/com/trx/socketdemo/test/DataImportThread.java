package com.trx.socketdemo.test;

import java.util.concurrent.CyclicBarrier;

public class DataImportThread extends Thread{

    private CyclicBarrier  cyclicBarrier;
    private String path;
    public DataImportThread(CyclicBarrier cyclicBarrier,String path){

        this.cyclicBarrier=cyclicBarrier;
        this.path = path;
    }


    @Override
    public void run() {
        System.out.println("开始导入："+path+"位置的数据");
        try{
            cyclicBarrier.await();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
