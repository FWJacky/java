package stack;

/**
 * @ClassName LinkedListStackDemo
 * @Description TODO 单链表实现栈
 * @Author L
 * @Date 2019/8/4 22:34
 * @Version 1.0
 **/

class LinkedListStack {

    private Node top = new Node(-1); // 栈顶
    class Node {
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    // 入栈 --- 采用头插法
    public void push(int value) {
        Node e = new Node(value);
        if(top.next == null) {
            top.next = e;
        }else {
            e.next = top.next;
            top.next = e;
        }
    }

    // 出栈
    public int pop() {
        int data = -1;
        if(top.next == null) {
            System.out.println("栈为空");
            return -1;
        }else {
            data = top.next.value;
            top.next = top.next.next;
        }
        return data;
    }

    // 查看栈顶元素
    public int peek() {
        if(top.next == null) {
            return -1;
        }else {
            return top.next.value;
        }
    }

    // 判断栈是否为空
    public boolean isEmpty() {
        return this.top.next == null;
    }

    // 返回栈的大小
    public int size() {
        Node temp = top;
        int count = 0;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // 打印栈中的元素
    public void list() {
        Node temp = top;
        if(isEmpty()) {
            System.out.println("栈为空");
        }
        while(temp.next != null) {
            System.out.println(temp.next.value);
            temp = temp.next;
        }
    }
}

public class LinkedListStackDemo {
    // 测试
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        for (int i = 0; i < 5; i++) {
            linkedListStack.push(i);
        }
//        System.out.println(linkedListStack.pop());
//        System.out.println(linkedListStack.pop());
//        System.out.println(linkedListStack.pop());
//        System.out.println(linkedListStack.pop());
//        System.out.println(linkedListStack.pop());
//        System.out.println(linkedListStack.pop());
//        linkedListStack.list();
        System.out.println(linkedListStack.peek());
    }
}
