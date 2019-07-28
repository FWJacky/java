package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test21
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 18:31
 * @Version 1.0
 **/
public class Test21 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = 1;
            }
            int count = 0;
            int num = n;
            while(num>1) {
                //每次进入此循环都要重置i
                int i = 0;
                while(i<n) {
                    if (nums[i] == 1) {
                        count++;
                    }
                    if (count == 3) {
                        nums[i] = 0;
                        count = 0;
                        num--;
                    }
                    i++;
                }
            }
            for (int j = 0; j < nums.length; j++) {
                if(nums[j] == 1) {
                    System.out.println(j);
                }
            }
        }
    }
}
