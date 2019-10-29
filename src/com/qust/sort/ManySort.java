package com.qust.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ManySort {
    public static void main(String[] args) {
        int[]arr=new int[10];
        for (int i=0;i<10;i++){
            arr[i]=(int)(Math.random()*800);
        }
        System.out.println(Arrays.toString(arr));
        //printTime();
        //bubbleSort(arr);
        //selectSort(arr);
        insertSort(arr);
        //printTime();
        System.out.println(Arrays.toString(arr));

    }
    public static void printTime(){
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s=simpleDateFormat.format(date);
        System.out.println("当前时间:"+s);
    }

    /**
     * 冒泡排序
     * @param arr 待排序的数组
     */
    public static void bubbleSort(int[] arr){
        //外层循环，要循环的次数length-1
        int size=arr.length;
        int temp=0;
        boolean flag=false;//用来优化，当一次排序不在进行交换时，表示已经排好序
        for(int i=0;i<size-1;i++){
            //内层循环表示要比较的个数
            for (int j=0;j<size-1-i;j++){
                if (arr[j]>arr[j+1]){
                    flag=true;
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
            if (!flag){
                break;
            }else {
                flag=false;
            }

        }
    }

    /**
     * 选择排序 每次选择最小的数字放在前面的位置
     * @param arr 待排序的数组
     */
    public static void selectSort(int[] arr){
            int size=arr.length;
            for (int i=0;i<size-1;i++){
                int index=i;
                int min=arr[i];
                for (int j=i+1;j<size;j++){
                    if (min>arr[j]){
                        min=arr[j];
                        index=j;
                    }
                }
                if (index!=i){
                    arr[index]=arr[i];
                    arr[i]=min;
                }
            }

    }

    /**
     * 插入排序 将后面无序的数组依次插入到前面有序的数组中
     * @param arr 待排序的数组
     */
    public static void insertSort(int[] arr){
        int size=arr.length;
         for (int i=1;i<size;i++){
             int index=i-1;
             int val=arr[i];
            while (index>=0&&arr[index]>val){
                    arr[index+1]=arr[index];
                    index--;
            }
            arr[index+1]=val;
         }
    }

}
