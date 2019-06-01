package jcf;

import java.util.Stack;

/**
 * @ClassName TestStack
 * @Description TODO
 * @Author L
 * @Date 2019/6/1 19:44
 * @Version 1.0
 **/
public class TestStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        System.out.println("栈大小："+stack.size());
        System.out.println("查看栈顶元素："+stack.peek());//4
        System.out.println("栈是否为空："+stack.empty());
        System.out.println("出栈：" + stack.pop());//4
        System.out.println("出栈：" + stack.pop());//3
        System.out.println("出栈：" + stack.pop());//2
        System.out.println("出栈：" + stack.pop());//1
        //EmptyStackException 空栈异常
        System.out.println("出栈：" + stack.pop());
    }
}
