package com.github.dailyTest;

/**
 * @ClassName Test28
 * @Description TODO
 * @Author L
 * @Date 2019/7/12 13:58
 * @Version 1.0
 **/
public class Test28 {

    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        // 计算下三角的值
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i-1] * A[i-1];
        }
        // 计算上三角的值
        int tmp = 1;
        for (int i = len-2; i >= 0; i--) {
            tmp *= A[i+1];
            B[i] *= tmp;
        }
        return B;
    }

    public static void main(String[] args) {

    }
}
