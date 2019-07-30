package com.github.dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test34
 * @Description TODO
 * @Author L
 * @Date 2019/7/16 13:50
 * @Version 1.0
 **/
public class Test34 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextLine()) {
            String str = in.nextLine();
            String[] nums = str.split(" ");
            int[] num = new int[10];
            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(nums[i]);
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < num.length -1 ; i++) {
                if(num[i]!=0) {
                    sb.append(i);
                    num[i]--;
                    break;
                }
            }
            int i = 0;
            while(i<10) {
                while(num[i] > 0) {
                    sb.append(i);
                    num[i]--;
                }
                i++;
            }
            System.out.println(sb.toString());
        }
    }
}
