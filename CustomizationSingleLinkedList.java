//题目描述：实现一个支持泛型的单链表
/**
 * @ClassName CustomizationSingleLinkedList
 * @Description TODO
 * @Author L
 * @Date 2019/5/11 15:40
 * @Version 1.0
 **/
public class CustomizationSingleLinkedList<T> {

    class Node<T> {
        private T data;
        private Node next;

        public Node(T data,Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head;
    private int size;

    //创建空链表
    public CustomizationSingleLinkedList() {
        //TODO
        this.head = null;
        this.size = 0;
    }

    //以指定数据元素来创建链表，该链表只有一个元素
    public CustomizationSingleLinkedList(T element) {
        //TODO
        this.head = new Node<>(element,null);
        this.size++;
    }

    /**
     * 返回链表长度
     *
     * @return
     */
    public int length() {
        //TODO
        return this.size;
    }

    /**
     * 获取链表中指定索引的元素
     *
     * @param index
     * @return
     */
    public T get(int index) {
        //TODO
        Node cur = getNodeByIndex(index);
        return (T)cur.data;
    }

    private Node getNodeByIndex(int index) {
        //TODO
        if(index < 0 || index > length()) {
            throw new IllegalArgumentException("输入的index不合法");
        }
        Node<T> cur = this.head;
        if(this.head == null) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * 查找链表中指定元素的索引
     *
     * @param element
     * @return
     */
    public int locate(T element) {
        //TODO
        Node<T> cur = this.head;
        int curIndex = 0;
        while(cur != null) {
            //元素不为空的情况
            if(element != null) {
                //泛型比较使用equals()方法
                if(element.equals(cur.data)) {
                    return curIndex;
                }
            }else {
                //判断元素为空的情况
                if(element == cur.data) {
                    return curIndex;
                }
            }
            curIndex++;
            cur = cur.next;
        }
        return -1;
    }

    /**
     * 向线性表指定位置插入一个元素
     *
     * @param element
     * @param index
     */
    public void insert(T element, int index) {
        //TODO
        Node<T> node = new Node<>(element,null);
        Node<T> cur = this.head;
        //插入范围为[0,length]
        if(index < 0 || index > length()) {
            throw new IllegalArgumentException("index 超出插入范围 [" + 0 + "," + length() + "]");
        }
        if(cur == null) {
            this.head = node;
        }else {
            int count = 0;
            while (count < index - 1) {
                cur = cur.next;
                count++;
            }
            node.next = cur.next;
            cur.next = node;
        }
        this.size++;
    }

    /**
     * 采用尾插入法为链表添加新节点
     *
     * @param element
     */
    public void add(T element) {
        //TODO
        Node<T> node = new Node<>(element,null);
        Node<T> cur = this.head;
        if(cur == null) {
            this.head = node;
        }else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
        this.size++;
    }

    /**
     * 采用头插入法为链表添加新节点
     *
     * @param element
     */
    public void addAtHeader(T element) {
        //TODO
        Node<T> node = new Node<>(element,null);
        if(this.head == null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
        this.size++;
    }

    /**
     * 删除链表中指定索引处的元素
     *
     * @param index
     * @return
     */
    public T delete(int index) {
        //TODO
        //删除的范围为[0,length-1]
        if(index < 0 || index > length()-1) {
            throw new IllegalArgumentException("index不合法");
        }
        Node<T> cru = this.head;
        int count = 0;
        T data = null;
        if(index == 0) {
            data = cru.data;
            this.head = cru.next;
        }else {
            while (count < index - 1) {
                cru = cru.next;
                count++;
            }
            data = (T) cru.next.data;
            cru.next = cru.next.next;
        }
        this.size--;
        return data;
    }

    /**
     * 删除链表中最后一个元素
     *
     * @return
     */
    public T remove() {
        return this.delete(this.size - 1);
    }

    /**
     * 判断链表是否为空
     *
     * @return
     */
    public boolean empty() {
        //TODO
        return this.size == 0;
    }

    /**
     * 清空链表
     */
    public void clear() {
        //TODO
        this.size = 0;
        this.head = null;
    }

    @Override
    public String toString() {
        //TODO
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        Node cur = this.head;
        while(cur!=null) {
            sb.append(cur.data);
            sb.append(",");
            cur = cur.next;
        }
        if(!empty()) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CustomizationSingleLinkedList<String>  list = new CustomizationSingleLinkedList<>();
        //TODO
//        list.insert("java",0);
//        list.insert("C++",1);
//        list.insert("PHP",3);
//        list.add("java");
//        list.add("C++");
//        list.add("PHP");
        list.addAtHeader("");
        list.addAtHeader("C++");
        list.addAtHeader("PHP");
        System.out.println(list.locate(""));
//        System.out.println(list.get(0));
//        list.clear();
//        list.delete(1);
//        list.remove();
//        list.remove();
//        System.out.println(list.empty());
//        System.out.println(list.length());
        System.out.println(list.toString());
    }
}
