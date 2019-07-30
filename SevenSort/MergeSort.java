package com.github.SevenSort;

/**
 * @ClassName MergeSort
 * @Description TODO 归并排序
 * @Author L
 * @Date 2019/7/16 22:26
 * @Version 1.0
 **/

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * TIM Sort java对象排序的方法
 **/
public class MergeSort {
    // 归并方法----相当于工具，最后将排序好的左右数组进行归并处理
    // leftPtr表示左数组的起始位置
    // rightPtr表示右数组起始位置
    // rightBound表示归并的右边界
    public static void merge(int[] arr,int leftPtr,int rightPtr,int rightBound) {
        // 先创建一个临时数组用来存储归并后的数据
        int[] temp = new int[rightBound - leftPtr + 1];
        // 定义三个变量用来充当指针
        int i = leftPtr;
        int j = rightPtr;
        // k表示临时数组的0号下标
        int k = 0;
        // mid表示左数组的边界位置,类似于上图值为10所对应的下标
        int mid = rightPtr - 1;
        while(i <= mid && j <= rightBound) {
            temp[k++] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
        // 当归并完后可能存在左数组还有值，或者有数组还有值的情况，直接复制到temp数组后面
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= rightBound) {
            temp[k++] = arr[j++];
        }
        // 将临时数组拷贝回原数组arr
        System.arraycopy(temp,0,arr,leftPtr,temp.length);
    }

    // 排序方法----用于将左右数组进行排序
    public static void mergeSort(int[] arr,int left,int right) {
        // 校验输入的参数是否合法
        if(left < 0 || right < 0 || left > arr.length || right > arr.length) {
            throw new NumberFormatException("非法参数");
        }
        // 递归出口，如果left==right 说明只有一个数，不需要排序了
        if(left == right) {
            return;
        }
        // 找到中间位置
        int mid = left + (right - left) / 2;
        // 分左右两边进行排序
        // 左边排序
        mergeSort(arr,left,mid);
        // 右边排序
        mergeSort(arr,mid+1,right);
        // 排序完之后，进行归并处理
        merge(arr,left,mid+1,right);
    }

    // 测试方法
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 2, 4, 8, 9,7};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
