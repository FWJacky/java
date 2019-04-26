package 不带头双向链表;

/**
 * @ClassName DoubleLinkedList
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 16:27
 * @Version 1.0
 **/
public class DoubleLinkedList implements IDoubleLinked {

    class Node {
        private int data;
        private Node next; //后继
        private Node pre;  //前驱
        public Node(int data) {
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }
    private Node head;
    private Node last;
    public DoubleLinkedList() {
        this.head = null;
        this.last = null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head == null) {
            this.last = node;
            this.head = node;
        }else {
            node.next = this.head;
            this.head.pre = node;  // node.pre = node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if(this.head==null) {
            addFirst(data);
        }else {
            this.last.next = node;
            node.pre = this.last;
            this.last = node;
        }
    }

    //检查index的合法性
    public void checkIndex(int index) {
        if(index<0||index>getLength()) {
            throw new UnsupportedOperationException("index不合法");
        }
    }
    //查找index的前驱
    public Node searchIndex(int index) {
        checkIndex(index);
        int count = 0;
        Node cur = this.head;
        while (count < index) {
            cur = cur.next;
            count ++;
        }
        return cur;
    }
    @Override
    public boolean addindex(int index, int data) {
        if(index == 0) {
            addFirst(data);
            return true;
        }
        if(index == getLength()) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur;
        node.pre = cur.pre;
        cur.pre.next = node;
        cur.pre = node;
        return false;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur!=null) {
            if(cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //再研究研究
    @Override
    public int remove(int key) {
        Node cur = this.head;
        while(cur!=null) {
            if(cur.data == key) {
                int oldData = cur.data;
                //要删除的节点为头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                }else {
                    cur.pre.next = cur.next;
                    //cur.next!=null 表示删除的不是尾节点
                    if(cur.next!=null) {
                        cur.next.pre = cur.pre;
                    }else {
                        //尾节点删除，last需要移动
                        this.last = cur.pre;
                    }
                }
                return oldData;
            }
            cur= cur.next;
        }
        return -1;
    }

    //再研究研究
    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while(cur!=null) {
            if(cur.data == key) {
                int oldData = cur.data;
                //要删除的节点为头节点
                if(cur == this.head) {
                    this.head = this.head.next;
                    this.head.pre = null;
                }else {
                    cur.pre.next = cur.next;
                    //cur.next!=null 表示删除的不是尾节点
                    if(cur.next!=null) {
                        cur.next.pre = cur.pre;
                    }else {
                        //尾节点删除，last需要移动
                        this.last = cur.pre;
                    }
                }
            }
            cur= cur.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur!=null) {
            cur = cur.next;
            count ++;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //没搞清楚
    @Override
    public void clear() {
        while(this.head.next != null) {
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.pre = null;
        }
        this.head = null;
        this.last = null;
    }
}
