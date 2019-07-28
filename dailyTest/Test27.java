package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test27
 * @Description TODO
 * @Author L
 * @Date 2019/7/12 13:33
 * @Version 1.0
 **/
public class Test27 {

    public static void function(String n) {
        int[] num = new int[10];
        for (int i = 0; i< n.length(); i++) {
            int tmp = Integer.parseInt(String.valueOf(n.charAt(i)));
            num[tmp]++;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] == 0) {
                continue;
            }
            System.out.print(i + ":" + num[i]+" ");
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            StringBuilder sb = new StringBuilder(in.nextLine());
            int i = 0;
            if (sb.length() > 1000) {
                return;
            }
            function(sb.toString());
        }
        in.close();
    }
}
