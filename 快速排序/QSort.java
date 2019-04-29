package 快速排序;

import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName QSort
 * @Description TODO  快速排序   递归方法
 * @Author L
 * @Date 2019/4/27 16:23
 * @Version 1.0
 **/
public class QSort {
    public static int partion(int[] array,int low,int high) {
        int tmp = array[low];
        while(low<high) {
            while ((low < high) && array[high] >= tmp) {
                high--;
            }
            if (low >= high) {
                break;
            }else {
                array[low] = array[high];
            }

            while((low < high) && array[low] <= tmp) {
                low++;
            }if(low >= high) {
                break;
            }else {
                array[high] = array[low];
            }

        }
        array[low] = tmp;
        return array[low];
    }

    public static void swap(int[] array,int start,int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
    //三数取中
    public static void medianOfThree(int[] array,int low,int high) {
        int mid = (low+high) >>>1 ;
        //array[mid] <= array[low] <= array[high]
        //5      2     0    ===>  2   0   5
        //low   mid   high
        if(array[mid] > array[low]) {
            swap(array,mid,low);
        }
        if(array[mid] > array[high]) {
            swap(array,mid,high);
        }
        if(array[low] > array[high]) {
            swap(array,low,high);
        }
    }

    public static void quick(int[] array,int start,int end) {

        int par = partion(array,start,end);
        if(par > start+1) {
            quick(array,start,par-1);
        }
        if (par < end-1) {
            quick(array,par+1,end);
        }
    }


    //递归实现快速排序
    public static void qSort(int[] array) {
        long start = System.currentTimeMillis();
        quick(array,0,array.length-1);
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    //非递归实现快速排序
    public static void qSort2(int[] array) {
        int[] stack = new int[array.length*2];
        int top = 0;

        int low = 0;
        int high = array.length-1;
        //先进行一趟快速排序
        int par = partion(array,low,high);
        //1、判断当前par的左右两边是否有两个数据以上
        if(par > low+1) {
            stack[top++] = low;
            stack[top++] = par-1;
        }
        if(par > high-1) {
            stack[top++] = par+1;
            stack[top++] = high;
        }
        //以上代码执行完毕，两边的区间已经全部入栈
        //接下来需要判断栈是否为空，不为空，取出区间边界 进行partion()
        while (top != 0) {
            high = stack[--top];
            low = stack[--top];
            par = partion(array,low,high);
            if(par > low+1) {
                stack[top++] = low;
                stack[top++] = par-1;
            }
            if(par > high-1) {
                stack[top++] = par+1;
                stack[top++] = high;
            }
        }
    }
    public static void main(String[] args) {
        Random random = new Random();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10000)+1;
        }
        qSort(array);
        System.out.println(Arrays.toString(array));
    }
}
