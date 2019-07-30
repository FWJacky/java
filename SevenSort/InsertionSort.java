package com.github.SevenSort;

import java.util.Arrays;

/**
 * @ClassName InsertionSort
 * @Description TODO
 * @Author L
 * @Date 2019/7/16 16:09
 * @Version 1.0
 **/
public class InsertionSort {
    public static void insertionSort1(int[] array) {
        for(int i = 1 ; i<array.length ; i++) {
            for(int j = i ; j > 0 ; j--) {
                if(array[j] < array[j-1]) {
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
    public static void insertionSort2(int[] array) {
        for(int i = 0; i < array.length ; i++) {
            for(int j = i ; j > 0 && array[j] < array[j-1] ; j--) {
                array[j] = array[j] ^ array[j-1];
                array[j-1] = array[j] ^ array[j-1];
                array[j] = array[j] ^ array[j-1];
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort3(int[] array) {
        for(int i = 0; i < array.length ;i++) {
            int tmp = array[i];
            int j = 0;
            for(j = i ; j > 0 && tmp < array[j-1] ; j--) {
                array[j] = array[j-1];
            }
            array[j] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {9,3,1,4,6,8,7,5,2};
        insertionSort1(array);
        insertionSort2(array);
        insertionSort3(array);
    }
}
