package stack;

import java.util.Scanner;

/**
 * @ClassName ArrayStackDemo
 * @Description TODO   数组实现栈
 * @Author L
 * @Date 2019/8/4 22:12
 * @Version 1.0
 **/

// 定义一个类 ArrayStack 表示栈
class ArrayStack {
    private int maxSize; // 栈的大小
    private int[] stack; // 数组模拟栈，数据就放在该数组中
    private int top = -1; // 栈顶，初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.stack = new int[this.maxSize];
    }

    // 判断栈满
    public boolean isFull() {
        return this.top == maxSize - 1;
    }

    // 判断栈空
    public boolean isEmpty() {
        return this.top == -1;
    }

    // 入栈-push
    public void push(int value) {
        // 先判断栈满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        stack[++top] = value;
    }

    // 出栈-pop，将栈顶的数据返回
    public int pop() {
        // 先判断栈是否为空
        if (isEmpty()) {
            throw new RuntimeException("栈空，没有数据~~~");
        }
        int data = stack[top--];
        return data;
    }

    // 遍历栈---从栈顶开始遍历
    public void list() {
        // 判断是否为空
        if(isEmpty()) {
            System.out.println("栈空，没有数据~~~");
            return;
        }
        //需要从栈顶开始遍历
        for (int i = top; i >= 0 ; i--) {
            System.out.println(stack[i]);
        }
    }

}

public class ArrayStackDemo {
    //测试ArrayStack
    public static void main(String[] args) {
        // 先创建一个ArrayStack对象
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true; // 控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：退出程序");
            System.out.println("push：表示入栈");
            System.out.println("pop：表示出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key) {
                case "show" :
                    stack.list();
                    break;
                case "push" :
                    System.out.println("请输入一个值：");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop" :
                    try {
                        int rs = stack.pop();
                        System.out.println("出栈的数据：" + rs);
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "exit" :
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
