package com.github.dailyTest;

/**
 * @ClassName Test13
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 1:08
 * @Version 1.0
 **/
import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.empty()) {
            while(!stack1.empty()) {
                int data = stack1.pop();
                stack2.push(data);
            }
            return stack2.pop();
        }else {
            return stack2.pop();
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
