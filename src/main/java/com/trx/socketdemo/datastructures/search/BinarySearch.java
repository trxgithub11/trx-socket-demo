package com.trx.socketdemo.datastructures.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

    public static void main(String[] args) {

        int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
//        int res = binarySearch(arr,0,arr.length-1,12);
        List res = binarySearch2(arr,0,arr.length-1,-1);
        System.out.println("res="+res);
    }


    //二分查找
    public static int binarySearch(int[] arr,int left,int right,int findVal){
        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){

            return -1;
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findVal>midVal){//向右递归
            return binarySearch(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return binarySearch(arr,left,mid-1,findVal);
        }else{
            return mid;
        }
    }


    public static List binarySearch2(int arr[],int left,int right,int findVal){


        //当left>right时，说明递归整个数组，但是没有找到
        if(left>right){

            return new ArrayList();
        }
        int mid = (left+right)/2;
        int midVal = arr[mid];
        if(findVal>midVal){//向右递归
            return binarySearch2(arr,mid+1,right,findVal);
        }else if(findVal<midVal){//向左递归
            return binarySearch2(arr,left,mid-1,findVal);
        }else{

            /**
             * 1.在找到mid索引值，不要马上返回
             * 2.向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
             * 3.向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
             * 4.将Arraylist返回
             */
            List resIndex = new ArrayList();
            //向mid索引值的左边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            int temp = mid-1;
            while(true){
                if(temp<0||arr[temp]!=findVal){
                    break;
                }
                //否则，就temp放入到resIndexList
                resIndex.add(temp);
                temp--;
            }

            resIndex.add(mid);
            //向mid索引值的右边扫描，将所有满足1000的元素的下标，加入到集合ArrayList
            temp = mid+1;
            while(true){
                if(temp>arr.length-1||arr[temp]!=findVal){
                    break;
                }
                //否则，就temp放入到resIndex
                resIndex.add(temp);
                temp++;
            }
            return resIndex;
        }
    }
}
