package com.github.dailyTest;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName Test8
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 23:20
 * @Version 1.0
 **/
public class Test8 {

    public static boolean isBracket(char ch) {
        if ('(' == ch || '[' == ch || '{' == ch || ')' == ch || ']' == ch || '}' == ch) {
            return true;
        }
        return false;
    }

    public static boolean chkParenthesis(String A, int n) {
        char[] stack = new char[n];
        int top = 0;
        for (int i = 0; i < n; i++) {
            if(A.charAt(i) == '(' && top>=0) {
                stack[top++] = A.charAt(i);
            }else if(A.charAt(i) == ')' && top>=0) {
                top--;
            }else {
                return false;
            }
        }
        if(top == 0) {
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "())()()(((d";
        System.out.println(chkParenthesis(str, 11));
    }


//    public static boolean isBracket(String str,int n) {
//        int top = 0;
//        for (int i = 0; i < n; i++) {
//            if(str.charAt(i) == '(') {
//                top++;
//            }else if(str.charAt(i)==')') {
//                top--;
//            }else {
//                return false;
//            }
//        }
//        if(top<0 || top>n/2) {
//            return false;
//        }
//        return top == 0;
//    }
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while(in.hasNextLine()) {
//            String str = in.nextLine();
//            System.out.println(isBracket(str,str.length()));
//        }
//    }
}
