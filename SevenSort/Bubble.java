package com.github.SevenSort;

/**
 * @ClassName Bubble
 * @Description TODO   冒泡排序
 * @Author L
 * @Date 2019/7/12 23:28
 * @Version 1.0
 **/

/**
 * 冒泡排序的思想是：每次用第一个值与相邻的值比较，如果比相邻的值大，则进行交换，再与下一个值比较，直到数组到达最后。
 **/

/**
 * TODO 如何优化冒泡排序，使最好的时间复杂度为O(n)
 **/
public class Bubble {

    public static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static void bubble(int[] array) {
        //总共需要比较的个数为n-1个，因为最后一个不需要比较了
        for (int i = 0; i < array.length - 1; i++) {
            //前后两两比较
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = {9, 3, 1, 4, 6, 8, 7, 5, 2};
        bubble(array);
        print(array);
    }
}
