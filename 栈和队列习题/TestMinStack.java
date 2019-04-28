package 栈和队列习题;

import 栈.MyStackImpl;

/**
 * @ClassName TestMinStack
 * @Description TODO
 * @Author L
 * @Date 2019/4/27 0:44
 * @Version 1.0
 **/
public class TestMinStack {

    private MyStackImpl myStack;
    private MyStackImpl minStack;

    /** initialize your data structure here. */
    public TestMinStack(int x) {
        this.myStack = new MyStackImpl(x);
        this.minStack = new MyStackImpl(x);
    }

    //入栈
    public void push(int x) {
        myStack.push(x);
        if (minStack.empty()) {
            minStack.push(x);
        }else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
    }

    //出栈
    public void pop() {
        if(!myStack.empty()) {
            int data = myStack.pop();
            if(data == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    //得到栈顶元素
    public int top() {
        if (myStack.empty()) {
            return -1;
        }else {
            return myStack.peek();
        }
    }

    //得到栈最小元素
    public int getMin() {
        return minStack.peek();
    }
}
