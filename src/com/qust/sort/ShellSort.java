package com.qust.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 通过交换实现希尔排序
     * 速度较慢，不建议使用
     * @param arr 待排序的数组
     */
    public static void shellSort1(int[]arr){
        //通过每次缩短步长来实现排序的效果
        int temp=0;
        for (int grap=arr.length/2;grap>0;grap/=2){
            for (int i=grap;i<arr.length;i++){
                for (int j=i-grap;j>=0;j-=grap){
                    if (arr[j+grap] < arr[j]) {
                        temp=arr[j];
                        arr[j]=arr[j+grap];
                        arr[j+grap]=temp;
                    }
                }
            }
        }
    }
    /**
     * 通过插入实现希尔排序
     * 速度较快，建议使用
     * @param arr 待排序的数组
     */
    public static void shellSort2(int[]arr){
        //通过每次缩短步长来实现排序的效果
        for (int grap=arr.length/2;grap>0;grap/=2){
            for (int i=grap;i<arr.length;i++){
                int j=i;
                int cur=arr[i];
                while(j-grap>=0&&arr[j-grap]>cur){
                    arr[j]=arr[j-grap];
                    j-=grap;
                }
                arr[j]=cur;
            }
        }
    }
}
