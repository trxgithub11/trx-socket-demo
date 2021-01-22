package com.trx.socketdemo.datastructures.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {

//        int arr[] = {3,9,-1,10,20};
        int arr[] = {20,10,9,8,7};
        bubbleSort(arr);
//        for(int i=0;i<arr.length;i++){
//            System.out.println(arr[i]);
//        }
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //冒泡排序的时间复杂度O(n^2),
        int temp=0;//临时变量
        boolean flag = false;//标识变量，表示是否进行过交换
        for(int i=0;i<arr.length-1;i++){
            for (int j = 0; j <arr.length-1-i ; j++) {

                //如果前面的书比后面的数大，则交换
                if (arr[j] > arr[j+1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if(!flag){//在一趟排序中，一次交换都没有发生过
                break;
            }else{
                flag = false;//重置flag!!!,进行下次判断
            }
        }


    }
}
