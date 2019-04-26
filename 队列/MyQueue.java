package 队列;

import 栈.IMyStack;

/**
 * @ClassName MyQueue
 * @Description TODO
 * @Author L
 * @Date 2019/4/25 19:24
 * @Version 1.0
 **/
public class MyQueue implements IMyQueue {

    class Node {
        private int data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }
    }
    //头节点
    private Node front;
    //尾节点
    private Node rear;
    private int usedSize;

    public MyQueue() {
        this.front = null;
        this.rear = null;
        this.usedSize = 0;
    }

    @Override
    public boolean empty() {
        return this.usedSize == 0;
    }

    @Override
    public int peek() {
        if(empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        return this.front.data;
    }

    @Override
    public int poll() {
        if(empty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        int oldData = this.front.data;
        //如果只有一个有效数字时，rear总是引用this.front  会内存泄漏
        if(this.usedSize == 1) {
            this.front = null;
            this.rear = null;
        }else {
            this.front = this.front.next;
        }
        //有效数字要减1
        this.usedSize--;
        return oldData;
    }

    //尾插法入队
    @Override
    public void add(int item) {
        Node node = new Node(item);
        if(empty()) {
            this.front = node;
            this.rear = this.front;
        }else {
            this.rear.next = node;
            this.rear = node;
        }
        this.usedSize++;
    }

    @Override
    public int size() {
        return this.usedSize;
    }
}
