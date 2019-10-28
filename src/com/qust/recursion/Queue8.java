package com.qust.recursion;

import java.awt.image.RescaleOp;

/**
 * 八皇后问题，是一个古老而著名的问题，是回溯算法的典型案例。
 * 该问题是国际西洋棋棋手马克斯·贝瑟尔于1848年提出：在8×8格
 * 的国际象棋上摆放八个皇后，使其不能互相攻击，即任意两个皇后
 * 都不能处于同一行、同一列或同一斜线上，问有多少种摆法。
 */
public class Queue8 {
    int max=8;
    int[] result=new int[max];
    static int count=0;//解法
    static int sum=0;//判断冲突的次数
    public static void main(String[] args) {
       //每个元素的坐标表示第几行，每个元素的值表示放置的位置
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.printf("共有%d种解法",count);
        System.out.printf("总共判断了%d次冲突",sum);
    }

    /**
     * @param n 表示第几个皇后
     * @return true表示与之前的皇后不发生冲突
     */
    public   void check(int n){
        if(n==max){//表示第八个皇后已经放置完成
            print();//输出结果
            return;
        }
        for(int i=0;i<max;i++){
             //设定从每一行的第一个位置开始遍历
            result[n]=i;
            if (judge(n)){//只要和之前的皇后不冲突，则继续放置下一行的皇后
                check(n+1);
            }
        }
    }
    /**
     *
     * @param n 表示第n个皇后
     * @return 判断该位置放置皇后是否和之前的冲突
     */
    private boolean judge(int n) {
        sum++;
        for(int i = 0; i < n; i++) {
            // 说明
            //1. array[i] == array[n]  表示判断 第n个皇后是否和前面的n-1个皇后在同一列
            //2. Math.abs(n-i) == Math.abs(array[n] - array[i]) 表示判断第n个皇后是否和第i皇后是否在同一斜线
            if(result[i] == result[n] || Math.abs(n-i) == Math.abs(result[n] - result[i]) ) {
                return false;
            }
        }
        return true;
    }
    //写一个方法，可以将皇后摆放的位置输出
    private void print() {
        count++;
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
}
