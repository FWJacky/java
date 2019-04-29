package 选择排序;

import java.util.Arrays;

/**
 * @ClassName SelectSort
 * @Description TODO
 * @Author L
 * @Date 2019/4/27 14:38
 * @Version 1.0
 **/
public class SelectSort {
    public static void selectSort(int[] array) {
        //测试排序时间
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        //测试排序的时间
    }

    public static void main(String[] args) {
        int[] array = {1,7,5,9,8,4,2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }
}
