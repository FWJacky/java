package linkedList;


/**
 * @ClassName LinkedList
 * @Description TODO  单链表(以下单链表为带头节点的单链表)实际应用之一：用于水浒英雄的排名
 * @Author L
 * @Date 2019/7/26 20:09
 * @Version 1.0
 * <p>
 * 需要按照编号的顺序添加的思路：
 * 1. 首先找到新添加的节点的位置，是通过辅助变量（指针）temp遍历
 * 2. 新的节点.next = temp.next
 * 3. 将temp.next = 新的节点
 * <p>
 * 需要按照编号的顺序添加的思路：
 * 1. 首先找到新添加的节点的位置，是通过辅助变量（指针）temp遍历
 * 2. 新的节点.next = temp.next
 * 3. 将temp.next = 新的节点
 * <p>
 * 需要按照编号的顺序添加的思路：
 * 1. 首先找到新添加的节点的位置，是通过辅助变量（指针）temp遍历
 * 2. 新的节点.next = temp.next
 * 3. 将temp.next = 新的节点
 **/

// 带头节点的单链表最重要的一个地方就是头结点不能动，因此在遍历的时候需要辅助变量（temp）来遍历


/**
 * 需要按照编号的顺序添加的思路：
 * 1. 首先找到新添加的节点的位置，是通过辅助变量（指针）temp遍历
 * 2. 新的节点.next = temp.next
 * 3. 将temp.next = 新的节点
 **/

import java.util.Stack;

/**
 从单链表中删除一个节点的思路：
 1. 我们先找到需要删除的这个节点的前一个节点 temp
 2. temp.next = temp.next.next
 3. 被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收
 **/


// 定义一个SingleLinkedList 来管理我们的英雄
public class SingleLinkedList {

    // 定义HeroNode，每个HerNode 对象就是一个节点
    static class HeroNode {
        private int no;
        private String name;
        private String nickName;
        public HeroNode next;

        public HeroNode(int no, String name, String nickName) {
            this.no = no;
            this.name = name;
            this.nickName = nickName;
            this.next = null;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickName='" + nickName + '\'' +
                    '}';
        }
    }

    // 先初始化一个头结点，头结点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    // 添加节点到单向链表
    // 思路，当不考虑编号顺序时
    // 1. 找到当前链表的最后节点
    // 2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {

        // 因为head节点不能动，因此我们需要一个辅助遍历temp
        HeroNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = heroNode;
    }


    // 第二种方式在添加英雄时，根据排名将英雄插入到指定位置
    // 如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        // 因为头结点不能动，因此我们仍然通过一个辅助指针（变量）来帮忙找到添加的位置
        // 因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false; // 标志添加的编号是否存在，默认是false
        while (temp.next != null) {
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
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
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    // 修改节点的信息，根据no编号来修改，即no编号不能改
    // 说明
    // 1. 根据 newHeroNode 的 no 来修改即可
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 找到需要修改的节点，根据no编号
        // 定义一个辅助变量
        HeroNode temp = head;
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


    //删除节点
    // 思路
    // 1. head节点不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    // 2. 说明我们在比较时，是temp.next.no 和 需要和删除的节点的no比较
    public void del(int no) {
        HeroNode temp = head;
        boolean flag = false; // 标志是否找到待删除的节点
        while (temp.next != null) {
            if (temp.next.no == no) {
                // 找到的待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        // 判断flag
        if (flag) {
            // 可以删除
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的" + no + "号编号的英雄不存在");
        }
    }


    // 查找
    public void search(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (temp != null) {
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号为" + no + "的英雄为：" + temp);
        } else {
            System.out.println("编号为" + no + "的英雄不存在");
        }
    }

    // 显示链表【遍历】
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
        }
        // 因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 方法：获取到单链表的节点的个数（如果是带头结点的链表，需要不统计头结点

    /**
     *
     * @param head 链表的头结点
     * @return 返回的就是有效节点的个数
     */
    public int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int len = 0;
        HeroNode cur = head.next;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        return len;
    }

    // 查找单链表中的倒数第K个节点【新浪面试题】
    public HeroNode findKthTotail(int k) {
        HeroNode fast = head.next;
        HeroNode slow = head.next;
        if (fast == null || k <= 0) {
            System.out.println("没有这个节点");
            return null;
        }
        // fast 先走k-1
        while (k - 1 > 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                System.out.println("没有这个节点");
                return null;
            }
        }

        // fast 和 slow 一起走
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // 单链表的反转【腾讯面试题】
    public HeroNode reverse(HeroNode head) {
        HeroNode cur = head.next;
        HeroNode pre = null;
        HeroNode newHead = null;
        while (cur != null) {
            HeroNode curNext = cur.next;
            newHead = cur;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return newHead;
    }

    // 反转单链表迭代
    public HeroNode reverse2(HeroNode head) {
        HeroNode cur = head;
        HeroNode pre = null;
        while (cur != null) {
            HeroNode curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }

    // 反转单链表递归
    public HeroNode reverse3(HeroNode cur) {
        if (cur == null || cur.next == null) {
            return head;
        }
        HeroNode p = reverse3(cur.next);
        cur.next.next = cur;
        cur.next = null;
        return p;
    }

    // 从尾到头打印单链表（不是反转单链表）
    // 思路：
    // 可以利用栈，将各个节点压入栈中，然后利用栈的先进后出的特点，就实现了逆序打印的效果
    public void printListFromTailToHead(HeroNode head) {
        if (head.next == null) {
            return; // 空链表，不能打印
        }
        // 创建一个栈，将各个节点压入栈中
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }


        // 将栈中的节点进行打印
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    public HeroNode getHead() {
        return head;
    }

    public static void main(String[] args) {
        // 进行测试
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList list = new SingleLinkedList();
        // 加入链表
//        list.add(hero1);
//        list.add(hero2);
//        list.add(hero3);
//        list.add(hero4);

        // 加入按照编号的顺序
        list.addByOrder(hero1);
        list.addByOrder(hero4);
        list.addByOrder(hero2);
        list.addByOrder(hero3);
        list.list();

        System.out.println(list.reverse(list.getHead()));


//        // 查看单链表单数第k个节点
//        System.out.println(list.findKthTotail(4));
//
//        System.out.println();
//
//        // 测试修改节点的代码
//        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~~");
//        list.update(newHeroNode);
//
//        // 删除一个节点
//        list.del(1);
//        list.del(2);
//        list.del(4);
//        list.del(5);
//
//        System.out.println();
//        //查找一个节点
//        list.search(3);
//
//        // 获取单链表的有效长度
//        System.out.println(list.getLength(list.getHead()));
//
//        System.out.println("删除后链表的情况");
//        // 打印链表
//        list.list();
    }
}
