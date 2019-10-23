package com.qust;
import java.util.Scanner;
public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        // TODO: handle exception
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
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
class CircleArray{
    private int maxsize; // 表示数组的最大容量
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int head;
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int tail; // 队列尾
    private int[] arr; // 该数据用于存放数据, 模拟队列
    // 创建队列的构造器
    public CircleArray(int maxsize){
        arr=new int[maxsize+1];//因为会存在一个标志空间吗，所以将数组的长度增加1
        head=0; // 指向队列头部，分析出front是指向队列头的前一个位置.
        tail=0;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
        this.maxsize=maxsize+1;
    }
    // 判断队列是否满
    public boolean isFull(){
        return (tail+1)%maxsize==head;
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
        arr[tail]=num;
        //将 tail 后移, 这里必须考虑取模
        tail=(tail+1)%maxsize;
    }
    // 获取队列的数据, 出队列
    public int getQueue(){
        if (isNull()){
            throw new RuntimeException("队列空的，没有数据~~");
        }
        // 1. 先把 head 对应的值保留到一个临时变量
        // 2. 将 head 后移, 考虑取模
        // 3. 将临时保存的变量返回
        int value = arr[head];
        head = (head + 1) % maxsize;
        return value;
    }
    // 显示队列的所有数据
    public void showQueue(){
        if (isNull()){
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i=head,j=1;i<head+(tail+maxsize-head)%maxsize;i++,j++)
            System.out.printf("第%d个数据为:%d\n", j, arr[i%maxsize]);
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isNull()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return arr[head];
    }
}