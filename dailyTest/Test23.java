package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test23
 * @Description TODO
 * @Author L
 * @Date 2019/7/10 11:27
 * @Version 1.0
 **/
public class Test23 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String nums = String.valueOf(num);
        StringBuilder sb = new StringBuilder(nums);
        StringBuilder reverseNum = sb.reverse();
        System.out.println(reverseNum);
    }
}
