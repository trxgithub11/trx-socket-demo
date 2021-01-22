package com.trx.socketdemo.datastructures.sort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {

        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr){

        int temp=0;
        int count=0;
        for (int grap = arr.length/2; grap >0 ; grap /=2) {

            for (int i = grap; i <arr.length ; i++) {

                //遍历各组中所有的元素(共grap组，每组有元素),步长grap
                for(int j=i-grap;j>=0;j-=grap){
                    //如果当前元素大于加上步长后那个元素，说明交换
                        if(arr[j]>arr[j+grap]){
                            temp = arr[j];
                            arr[j]=arr[j+grap];
                            arr[j+grap] = temp;
                        }
                }
            }
        }
    }

    public static void shellSort2(int[] arr){

        for (int gap = arr.length/2; gap >0 ; gap /=2) {
            for (int i = gap; i <arr.length ; i++) {
                int j=i;
                int temp=arr[j];
                if(arr[j]<arr[j-gap]){
                    while(j-gap>=0&&temp<arr[j-gap]){
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    arr[j]=temp;
                }
            }
        }
    }
}
