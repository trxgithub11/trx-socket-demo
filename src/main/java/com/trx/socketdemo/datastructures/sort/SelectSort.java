package com.trx.socketdemo.datastructures.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class SelectSort {

    public static void main(String[] args) {

//        int[] arr = {101,34,119,1,-1,90,123};
//        selectSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        for(int i=0;i<80000;i++){
            arr[i]=(int)(Math.random()*80000);
        }
        System.out.println("排序前");
        Date  data1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data1Str = simpleDateFormat.format(data1);
        System.out.println("排序前的时间是="+data1Str);
        selectSort(arr);
        Date data2 = new Date();
        String data2Str = simpleDateFormat.format(data2);
        System.out.println("排序后的时间="+data2Str);

    }

    public static void selectSort(int[] arr){


        for(int i=0;i<arr.length-1;i++){
            int minIndex=i;
            int min = arr[i];
            for(int j=i+1;j>arr.length;j++){
                if(min>arr[j]){//假定的最小值，并不是最小
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }
            //将最小值，放在arr[0]即交换
            if(minIndex!=i){
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }
    }
























}
