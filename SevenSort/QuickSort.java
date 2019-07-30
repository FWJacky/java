package com.github.SevenSort;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QuickSort
 * @Description TODO
 * @Author L
 * @Date 2019/7/17 0:25
 * @Version 1.0
 **/
public class QuickSort {
    // 确定中轴位置
    public static int partition(int[] arr,int left,int right) {
        int pivot = arr[left];
        while(left < right) {
            // 先从右边开始
            while(left < right && arr[right] >= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while(left < right && arr[left] <= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    // 快排递归
    public static void quickSort(int[] arr,int left,int right) {
        // 获得第一次排序后中轴位置
        int midPtr = partition(arr,left,right);
        // 判断边界情况
        if(left >= right) {
            return;
        }
        if(left + 1 < midPtr) {
            quickSort(arr,left,midPtr);
        }
        if(midPtr + 1 < right) {
            quickSort(arr,midPtr+1,right);
        }
    }

    // 测试
    public static void main(String[] args) {
        int[] arr = new int[20];
        Random random = new Random();
        for(int i = 0; i< arr.length;i++) {
            arr[i] = random.nextInt(20);
        }
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
