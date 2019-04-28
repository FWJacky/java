package 单链表;

/**
 * @ClassName
 * @Description TODO
 * @Author L
 * @Date 2019/4/19 21:16
 * @Version 1.0
 **/
public class Testmain {
    public static MySingleList.Node mergeTwoLists(MySingleList.Node headA,
                                                  MySingleList.Node headB) {
        MySingleList mySingleList = new MySingleList();
        MySingleList.Node newHead = mySingleList.new Node(-1);
        MySingleList.Node tmpHead = newHead;
        while(headA != null && headB != null) {
            if(headA.getData() >= headB.getData()) {
                newHead.next = headB;
                newHead = headB;
                headB = headB.next;
            }else {
                newHead.next = headA;
                newHead = headA;
                headA = headA.next;
            }
        }
        if(headA != null) {
            newHead.next = headA;
        }
        if(headB != null) {
            newHead.next = headB;
        }
        return tmpHead.next;
    }
    public static void create() {

    }
    public static MySingleList.Node getIntersectionNode
            (MySingleList.Node headA, MySingleList.Node headB) {
        MySingleList.Node pLong = headA;
        MySingleList.Node pShort = headB;
        int lenA = 0;
        while(pLong != null) {
            lenA++;
            pLong = pLong.getNext();
        }
        int lenB = 0;
        while(pShort != null) {
            lenB++;
            pShort = pShort.getNext();
        }
        pLong = headA;
        pShort = headB;

        int myLen = lenA-lenB;

        if(myLen < 0) {
            pLong = headB;
            pShort = headA;
            myLen = lenB-lenA;
        }
        for (int i = 0; i < myLen; i++) {
            pLong = pLong.getNext();
        }

        //起点相同了
//        while(pLong !=null&& pShort!=null && pLong != pShort) {
//            pLong = pLong.getNext();
//            pShort= pShort.getNext();
//        }
//        if(pLong == pShort && pLong !=null && pShort!=null) {
//            return pLong;
//        }
        while(pLong != null && pLong.getNext() != null) {
            if (pLong == pShort) {
                return pLong;
            }
            pLong = pLong.getNext();
            pShort = pShort.getNext();
        }
        return null;
    }

    //找到两个单链表相交的起始节点。
    public static MySingleList.Node getIntersectionNode2(MySingleList.Node headA,
                                                         MySingleList.Node headB) {
        MySingleList.Node pLong = headA;
        MySingleList.Node pShort = headB;
        int lenA = 0;
        while(pLong != null) {
            lenA ++;
            pLong = pLong.next;
        }
        int lenB = 0;
        while(pShort != null) {
            lenB ++;
            pShort = pShort.next;
        }
        //此时pLong和pShort 已经改变了位置  走到了链表尾节点处
        //需要将其重新从头节点开始
        pLong = headA;
        pShort = headB;
        int myLen = lenA - lenB;

        if(myLen< 0) {
            pLong = headB;
            pShort = headA;
            myLen = lenB - lenA;
        }
        for (int i = 0; i <myLen ; i++) {
            pLong = pLong.next;
        }
        while(pLong != null && pShort != null) {
            //需要先进行判断  因为有可能两个单链表  头节点就相交了
            //例如  两个单链表的节点都为1时
            if(pLong == pShort) {
                return pLong;
            }
            pLong = pLong.next;
            pShort = pShort.next;
        }
        return null;
    }



    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(2);
        mySingleList.addLast(1);
        mySingleList.display();
        System.out.println(mySingleList.chkPalindrome2());

    }
    public static void main1(String[] args) {
        MySingleList mySingleList = new MySingleList();
//        mySingleList.addFirst(2);
//        mySingleList.addFirst(17);
//        mySingleList.addFirst(9);
//        mySingleList.addFirst(3);
//        mySingleList.addFirst(25);
//        mySingleList.addFirst(5);
//        System.out.println(mySingleList.addIndex(6,4));
        mySingleList.addLast(1);
        mySingleList.addLast(2);
        mySingleList.addLast(4);
        mySingleList.display();
        MySingleList mySingleList2 = new MySingleList();
        mySingleList2.addLast(1);
        mySingleList2.addLast(3);
        mySingleList2.addLast(4);
        mySingleList2.display();
        System.out.println("=================");
        mySingleList.show(mergeTwoLists(mySingleList.getHead(),mySingleList2.getHead()));
//        mySingleList.reverseList3(mySingleList.getHead());
//        mySingleList.show(mySingleList.reverseList3(mySingleList.getHead()));
//        System.out.println(mySingleList.reverseList3(mySingleList.getHead()).getData());
//        mySingleList.show(mySingleList.reverseList1());
//        mySingleList.removeElements(6);
//        mySingleList.display();
//        mySingleList.addLast(5);
//        mySingleList.createCycle();
//        System.out.println(mySingleList.detectCycle().getData());
//        mySingleList.addLast(72);

//        mySingleList.display();
//        System.out.println(mySingleList.hasCycle());
//        mySingleList.partition(17);
//        mySingleList.display();
//        MySingleList.Node cur = mySingleList.findKthTotail(2);
//        System.out.println(cur.getData());
//        System.out.println(mySingleList.findKthTotail(2));
//        MySingleList.Node node = mySingleList.middleNode();

//        mySingleList.reverseList();

//        mySingleList.addIndex(0,3);
//        mySingleList.display();
//        mySingleList.reverseList();
//        mySingleList.show(mySingleList.reverseList());
//        mySingleList.clear();
//        mySingleList.removeAllKey(25);
//        mySingleList.clear();
//        mySingleList.addIndex(4,8);
//        mySingleList.addIndex(8,100);
        //        mySingleList.addIndex(12,100);

//        mySingleList.addLast(77);
//        mySingleList.addLast(79);
//        mySingleList.addLast(45);
//        mySingleList.addLast(65);
//        mySingleList.remove(25);
//        System.out.println(mySingleList.remove(25));
//        mySingleList.remove(25);
//        System.out.println(mySingleList.remove(9));
//        System.out.println(mySingleList.getLength());
//        mySingleList.display();
//        System.out.println(mySingleList.contains(10));


    }
}
