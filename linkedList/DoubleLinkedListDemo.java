package linkedList;

/**
 * @ClassName DoubleLinkedList
 * @Description TODO
 * @Author L
 * @Date 2019/7/27 0:38
 * @Version 1.0
 **/
class DoubleLinkedList {
    // 先初始化一个头结点，头结点不要动，不存放具体的数据
    private Node head = new Node(0, "", "");

    // 返回头结点
    public Node getHead() {
        return head;
    }

    // 遍历双向链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        // 因为头结点不能动，因此我们需要一个辅助变量来遍历
        Node temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 添加一个节点到双向链表最后
    public void add(Node heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // 形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改一个节点的内容，可以看到双向链表的节点内容修改和单向链表一样
    // 只是节点的类型改成了Node
    public void update(Node newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        Node temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == newHeroNode.no) {
                // 说明找到了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            // 没有找到
            System.out.println("没有找到编号为：" + newHeroNode.no + "的英雄");
        }
    }

    // 删除双向链表中的一个节点
    // 说明
    // 1. 对于双向链表，我们可以直接找到要删除的节点
    // 2. 找到后，自我删除即可
    public void del(int no) {

        // 判断当前链表是否为空
        if (head.next == null) {
            System.out.println("链表为空，无法删除");
            return;
        }

        Node temp = head.next;
        boolean flag = false; // 标志是否找到待删除的节点
        while (temp != null) {
            if (temp.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if (flag) {
            // 可以删除
            temp.pre.next = temp.next;
            // 如果是最后一个节点，就不需要执行下面这行代码，否则出现空指针异常
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的" + no + "号编号的英雄不存在");
        }
    }

    // 按照编号顺序添加
    public void addByOrder(Node heroNode) {
        // 因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮忙找到添加的位置
        // 因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        Node temp = head.next;
        boolean flag = false; // 标志添加的编号是否存在，默认是false
        while (temp != null) {
            if (temp.no > heroNode.no) {
                break;
            } else if (temp.no == heroNode.no) {
                flag = true; // 说明编号存在
                break;
            }
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {
            System.out.println("准备插入的英雄的编号：" + heroNode.no + "已经存在了，不能加入");
        } else {
            // 插入到链表中，temp的后面
            if(temp !=null) {
                heroNode.pre = temp.pre;
                temp.pre.next = heroNode;
                heroNode.next = temp;
            }else {
                add(heroNode);
            }
        }
    }
}

//定义Node，每个Node对象就是一个节点
class Node {
    public int no;
    public String name;
    public String nickName;
    public Node next;//指向下一个节点，默认为null
    public Node pre;//指向上一个节点，默认为null

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}

public class DoubleLinkedListDemo {

    public static void main(String[] args) {
        // 测试
        System.out.println("双向链表的测试");
        Node node0 = new Node(0, "李逵", "黑旋风");
        Node node1 = new Node(1, "宋江", "及时雨");
        Node node2 = new Node(2, "卢俊义", "玉麒麟");
        Node node3 = new Node(3, "吴用", "智多星");
        Node node4 = new Node(4, "林冲", "豹子头");

        // 创建一个双向链表
        DoubleLinkedList list = new DoubleLinkedList();

        // 添加
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);

        list.list();

        // 修改
        Node newNode = new Node(4, "公孙胜", "入云龙");
        list.update(newNode);
        System.out.println("修改过后的链表情况");
        list.list();

        // 删除
        list.del(3);
        System.out.println("删除后的链表情况");
        list.list();

        // 按照编号顺序添加
        list.addByOrder(node1);
        list.addByOrder(node3);
        list.addByOrder(node4);
        list.addByOrder(node2);
        list.addByOrder(node0);
        list.list();
    }
}
