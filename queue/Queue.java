package queue;

import java.util.Scanner;


/**
 * @ClassName
 * @Description TODO  队列的顺序存储----利用数组实现队列
 *              TODO  目前数组使用一次就不能用，没有达到复用的效果
 *              TODO  将这个数组使用算法，改进成一个环形的队列   ----  取模的算法 %
 *              TODO  实际应用在银行排队等场景
 * @Author L
 * @Date 2019/7/26 18:46
 * @Version 1.0
 **/
class ArrayQueue {
    // 队头指针
    private Integer front;
    // 队尾指针
    private Integer rear;
    // 数组的最大容量
    private Integer maxSize;
    // 实现队列的数组，模拟队列
    private int[] arr;

    // 创建队列的构造器
    public ArrayQueue(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
        this.front = -1;// 指向队列头部，分析出front是指向队列头的前一个位置
        this.rear = -1;//指向队列尾，指向队列尾的数据（即就是队列最后一个数据）
    }

    // 判断队列是否满了
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void addQueue(int val) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列满，不能加入队列");
            return;
        }
        rear++;
        arr[rear] = val;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常来处理
            throw new RuntimeException("队列空，不能去数据");
        }
        front++; // front后移
        return arr[front];
    }

    // 显示队列的所有元素
    public void showAllQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的现有元素
    public void showNowQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    // 显示队列的头数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front + 1];
    }
}
public class Queue {

    public static void main(String[] args) {
        // 创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列得到数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showNowQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数据");
                    int val = scanner.nextInt();
                    queue.addQueue(val);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        e.getMessage();
                    }
                    break;
                case 'e': // 退出程序
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}


