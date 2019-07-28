package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test31
 * @Description TODO
 * @Author L
 * @Date 2019/7/15 11:09
 * @Version 1.0
 **/
public class Test31 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String[] num = str.split(" ");
        int n = Integer.parseInt(num[0]);
        String c = num[1];
        int i = 0;
        while(i<n) {
            if(i == 0 || i==n-1) {
                for (int j = 0; j < n; j++) {
                    System.out.print(c);
                }
                System.out.println();
            }else {
                while(i<Math.round((double) n/2)-1) {
                    for (int j = 0; j < n; j++) {
                        if (j == 0 || j == n - 1) {
                            System.out.print(c);
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                    i++;
                }
            }
            i++;
        }
    }
}
