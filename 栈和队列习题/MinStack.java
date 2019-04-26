package 栈和队列习题;

import 栈.MyStackImpl;

/**
 * @ClassName MinStack
 * @Description TODO
 * @Author L
 * @Date 2019/4/27 0:44
 * @Version 1.0
 **/
public class MinStack {

    private MyStackImpl myStack;
    private int usedSize;
    private int top;
    /** initialize your data structure here. */
    public MinStack(int x) {
        MyStackImpl myStack = new MyStackImpl(x);
        this.usedSize = 0;
        this.top = 0;
    }

    public void push(int x) {
        if(myStack.empty() && getMin() == 0) {
            myStack.push(x);

        }
    }

    public void pop() {

    }

    public int top() {

    }

    public int getMin() {
        return 0;
    }
}
