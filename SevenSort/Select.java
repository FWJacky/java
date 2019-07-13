package com.github.SevenSort;

import java.util.Arrays;

/**
 * @ClassName Select
 * @Description TODO  选择排序
 * @Author L
 * @Date 2019/7/12 23:05
 * @Version 1.0
 **/
/**
 * 选择排序思想是：先假设第一个值为最小值，将此值与其他数字进行一一比较，如果找到了最小的值，则将最小值与设定值进行交换，
 * 接着将第二个值设定为最小值，再将此值与之后的数字进行一一比较，找到剩余数字中最小的值，与之交换。。。
 **/
public class Select {

    public static void select(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minPosition = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[minPosition]) {
                    minPosition = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minPosition];
            array[minPosition] = tmp;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] array = {5,4,2,1,3,2,2,2,3,3,3,3,3,3,6,7,0,3,2};
        select(array);
    }
}
