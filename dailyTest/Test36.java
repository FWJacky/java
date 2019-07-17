package com.github.dailyTest;

import java.util.Arrays;

/**
 * @ClassName Test36
 * @Description TODO
 * @Author L
 * @Date 2019/7/17 10:27
 * @Version 1.0
 **/
public class Test36 {

    public static void test(int A, int B) {
        // write code here
        int[] byteA = new int[32];
        int[] byteB = new int[32];
        for (int i = 31; i >= 0; i--) {
            byteA[31-i] = (A >> i) & 1;
            byteB[31-i] = (B >> i) & 1;
        }
        System.out.println(Arrays.toString(byteA));
        System.out.println(Arrays.toString(byteB));
    }

    public static int addAB(int A, int B) {
        // write code here
        // 异或运算是半加法运算，其运算法则相当于不带进位的二进制加法
        while (B !=0) {
            // 先进行异或运算，得到无进位的值
            int sum = A ^ B;
            // 再将进制位的值求出来
            int carry = (A & B) << 1;
            // 将无进位的值赋给A
            A = sum;
            // 将进制位代表的值赋给B，再进行异或运算
            B = carry;
        }
        return A;
    }

    public static void main(String[] args) {
//        test(1, 2);
        System.out.println(addAB(0, 10));
    }
}
