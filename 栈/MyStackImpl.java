package 栈;

import 单链表.MySingleList;

/**
 * @ClassName MyStackImpl
 * @Description TODO
 * @Author L
 * @Date 2019/4/25 19:07
 * @Version 1.0
 **/
public class MyStackImpl implements IMyStack {
    public int[] elem;
    private char[] elem2;
    public int top;
    public int usedSize;

    public MyStackImpl(int x) {
        this.elem2 = new char[x];
        this.elem = new int[x];
        this.top = 0;
        this.usedSize = 0;

    }
    @Override
    public void push(int item) {
        this.elem[this.top] = item;
        this.top++;
        this.usedSize++;
    }


    @Override
    public int pop() {
        if(this.top == 0) {
            throw new UnsupportedOperationException("栈为空");
        }
        int data = this.elem[this.top-1];
        this.top--;
        this.usedSize--;
        return data;
    }



    @Override
    public int peek() {
        if(this.top == 0) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem[this.top-1];
    }



    @Override
    public boolean empty() {
        return this.top == 0;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    public void push2(char ch) {
        this.elem2[this.top] = ch;
        this.top++;
        this.usedSize++;
    }

    public char pop2() {
        if(this.top == 0) {
            throw new UnsupportedOperationException("栈为空");
        }
        char ch = this.elem2[this.top-1];
        this.top--;
        this.usedSize--;
        return ch;
    }

    public char peek2() {
        if(this.top == 0) {
            throw new UnsupportedOperationException("栈为空");
        }
        return this.elem2[this.top-1];
    }


}


//栈清除内存，需要使用for循环 遍历栈，将对应的栈置为null；
