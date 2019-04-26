package 栈和队列习题;

import 栈.MyStackImpl;

/**
 * @ClassName TestMyQueue
 * @Description TODO
 * @Author L
 * @Date 2019/4/26 23:57
 * @Version 1.0
 **/
public class TestMyQueue {

    private MyStackImpl myStack1;
    private MyStackImpl myStack2;
    private int usedSize;


    /** Initialize your data structure here. */
    public TestMyQueue(int x) {
        this.myStack1 = new MyStackImpl(x);
        this.myStack2 = new MyStackImpl(x);
        this.usedSize = 0;
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        myStack1.push(x);
        this.usedSize++;

//        if(myStack1.elem.length >= this.usedSize) {
//            myStack1.push(x);
//        }else {
//            myStack2.push(x);
//        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(empty()) {
            return -1;
        }
        int data = 0;
        if(myStack2.empty()) {
            while(myStack1.usedSize != 0) {
                myStack2.push(myStack1.pop());
            }
           data = myStack2.pop();
        }else {
            data = myStack2.pop();
        }
        this.usedSize--;
        return data;
    }

    /** Get the front element. */
    public int peek() {
        if(empty()) {
            return -1;
        }
        int data = 0;
        if(myStack2.empty()) {
            while(myStack1.usedSize != 0) {
                myStack2.push(myStack1.pop());
            }
            data = myStack2.peek();
        }else {
            data = myStack2.peek();
        }
        return data;

    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.usedSize == 0;
    }
}
