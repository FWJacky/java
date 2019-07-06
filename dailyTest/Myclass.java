package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Myclass
 * @Description TODO
 * @Author L
 * @Date 2019/7/6 0:25
 * @Version 1.0
 **/
public class Myclass {

    public static int count(int n) {
        if(n<1 || n>100) {
            return 0;
        }else {
            return n/2;
        }
    }

    public static boolean isBracket(String str,int n) {
        int top = 0;
        for (int i = 0; i < n; i++) {
            if(str.charAt(i) == '(') {
                top++;
            }else if(str.charAt(i)==')') {
                top--;
            }else {
                return false;
            }
        }
        if(top<0 || top>n/2) {
            return false;
        }
        return top == 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while(in.hasNextInt()) {
            n = in.nextInt();
            if(n==0) {
                return;
            }else {
                System.out.println(count(n));
            }
        }
    }
}
