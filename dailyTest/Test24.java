package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test25
 * @Description TODO   将一个数每次都只能-1或者+1，将其转换成费波那列数需要的最小步数。
 * @Author L
 * @Date 2019/7/11 15:15
 * @Version 1.0
 **/
public class Test24 {
    public static int fibonacci(int target) {
        int rectCover1 = 0;
        int rectCover2 = 1;
        int num = 0;
        int leftCount = 0 ;
        int rightCount = 0;
        while(true) {
            num = rectCover1 + rectCover2;
            rectCover1 = rectCover2;
            rectCover2 = num;
            if(num<target) {
                leftCount = target - num;
            }else {
                rightCount = num - target;
                break;
            }
        }
        if(leftCount<rightCount) {
            return leftCount;
        }
        return rightCount;
    }

    public static int fibonacci2(int n) {
        int a = 0;
        int b = 1;
        int c = 1;
        while(c<n) {
            a = b;
            b = c;
            c = a +b ;
        }
        int dis1 = n-b;
        int dis2 = c-n;
        return dis1>dis2?dis2:dis1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
            int n = in.nextInt();
//            System.out.println(fibonacci(n));
        System.out.println(fibonacci2(n));
    }
}
