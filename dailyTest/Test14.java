package com.github.dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test14
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 22:17
 * @Version 1.0
 **/
public class Test14 {

    public static void countSameNumber(int[] a,int n) {
        //先将数组进行排序
        Arrays.sort(a);
        //创建一个数组来存放重复数字的个数，下标即为重复的数字，值即为重复的个数
        //数组
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = 0;
        }
        for (int i = 0; i < n; i++) {
            int tmp = a[i];
            numbers[tmp]++;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                continue;
            }
            if (numbers[i] >= (n / 2)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            StringBuffer sb = new StringBuffer(in.nextLine());
            for (int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == ' ') {
                    sb.deleteCharAt(i);
                }
            }
            int[] a = new int[sb.length()];
            for (int i = 0; i < sb.length(); i++) {
                a[i] = Integer.valueOf(String.valueOf(sb.charAt(i)));
            }
            countSameNumber(a, a.length);
        }
        in.close();
    }
}
