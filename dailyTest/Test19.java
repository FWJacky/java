package com.github.dailyTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @ClassName Test19
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 11:29
 * @Version 1.0
 **/

public class Test19 {
    public static void kNum(int[] a,int k) {
        Arrays.sort(a);
        for (int i = 0; i < k; i++) {
            System.out.print(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String[] str = in.nextLine().split(" ");
            int[] nums = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                nums[i] = Integer.parseInt(String.valueOf(str[i]));
            }
            int k = nums[nums.length-1];
            kNum(Arrays.copyOf(nums, nums.length-1),k);
        }

    }
}
