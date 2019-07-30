package dailyTest;

/**
 * @ClassName Test51
 * @Description TODO
 * @Author L
 * @Date 2019/7/24 23:47
 * @Version 1.0
 **/

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Test51 {
    public ListNode plusAB(ListNode a, ListNode b) {
        // write code here
        ListNode head = new ListNode(-1);
        ListNode result = head;
        int carry = 0;
        while(a!=null || b!=null || carry!=0) {
            int aVal = a == null ? 0 : a.val;
            int bVal = b == null ? 0 : b.val;

            int sum = aVal + bVal + carry;
            carry = sum % 10;
            int nodeVal = sum / 10;
            result.next = new ListNode(nodeVal);
            result = result.next;
            a = a == null ? null : a.next;
            b = b == null ? null : b.next;
        }
        return head.next;
    }

}
