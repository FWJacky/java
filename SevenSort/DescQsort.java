package com.github.SevenSort;

import java.util.Arrays;

/**
 * @ClassName DescQsort
 * @Description TODO
 * @Author L
 * @Date 2019/7/5 2:47
 * @Version 1.0
 **/
//降序快排
public class DescQsort {

    public static void descQsort(int[] a,int low,int high){
        //获取第一次快排后的基准值的下标
        //在基准值的左侧，都是大于它的值，在基准值的右侧都是小于它的值
        int p = partion(a, low, high);

        //判断：如果基准值的下标p>low+1,说明在p的左边还需要进行快排
        //如果p = low+1 说明左侧只有a[low]这一个值，不需要再快排了，因为a[low]>=a[p]
        if(p>low+1) {
            descQsort(a, low, p);
        }
        //判断：如果基准值的下标p<high-1,说明在p的右边还需要进行快排
        //如果p = high-1 说明右侧只有a[high]这一个值，不需要再快排了，因为a[high]<=a[p]
        if(p<high-1) {
            descQsort(a, p+1, high);
        }

    }

    //快排的逻辑
    public static int partion(int[] a,int low,int high){
        //设定基准
        int tmp = a[low];
        while(low<high) {
            /*
             判断一次右边，再判断一次左边
             **/
            //从右往左比较，如果a[high]<=tmp,则high--，一直到a[high]>=tmp时
            //这时，将a[low]=a[high]，将大的值放到左边
            while (low<high&&a[high]<=tmp) {
                high--;
            }
            a[low] = a[high];
            while (low<high&&a[low]>=tmp){
                low++;
            }
            a[high] = a[low];
        }
        //此时跳出while循环时，low和high指向同一元素，即low=high
        //所以此时将基准赋值给a[low]和a[high]都可以
        a[low] = tmp;
        //返回基准值的下标
        return low;
    }

    public static void main(String[] args) {
        int[] a = {4,3,5,1,3,4,8}; // 1 3 3 4 4 5 8
        descQsort(a, 0, a.length-1);
        System.out.println(Arrays.toString(a));
    }
}
