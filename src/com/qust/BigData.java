package com.qust;

import java.util.Arrays;

//测试大数运算
public class BigData {
    public static void main(String[] args) {
           int num=1234567123;
           int factor=99;
        System.out.println(countBigData(num,factor));
    }

    /**
     *例如计算 1234567*18
     * @param num  大数字
     * @param factor 因数（小数字）
     * @return 以字符串的格式返回
     */
    public static String countBigData(int num,int factor ){
        //初始化数组来存放结果,根据传入的数字计算长度
        int l=String.valueOf(num).length();
        int[] result=new int[l+String.valueOf(factor).length()+1];
        //将大数放入数组中用于后续的计算
        for(int i=1;i<=l;i++)
            result[result.length-i]=Integer.parseInt(String.valueOf(num).charAt(l-i)+"");

        //将数组中的每个数字乘以因子
        for(int i=1;i<=l;i++)
            result[result.length-i]= result[result.length-i]*factor;
        //对数组进行处理
        for(int i=result.length-1;i>0;i--){
            result[i-1]= result[i-1]+ result[i]/10;
            result[i]= result[i]%10;
        }
        //记录第一个不为0的位置
        int index=0;
        for(int i=0;i<result.length;i++){
               if (result[i]!=0){
                   index=i;
                   break;
               }
        }
        StringBuffer sb=new StringBuffer();
        for (int i=index;i<result.length;i++)
            sb.append(result[i]);
        return sb.toString();
    }
}
