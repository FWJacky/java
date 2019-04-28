package 栈和队列习题;

/**
 * @ClassName TestMycircularQueue
 * @Description TODO
 * @Author L
 * @Date 2019/4/27 10:46
 * @Version 1.0
 **/
public class TestMycircularQueue {

    private int front;
    private int rear;
    private int[] elem;
    private int SIZE;
    private int usedSize;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public TestMycircularQueue(int k) {
        this.front = 0;
        this.rear = 0;
        this.elem = new int[k+1];
        this.SIZE = k+1;
        this.usedSize = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        this.elem[this.rear] = value;
        this.rear = (this.rear+1)%SIZE;
        this.usedSize++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }
        this.front = (this.front+1)%SIZE;
        this.usedSize--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("队列为空");
        }
    return this.elem[this.front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            throw new UnsupportedOperationException("队列为空");
        }
        int tmp = this.rear == 0 ? this.elem.length-1 : this.rear-1;
        return this.elem[tmp];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.front == this.rear;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if((this.rear+1)%SIZE == this.front) {
            return false;
        }
        return true;
    }
}
