package com.trx.socketdemo.datastructures.search;

public class InsertValueSearch {

    public static void main(String[] args) {
        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };

        int index = insertValueSearch(arr, 0, arr.length - 1, 1000);
        System.out.println("index = " + index);
    }

    //插值查找算法，也是要求数组是有序的
    public static int insertValueSearch(int[] arr,int left,int right,int findVal){

        //注意:findVal<arr[0]和findVal>arr[arr.length-1]否则我们得到的mid可能越界
        if(left>right||findVal<arr[0]||findVal>arr[arr.length-1]){
            return -1;
        }

        //求出mid，自适应
        int mid = left+(right-left)*(findVal-arr[left])/(arr[right]-arr[left]);
        int midVal = arr[mid];
        if(findVal>midVal){//向右递归
            return insertValueSearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return insertValueSearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }



    }
}
