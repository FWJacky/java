package com.github.SevenSort;

/**
 * @ClassName HeapSort
 * @Description TODO
 * @Author L
 * @Date 2019/7/16 18:28
 * @Version 1.0
 **/
public class HeapSort {
    //第一步：创建堆
    // 对必须满足两个条件：
    // 1. 必须是完全二叉树
    // 2. 父节点要大于子节点
    public static void heapify(int[] tree, int n, int i) {
        // n代表节点个数，i代表对那个节点进行heapify
        if (i >= n) {
            return;
        }
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if (c1 < n && tree[c1] > tree[max]) {
            max = c1;
        }
        if (c2 < n && tree[c2] > tree[max]) {
            max = c2;
        }
        if (max != i) {
            swap(tree, max, i);
            heapify(tree, n,max);
        }
    }

    // 创建堆
    public static void buildHeap(int[] tree,int n) {
        // n代表节点数
        int lastNode = n-1;
        int parentNode = (lastNode -1)/2;
        for (int i = parentNode; i >= 0 ; i--) {
            heapify(tree, n,i);
        }
    }

    // 堆排序
    public static void heapSort(int[] tree,int n) {
        buildHeap(tree, n);
        for (int i = n-1 ; i >= 0 ; i--) {
            swap(tree, i, 0);
            heapify(tree, i, 0);
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] tree = {2,5,3,1,10,4};
        int n = tree.length;
//        heapify(tree, n, 0);
//        buildHeap(tree, n);
        heapSort(tree, n);
        for (int i = 0; i < n; i++) {
            System.out.println(tree[i]);
        }
    }
}
