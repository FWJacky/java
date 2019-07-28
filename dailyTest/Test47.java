package dailyTest;

/**
 * @ClassName Tesr47
 * @Description TODO
 * @Author L
 * @Date 2019/7/23 11:41
 * @Version 1.0
 **/
public class Test47 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode partition(ListNode pHead, int x) {
        // write code here
        if(pHead == null) {
            return null;
        }
        ListNode lowHead = null;
        ListNode highHead = null;
        ListNode lowEnd = null;
        ListNode highEnd = null;
        while (pHead!=null) {
            ListNode pHeadNext = pHead.next;
            pHead.next = null;
            if(pHead.val <  x) {
                if(lowHead == null) {
                    lowHead = pHead;
                    lowEnd = lowHead;
                }else {
                    lowEnd.next = pHead;
                    lowEnd = pHead;
                }
            }else {
                if(highHead == null) {
                    highHead = pHead;
                    highEnd = highHead;
                }else {
                    highEnd.next = pHead;
                    highEnd = pHead;
                }
            }
            pHead = pHeadNext;
        }
        if(lowHead == null) {
            return highHead;
        }
        lowEnd.next = highHead;
        return highHead;
    }
}
