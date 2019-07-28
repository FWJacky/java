package com.github.dailyTest;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test38
 * @Description TODO  洗牌问题
 * @Author L
 * @Date 2019/7/18 10:10
 * @Version 1.0
 **/
public class Test38 {

    //
    public static void shuffle(int k,int[] arr) {
        if(k==0) {
            return;
        }
        int i = 0;
        int j = arr.length/2;
        int m = 0;
        int leftBound = j - 1;
        int rightBound = arr.length-1;
        int[] temp = new int[arr.length];
        while (i<=leftBound && j <= rightBound) {
            temp[m++] = arr[i++];
            temp[m++] = arr[j++];
        }
        shuffle(--k, temp);
        System.arraycopy(temp, 0, arr, 0, temp.length);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()) {
            int t = in.nextInt();
            for (int i = 0; i < t; i++) {
                int n = in.nextInt();
                int k = in.nextInt();
                int[] arr = new int[2*n];
                for (int j = 0; j < 2*n; j++) {
                    arr[j] = in.nextInt();
                }
                shuffle(k,arr);
                String result = "";
                for (int j = 0; j < arr.length; j++) {
                    result += arr[j] + " ";
                }
                System.out.println(result);
            }
        }
    }
}
