package com.github.SevenSort;

import java.util.Arrays;

/**
 * @ClassName Qsort
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 2:32
 * @Version 1.0
 **/
//从小到大排列
public class AscQsort {

    public static void qSort(int[] a , int low , int high) {
        int p = partion(a, low, high);
        if(p >low+1) {
            qSort(a, low, p);
        }
        if(p<high-1){
            qSort(a, p+1, high);
        }
    }

    public static int partion(int[] a,int low,int high) {
        int tmp = a[low];
        while(low<high) {
            while(low<high&&a[high]>=tmp) {
                high--;
            }
            a[low] = a[high];
            while(low<high&&a[low]<=tmp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,1,3,4,8}; // 1 3 3 4 4 5 8
        qSort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
