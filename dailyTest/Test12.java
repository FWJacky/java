package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test12
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 0:20
 * @Version 1.0
 **/
/**
 * @Author
 * @Description // TODO 神奇的口袋问题
 * @Date 1:58 2019/7/5
 * @Param 
 * @return 
 **/
public class Test12 {
    static int count;
    static int[] weight;
    static int n;

    //s代表需要的重量，n代表可用物品的个数
    public static void count(int s, int n) {
        //如果重量==0，说明刚好装满了
        if (s == 0) {
            count++;
            return;
        }
        //递归的返回条件s<0或者n<1的时候开始归
        if (s < 0 || (s > 0 && n < 1)) {
            return;
        }
        //用s减去最后一件物品的重量，并且物品个数减1，进行递归
        count(s - weight[n], n - 1);
        //如果当前物品行不通，则用前一件物品
        count(s, n - 1);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            n = in.nextInt();
            if(n<1||n>40) {
                return;
            }
            weight = new int[n + 1];
            for (int i = 1; i < n + 1; i++) {
                int num = in.nextInt();
                if (num >= 1 && num <= 40) {
                    weight[i] = num;
                }else {
                    return;
                }
            }
            count(40, n);
            System.out.println(count);
        }
    }
}
