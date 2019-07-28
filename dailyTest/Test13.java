package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test13
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 22:01
 * @Version 1.0
 **/
public class Test13 {

    public static boolean right(int a) {
        if (a < -30 || a > 30) {
            return false;
        }
        return true;
    }

    public static void suger(int[] a) {
        int A = (a[0] + a[2]) / 2;
        int B = (a[1] + a[3]) / 2;
        int C = (a[3] - a[1]) / 2;
        if (right(A) && right(B) && right(C)&&(A-B==a[0])) {
            System.out.print(A + " " + B + " " + C);
        }else {
            System.out.print("No");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int[] a = new int[4];
            for (int i = 0; i < a.length; i++) {
                a[i] = in.nextInt();
                if(!right(a[i])) {
                    System.out.print("No");
                    return;
                }
            }
            suger(a);
        }
        in.close();
    }
}
