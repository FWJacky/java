package 带头节点循环单链表;

/**
 * @ClassName HeadSingleList
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 14:43
 * @Version 1.0
 **/
public class HeadSingleList implements ICLinked {


    class Node {
        private int data;
        private Node next;
        //头节点
        public Node() {
            this.data = -1;
        }
        //数据节点
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    public HeadSingleList() {
        //带头循环单链表必须要有头节点，创建头节点
        this.head = new Node();
        //只有头节点时也是循环的，即它本身指向它本身
        this.head.next = this.head;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        while(cur.next!=this.head) {
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
    }

    //检查index是否合法
    public void checkIndex(int index) {
        if(index<0 || index>getLength()) {
            throw new UnsupportedOperationException("index不合法");
        }
    }

    //查找index的前驱
    public Node searchIndex(int index) {
        checkIndex(index);
        Node cur = this.head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //没搞清楚
    @Override
    public boolean addindex(int index, int data) {
        Node pre = searchIndex(index);
        Node node = new Node(data);
        node.next = pre.next;
        pre.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur!=this.head) {
            if(cur.data==key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    //找到关键字key的前驱
    private Node searchPre(int key) {
        Node pre = this.head;
        while(pre.next != this.head) {
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        if(pre == null) {
            throw new UnsupportedOperationException("没有key这个关键字");
        }
        Node del = pre.next;
        int oldData = del.data;
        pre.next = del.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node pre = this.head;
        while(cur != this.head) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head.next;
        while(cur!=this.head) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur!=this.head) {
        System.out.print(cur.data+" ");
        cur = cur.next;
    }
        System.out.println();
}

    @Override
    public void clear() {
        while(this.head.next != this.head) {
            Node cur = this.head.next;
            this.head.next = cur.next;
        }
        this.head = null;
    }
}
