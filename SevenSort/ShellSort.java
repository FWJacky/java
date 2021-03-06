package com.github.SevenSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName ShellSort
 * @Description TODO
 * @Author L
 * @Date 2019/7/16 20:18
 * @Version 1.0
 **/
public class ShellSort {
    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void shellSort(int[] arr) {
        int h = 1;
        while(h <= arr.length/3) {
            h = h * 3 + 1;
        }
        for (int gap = h; gap > 0 ; gap = (gap - 1)/3) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j > gap - 1 ; j -= gap) {
                    if(arr[j] < arr[j-gap]) {
                        swap(arr, j, j-gap);
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Random random = new Random();
//        System.out.println(i);
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100);
        }
//        int[] arr = {9,6,11,3,5,12,8,7,10,15,14,4,1,13,2};
        shellSort(arr);
    }
}
