package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Tesr39
 * @Description TODO
 * @Author L
 * @Date 2019/7/18 10:23
 * @Version 1.0
 **/
public class Test39 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            int n = Integer.parseInt(in.nextLine());
            if(n == 0) {
                return;
            }
            String[] nums = in.nextLine().split(" ");
            String grade = in.nextLine();
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(grade.equals(nums[i])) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
