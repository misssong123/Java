package com.qust.recursion;

public class MiGong {
    public static void main(String[] args) {
        // 先创建一个二维数组，模拟迷宫
        int[][] map = new int[8][8];
        // 使用1 表示墙
        // 上下全部置为1
        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        // 左右全部置为1
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }
        //设置挡板, 1 表示
        map[3][1] = 1;
        map[3][2] = 1;
        // 输出地图
        /**
         * 迷宫的情况
         * 1 1 1 1 1 1 1 1
         * 1 0 0 0 0 0 0 1
         * 1 0 0 0 0 0 0 1
         * 1 1 1 0 0 0 0 1
         * 1 0 0 0 0 0 0 1
         * 1 0 0 0 0 0 0 1
         * 1 0 0 0 0 0 0 1
         * 1 1 1 1 1 1 1 1
         * 当小球的位置走到（6,6）表示小球走了正确路径
         */
        System.out.println("迷宫的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay( 4, 2,map);

        //输出新的地图, 小球走过，并标识过的递归
        System.out.println("小球走过，并标识过的 地图的情况");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     *
     * @param i
     * @param j//(i,j)表示小球的起点
     * @param map 表示起始的迷宫
     *  确定小球行走的策略 下->右->上->左
     *  利用小球的递归回溯完成迷宫问题
     *   1代表墙，2代表走过的路，3代表此点不通，0代表未行走过
     */
    public static boolean setWay(int i ,int j,int[][] map){
        if (map[6][6]==2){//终点
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
               if (setWay(i+1,j,map)){//向下走
                   return true;
               }else if (setWay(i,j+1,map)){//向右走
                   return true;
               }else if (setWay(i-1,j,map)){//向上走
                   return true;
               }else if (setWay(i,j-1,map)){//向左走
                   return true;
               }else{
                   //说明该点是走不通，是死路
                   map[i][j]=3;
                   return false;
               }
            }else{
                return false;
            }
        }
    }
}
