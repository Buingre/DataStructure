package A2_queue;

/**
 * 用数组模拟对列
 */

import java.util.Scanner;

/**
 * 测试队列类
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //创建一个队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key=' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//控制循环
        //菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收一个字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入要添加的数字：");
                    int num = scanner.nextInt();
                    arrayQueue.addQueue(num);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.println("取出数据："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.println("队列头的数据："+res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
            }
        }
        System.out.println("程序退出~");
    }
}


/**
 * 用数组模拟对列【编写一个队列类】
 */
class ArrayQueue{
    private int maxSize;//数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列的构造器
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;// 指向队列头部，分析出 front 是指向队列头的前一个位置.
        rear = -1;// 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    //判断队列是否满
    public boolean isFull(){
        return rear==maxSize-1;
    }
    //判断队列是为空
    public boolean isEmpty(){
        return rear==front;
    }
    //添加数据到队列
    public void addQueue(int n){
        //1.先判断队列满？
        if(isFull()){
            System.out.println("队列满，不能加数据~");
            return;
        }
        //2.加入元素
        rear++;
        arr[rear] = n;
    }
    //获取队列的数据。出队列
    public int getQueue(){
        //1.先判断队列空？
        if(isEmpty()){

            //todo:[笔记]return -1;//不能return -1，因为可能那个值就是-1，所以抛出异常
            throw new RuntimeException("队列空，不能取数据~");
            //throw后不能写return，因为throw就会让我们的代码return
        }
        //2.取数据
        front++;
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue(){
        //1.判空
        if(isEmpty()){
            System.out.println("队列为空，没有数据~~");
            return;
        }
        //2.遍历
        for (int i = 0;i<maxSize;i++){
            //System.out.printf("arr[%d]=%d\n", i, arr[i]);
            System.out.println("arr["+i+"]="+arr[i]);
        }
    }

    //显示队列的头数据，不取出来
    public int headQueue(){
        //1.判空
        if(isEmpty()){
            throw new RuntimeException("队列空，不能取数据~");
        }
        //2.返回
        return arr[front+1];
    }


}