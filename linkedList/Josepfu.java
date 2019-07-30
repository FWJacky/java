package linkedList;

/**
 * @ClassName SingleCircularLinkedListDemo
 * @Description TODO
 * @Author L
 * @Date 2019/7/27 23:08
 * @Version 1.0
 **/

/**
 * 构建一个单向的环形链表的思路
 * 1. 先创建第一个节点，让first指向该节点，并形成环形
 * 2. 后面当我们每创建一个新的节点，就把该节点，加入到已有的环形链表中即可
 * <p>
 * 遍历环形链表
 * 1. 先让一个辅助指针（变量）curBoy，指向first节点
 * 2. 然后通过一个while循环遍历环形链表即可，curBoy.next==first结束
 **/

// 创建一个Boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}

// 创建一个环形的单向链表
class SingleCircularLinkedList {
    // 先创建一个first节点，当前没有编号
    private Boy first;

    //添加节点，构建成一个环形链表
    public void addBoy(int nums) {
        // nums 做一个数据校验
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }
        // 辅助指针，帮助构建环形链表
        Boy curBoy = null;
        // 使用一个for循环来创建我们的环形链表
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy boy = new Boy(i);
            // 如果是第一个小孩
            if (i == 1) {
                first = boy;
                // 构成一个环
                first.setNext(first);
                // 让curBoy指向第一个小孩
                curBoy = first;
            }
            curBoy.setNext(boy);
            boy.setNext(first);
            curBoy = boy;
        }
    }

    // 遍历当前环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩~~~");
            return;
        }
        // 因为first不能动，因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (curBoy.getNext() != first) {
            System.out.println("小孩的编号：" + curBoy.getNo());
            curBoy = curBoy.getNext();
        }
        System.out.println("小孩的编号：" + curBoy.getNo());
    }

    // 出环
    /**
     根据用户的输入，生成一个小孩的出环的顺序 ---- 单向链表的删除和出环都需要一个辅助指针指向待删除节点前一个位置
     1. 需要创建一个辅助指针（变量）helper，事先应该指向环形链表的最后这个节点
     补充：报数前，现让first和helper移动 k-1 次 ，即移动到开始报数的小孩处
     2. 当小孩报数时，让first和helper指针同时的移动m-1次
     3. 这时就可以将first指向的小孩节点出环
     first = first.next
     helper.next = first
     需要删除的节点就没有任何引用了，就会被垃圾回收机制回收
     **/
    // 根据用户的输入，计算出出环的顺序

    /**
     * @Param startNo 表示从第几个小孩开始报数
     * @Param countNum 表示数几下
     * @Param nums 表示最初有几个小孩在环中
     **/
    public void countBoy(int startNo, int countNum, int nums) {
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }
        // 创建辅助指针，帮助完成小孩出环
        Boy helper = first;
        // 需要创建一个辅助指针（变量）helper，事先应该指向环形链表的最后这个节点
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // 报数前，现让first和helper移动 k-1 次 ，即移动到开始报数的小孩处
        for (int i = 0; i < startNo-1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        // 开始报数 ---- 当小孩报数时，让first和helper指针同时的移动m-1次
        // 这里是一个循环操作，知道环中只有一个节点
        while(helper != first) {
            // 让first 和 helper 指针同时的移动 countNum - 1
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // 这时first指向的节点，就是要出环的节点
            System.out.println("小孩"+first.getNo()+"出环");
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最后留在环中的小孩"+first.getNo());
    }
}


public class Josepfu {

    public static void main(String[] args) {
        // 测试  看看构建环形链表 和 遍历环形链表是否OK
        SingleCircularLinkedList singleCircularLinkedList = new SingleCircularLinkedList();
        singleCircularLinkedList.addBoy(5);
//        singleCircularLinkedList.showBoy();

        // 测试小孩出环是否正确
        singleCircularLinkedList.countBoy(1, 2, 5);
    }
}
