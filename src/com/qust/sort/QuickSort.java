package com.qust.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void quickSort(int []arr,int left,int right){
        int l=left;
        int r=right;
        int temp=0;
        int mid=arr[(left+right)/2];
        //思路:选取中间元素，将小于中间元素值的放在中间元素的左侧，否则放在右侧
        while (l<r){
            //记录原来的左右位置
            while(arr[l]<mid)//在左边找到第一个大于等于mid的值
                l++;
            while(arr[r]>mid)//在右边找到第一个小于等于mid的值
                r--;
            if( l >= r) {
                break;
            }
                temp=arr[l];
                arr[l]=arr[r];
                arr[r]=temp;
                //因为可能会出现等于的情况不确定是否位于中间位置，所以移动一位
            //如果交换完后，发现这个arr[l] == mid值 相等 r--， 前移
            if(arr[l] == mid) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == mid值 相等 l++， 后移
            if(arr[r] == mid) {
                l += 1;
            }
        }
        if (l==r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r) {
            quickSort(arr, left, r);
        }
        //向右递归
        if(right > l) {
            quickSort(arr, l, right);
        }
    }
}
