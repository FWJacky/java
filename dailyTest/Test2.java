package com.github.dailyTest;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author L
 * @Date 2019/6/30 23:26
 * @Version 1.0
 **/
public class Test2 {
    public static int findKth(int[] a, int n, int K) {
        return qSort(a, 0, n - 1, K);
    }

    public static int qSort(int[] a, int low, int high, int k) {
        int partion = partion(a, low, high);

        if (k == partion - low + 1) {
            return a[partion];
        }else if (k > partion - low + 1) {
            return qSort(a, partion + 1, high, k - (partion - low + 1));
        }else{
            return qSort(a, low, partion - 1, k);
        }
    }

    public static int partion(int[] a, int low, int high) {
        int tmp = a[low];
        while (low < high) {
            while (low < high && a[high] <= tmp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] >= tmp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 2};
        int rs = findKth(a, 5, 1);
        System.out.println(rs);
    }
}
