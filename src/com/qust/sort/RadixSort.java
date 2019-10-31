package com.qust.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = { 53, 3, 542, 748, 14, 214};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void radixSort(int[] arr) {
        //1. 得到数组中最大的数的位数
        int max = arr[0]; //假设第一数就是最大数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        //得到最大数是几位数
        int maxLength = (max + "").length();
        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        //3. 名明确，基数排序是使用空间换时间的经典算法
        int[][] bucket = new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts = new int[10];
        //这里我们使用循环将代码处理
      for(int i=0,n=1;i<maxLength;i++,n*=10){
          for (int j=0;j<arr.length;j++){
              int k=arr[j]/n%10;
              bucket[k][bucketElementCounts[k]]=arr[j];
              bucketElementCounts[k]++;
          }
          int index=0;
          for (int j=0;j<bucket.length;j++){
              if (bucketElementCounts[j]!=0){
                  for (int  m=0;m<bucketElementCounts[j];m++){
                      arr[index++]=bucket[j][m];
                  }
                  bucketElementCounts[j]=0;
              }
          }
      }

    }
}