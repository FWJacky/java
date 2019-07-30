/**
 * @ClassName Solution12
 * @Description TODO
 * @Author L
 * @Date 2019/7/27 23:55
 * @Version 1.0
 **/

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫问题
 **/
public class Solution12 {
    class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public int getResult(int n, int m) {
        // write code here
        Node head = new Node(1);
        Node p = head;
        for (int i = 2; i <= n; i++) {
            p.next = new Node(i);
            p = p.next;
        }
        p.next = head;
        while (n > 0) {
            int i = m;
            while (i > 1) {
                p = p.next;
                i--;
            }
            p.next = p.next.next;
            n--;
        }
        return p.val;
    }

    public int joseph(int n, int m) {
        if (n == 1) {
            return n;
        }
        return (joseph(n - 1, m) + m - 1) % n + 1;
    }

    public static void main(String[] args) {
        Solution12 s = new Solution12();
//        System.out.println(s.getResult(5, 3));
        System.out.println(s.joseph(5, 3));
    }
}
