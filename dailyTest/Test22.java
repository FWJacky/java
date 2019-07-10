package com.github.dailyTest;

import java.util.Scanner;
import java.util.UUID;

/**
 * @ClassName Test122
 * @Description TODO
 * @Author L
 * @Date 2019/7/10 10:37
 * @Version 1.0
 **/
public class Test22 {

    public static int pow(int n) {
       int count = 0;
        for (int i = 1; i <= n; i++) {
            int cur = i;
            while(cur % 5==0) {
                count++;
                cur /= 5;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while(in.hasNextInt()) {
            n = in.nextInt();
            System.out.println(pow(n));
        }
        in.close();
    }
}
