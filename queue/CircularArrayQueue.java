package queue;

/**
 * @ClassName CircularQueue
 * @Description TODO  使用数组模拟环形队列的思路
 * @Author L
 * @Date 2019/7/26 19:24
 * @Version 1.0
 **/

import java.util.Scanner;

/**
 front变量的含义做一个调整：front就指向队列的第一个元素，也就是arr[front]就是队列的第一个元素
 front的初始值 = 0；
 rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
 rear的初始值 = 0；
 当队列满时，条件是(rear+1) % maxSize = front [满]
 当队列为空的条件，rear == front 空
 当我们这样分析，队列中有效的数据个数 (real + maxSize - front) % maxSize
 这样就得到了环形队列
 **/

//  环形队列的关键在于头尾指针的取模！！！！
class CircularArray {
    // 队头指针 ---- 初始值 = 0
    // front就指向队列的第一个元素  也就是arr[front]就是队列的第一个元素
    private int front;
    // 队尾指针 ---- 初始值 = 0
    // rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间作为约定
    private int rear;
    // 数组的最大容量
    private Integer maxSize;
    // 实现队列的数组，模拟队列
    private int[] arr;

    // 创建队列的构造器
    public CircularArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.arr = new int[maxSize];
    }

    // 判断队列是否满了
    public boolean isFull() {
        return (rear+1) % maxSize == front;
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
        // 直接将数据加入
        arr[rear] = val;
        // 将rear后移，这里必须考虑取模
        rear = (rear+1) % maxSize;
    }

    // 获取队列的数据，出队列
    public int getQueue() {
        // 判断队列是否空
        if (isEmpty()) {
            // 通过抛出异常来处理
            throw new RuntimeException("队列空，不能去数据");
        }
        // 这里需要分析出front是指向队列的第一个元素
        // 1. 先把front对应的值保存到一个临时变量
        // 2. 将front后移
        // 3. 将临时保存的变量返回
        int temp = arr[front];
        front = (front+1) % maxSize;
        return temp;
    }

    // 显示队列的所有元素
    public void showAllQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        // 从front开始遍历，遍历多少个元素

        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize , arr[i%maxSize]);
        }
    }

    // 求出当前队列有效数据的个数
    public int size() {
        return (rear+maxSize-front) % maxSize;
    }

    // 显示队列的头数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }
}

public class CircularArrayQueue {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例------");
        // 设置为4，其队列的有效最大数据是3个
        CircularArray queue = new CircularArray(4);
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
                    queue.showAllQueue();
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
