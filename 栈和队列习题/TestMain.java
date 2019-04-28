package 栈和队列习题;

import 栈.MyStackImpl;

/**
 * @ClassName TestMain
 * @Description TODO
 * @Author L
 * @Date 2019/4/25 21:01
 * @Version 1.0
 **/
public class TestMain {

    public static void main(String[] args) {
        TestMinStack minStack = new TestMinStack(3);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }
    public static void main2(String[] args) {
        TestMyQueue testMyQueue = new TestMyQueue(5);
        testMyQueue.push(10);
        testMyQueue.push(20);
        testMyQueue.push(30);
        testMyQueue.push(40);
        testMyQueue.push(50);
//        testMyQueue.push(60);
//        testMyQueue.push(70);
//        testMyQueue.push(80);

        System.out.println(testMyQueue.pop());
        System.out.println(testMyQueue.pop());
        System.out.println(testMyQueue.pop());
        System.out.println(testMyQueue.pop());
        System.out.println(testMyQueue.pop());
//        System.out.println(testMyQueue.peek());
//        System.out.println(testMyQueue.peek());
//        System.out.println(testMyQueue.peek());
//        System.out.println(testMyQueue.peek());
//        System.out.println(testMyQueue.peek());


    }
    public static void main1(String[] args) {
        String s = "         {[()]} (){}[(){}]     ";
        TestMyStack1 testMyStack1 = new TestMyStack1(s.length());
        System.out.println(testMyStack1.isValid(s));
    }
}
