package com.qust;
import java.util.Scanner;

/**
 * 使用数据简单实现队列的效果，无法进行循环使用
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试一把
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        //输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~");
    }
}
class ArrayQueue{
    private int maxsize;// 表示数组的最大容量
    private int head;// 队列头
    private int tail;//队列尾
    private int[]arr; //该数据用于存放数据, 模拟队列
    // 创建队列的构造器
    public ArrayQueue(int maxsize){
        arr=new int[maxsize];
        head=-1; // 指向队列头部，分析出front是指向队列头的前一个位置.
        tail=-1;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        this.maxsize=maxsize;
    }
    // 判断队列是否满
    public boolean isFull(){
        return tail==(maxsize-1);
    }
    // 判断队列是否为空
    public boolean isNull(){
        return head==tail;
    }
    // 添加数据到队列
    public void addQueue(int num){
        if (isFull()){
            System.out.println("队列满，不能加入数据~");
            return;
        }
        tail++;
        arr[tail]=num;
    }
    // 获取队列的数据, 出队列
    public int getQueue(){
        if (isNull()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        head++;
        return arr[head];
    }
    // 显示队列的所有数据
    public void showQueue(){
        if (isNull()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i=head+1,j=1;i<=tail;i++,j++)
            System.out.printf("第%d数据为:%d\n", j, arr[i]);
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isNull()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[head + 1];
    }
}