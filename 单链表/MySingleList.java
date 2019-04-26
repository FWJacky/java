package 单链表;

import 单链表.ILinked;

/**
 * @ClassName
 * @Description TODO
 * @Author L
 * @Date 2019/4/19 20:47
 * @Version 1.0
 **/
public class MySingleList implements ILinked {
    class Node  {
        private int data;
        public Node next;
        public Node (int data) {
            this.data = data;
        }
        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return next;
        }
    }
    private Node head;

    public Node getHead() {
        return head;
    }

    public MySingleList(){
        this.head = null;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if(this.head==null) {
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if(this.head==null) {
            this.head = node;
        }else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next=node;
        }
    }

    //检查index是否合法
    private void checkIndex(int index) {
        if(index<0 || index > getLength()) {
            throw new UnsupportedOperationException("Index不合法");
        }
    }

    //找到index-1的位置
    private Node searchIndex(int index) {
        Node cur = this.head;
//        for (int i = 0; i < index; i++) {
//            cur = cur.next;
//        }
        int count = 0;
        while(count < index-1) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    @Override
    public boolean addIndex(int index, int data) {
        checkIndex(index);
        if(index == 0) {
            addFirst(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = searchIndex(index);
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur != null) {
            if(cur.data==key) {
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    //查找关键字的前驱
    private Node searchPre(int key) {
        Node pre = this.head;
        //头节点是要删除的数据节点
        if(pre.data == key) {
            return this.head;
        }
        while(pre.next != null) {
            if(pre.next.data == key) {
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }
    @Override
    public int remove(int key) {
        Node cur = this.head;
        if(cur.data == key) {
            this.head = this.head.next;
            return cur.data;
        }
        while (cur.next != null) {
            if (cur.next.data == key) {
                Node oldNode = cur.next;
                cur.next = oldNode.next;
                return oldNode.data;
            }
            cur = cur.next;
        }
        throw new UnsupportedOperationException("不存在key节点");
    }

    @Override
    public void removeAllKey(int key) {
        if(this.head == null) {
//            throw new UnsupportedOperationException("不存在key字节");
            return;
        }
//        Node cur = this.head;
//        while(cur != null) {
//            remove(key);
//            cur = cur.next;
//        }
        Node pre = this.head;
        Node cur = pre.next;
        if(pre.data == key) {
            this.head = pre.next;
        }
        while (cur != null) {
            if(cur.data == key) {
                pre.next = cur.next;
                cur = cur.next;
            }
            else {
                pre = cur;
                cur = cur.next;
            }
        }
    }


    @Override
    public int getLength() {
        Node cur = this.head;
        int count = 0;
//        if(cur==null){
//            return 0;
//        }else {
        while(cur!=null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        //或者this.head = null;
        while(this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            this.head = cur;
        }
    }

    //反转单链表   反转后头节点变了  打印方法要改变
//    public Node reverseList() {
//        Node cur = this.head;
//        Node reverseHead = null;
//        Node pre = null;
//        while (cur != null) {
//            Node curNext = cur.next;
//            if(curNext == null) {
//                reverseHead = cur;
//            }
//            cur.next = pre;
//            pre = cur;
//            cur = curNext;
//        }
//        return reverseHead;
//    }
    public Node reverseList() {
        Node cur = this.head;
        //定义一个节点来记录前驱
        Node pre = null;
        //定义节点来记录反转后的新节点
        Node reverseHead = null;
        while(cur!=null) {
            //定义节点来记录后继
            Node curNext = cur.next;
            //当cur.next == null  此时已经遍历了一遍单链表
            if(curNext == null) {
                reverseHead=cur;
            }
            //核心步骤
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return reverseHead;
    }

    //重写反转后的打印方法
    public void show(Node reverseHead) {
        Node cur = reverseHead;
        while (cur != null) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
        System.out.println();
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个
    //中间结点。
    public Node middleNode() {
        Node cur = this.head;
        int i = 0;
        while(i<=(getLength()/2)) {
            cur = cur.next;
            i++;
        }
        return cur;
    }

    //给定一个带有头结点 head 的非空单链表，返回链表的中间结点。如果有两个中间结点，则返回第二个
    //中间结点。
    public Node middleNode2() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public Node findKthTotail(int k) {
        Node fast = this.head;
        Node slow = this.head;
//        if (fast == null || k <= 0 || k > getLength()) {
//            return null;
//        }

        if(fast == null || k <= 0) {
            System.out.println("没有这个节点");
            return null;
        }
        while(k-1 > 0) {
            if(fast.next != null) {
                fast = fast.next;
                k--;
            }else {   //相当于k>getlength()
                System.out.println("没有这个节点");
                return null;
            }
        }

        //fast先走k-1步
//        for (int i = 1; i < k; i++) {    //this.head  0    this.next  1     this.next.next   2
//            fast = fast.next;
//        }
        //同时走
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    //编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    //给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
    public Node partition(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        //pHead：用来遍历原有的单链表
        Node pHead = this.head;
        while(pHead != null) {
            //释放内存
            Node pHeadNext = pHead.next;
            pHead.next = null;

            if (pHead.data < x) {
                if (beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }else {
                    beforeEnd.next = pHead;
                    beforeEnd = pHead;
                }
            }else {
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }else {
                    afterEnd.next = pHead;
                    afterEnd = pHead;
                }
            }
            //释放内存
            pHead = pHeadNext;
        }
        if(beforeStart == null) {
            return afterStart;
        }
        beforeEnd.next = afterStart;
        return beforeStart;
    }

    //构造一个环
    public void createCycle() {
        Node cur = this.head;
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = this.head.next;
    }

    //给定一个链表，判断链表中是否有环。
    public boolean hasCycle() {
        //第一种写法
//        Node fast = this.head;
////        Node slow = this.head;
////        if(this.head == null || this.head.next == null) {
////            return false;
////        }
////        while(fast.next.next != null) {
////            fast = fast.next.next;
////            slow = slow.next;
////            if(fast == slow) {
////                return true;
////            }
////        }
////        return false;
        //第二种写法
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next !=  null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 NULL
    public Node detectCycle() {
        Node fast = this.head;
        Node slow = this.head;
        //先判断链表是否有环
        while(fast != null && fast.next !=  null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next==null) {
            return null;
        }
        slow = this.head;
        //进入这个循环  fast一定会等于slow
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//        public Node deleteDuplication() {
//        Node newHead = new Node(-1);
//        Node cur = this.head;
//        while(cur != null) {
//            if
//        }
//        return null;
//    }

    // 链表的回文结构
    public boolean chkPalindrome() {
        Node fast = this.head;
        Node slow = this.head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node p = slow.next;
        Node pNext = p.next;
        while(p != null) {
            p.next = slow;
            slow = p;
            p = pNext;
            if(pNext != null) {
                pNext = p.next;
            }
        }
        slow = this.head;
        while(slow != fast) {

        }
        return true;
    }

    //删除链表中等于给定值 val 的所有节点。
    public Node removeElements(int key) {
        //创建一个新的头节点  避免head.data==key 此时head = head.next;
        // 避免了头节点开始连续的多个节点的值 == key；
        Node newHead = new Node(-1);
        //将新的节点连接在单链表前，组成一个新的单链表，但是此时的单链表头节点仍然为head
        newHead.next = this.head;
        //创建一个节点用于遍历单链表，起始位置为newHead
        Node cur = newHead;
        //结束条件
        while(cur.next != null) {
            //如果cur.next的值 == key;那么 cur指向的下一个节点变为cur.next.next;
            // 此时newHead连接的单链表中就删除掉了cur.next这个节点
            if(cur.next.data == key) {
                cur.next = cur.next.next;
            }else {    //如果cur.next的值 != key,那么cur = cur.next;
                cur = cur.next;
            }
        }
        //从head开始打印单链表
        return newHead.next;
    }


    //反转一个单链表。  迭代算法
    public Node reverseList1() {
        //创建一个节点用来遍历单链表
        Node cur = this.head;
        //创建一个节点用来记录前驱
        Node pre = null;
        while(cur != null) {
            //创建一个节点用来记录后继
            Node curNext = cur.next;
            //迭代算法核心步骤
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        //返回反转后新的头节点
        return pre;
    }

    //反转一个单链表   递归
    public Node reverseList3(Node cur) {
        if(cur == null || cur.next == null) {
            return cur;
        }
        Node p = reverseList3(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return p;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public Node findKthTotail2(int k) {
        //判断输入的k合不合法，以及单链表是否为空
        if(k<=0 || this.head == null) {
            System.out.println("没有这个节点");
            return null;
        }
        //定义两个节点 一个快节点，一个慢节点
        Node fast = this.head;
        Node slow = this.head;
        //fast先走到k-1步的节点处
        while(k-1>0) {
            //如果还未退出循环，并且fast.next == null
            //说明输入的k超过了单链表的长度，k不合法
            if(fast.next == null) {
                System.out.println("没有这个节点");
                return null;
            }
            fast = fast.next;
            k--;
        }
        //此时 fast在k-1的节点处  同时移动fast和slow  直到fast.next == null
        //说明遍历完了单链表   此时slow节点处就是倒数第k个节点处
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //
    public Node partition2(int x) {
        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;
        while(pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.data < x) {
                if(beforeStart == null) {
                    beforeStart = pHead;
                    beforeEnd = beforeStart;
                }
                beforeEnd.next = pHead;
                beforeEnd = pHead;
            }else {
                if(afterStart == null) {
                    afterStart = pHead;
                    afterEnd = afterStart;
                }
                afterEnd.next = pHead;
                afterEnd = pHead;
            }
            pHead = pHeadNext;
        }
       if(beforeStart == null) {
            return afterStart;
       }
        beforeEnd.next = afterStart;
        return beforeStart;
    }
}
