package com.trx.socketdemo.datastructures.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {

        int[] arr = {101,34,119,1,-1,89};
        insertSort(arr);
        System.out.println("排序后数据="+ Arrays.toString(arr));
    }
    public static void insertSort(int[] arr){

        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i <arr.length; i++) {
            insertVal = arr[i];
            insertIndex = i-1;//即arr[1]的前面这个数的下标
            //给insertVal找到插入的位置
            //1、insertIndex>=0保证在给insertVal找插入位置，不越界
            //2、insertVal<arr[insertIndex]待插入的数，还没有找到插入位置
            //3、就需要将arr[insertIndex]后移
            while(insertIndex>=0&&insertVal<arr[insertIndex]){

                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }

            //当退出while循环时，说明插入的位置找到，insertIndex+1
            //这里我们判断是否需要赋值
            if(insertIndex+1!=i){
                arr[insertIndex+1] = insertVal;
            }
        }
    }
}
