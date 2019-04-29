package 归并排序;

import java.util.Arrays;

/**
 * @ClassName MergeSort
 * @Description TODO  归并排序
 * @Author L
 * @Date 2019/4/29 20:18
 * @Version 1.0
 **/
public class MergeSort {

    public static void merge(int[] arrary,int start,int mid,int end) {
        int [] tmp = new int[arrary.length];
        int tmpIndex = start;
        int start2 = mid + 1;
        //保留归并之前的start
        int i = start;
        //两个归并段都有数据的时候
        while(start <= mid && start2 <= end) {
            if(arrary[start] >= arrary[start2]) {
                tmp[tmpIndex++] = arrary[start2++];
            }else {
                tmp[tmpIndex++] = arrary[start++];
            }
        }
        while(start <= mid) {
            tmp[tmpIndex++] = arrary[start++];
        }
        while(start2 <= end) {
            tmp[tmpIndex] = arrary[start2++];
        }
        //将tmp拷贝给array
        while(i<=end) {
            arrary[i] = tmp[i];
            i++;
        }
    }
    public static void mergeSort(int[] array,int start,int end) {
        if(start == end) {
            return;
        }
        int mid = (start+end)/2;
        //分解过程
        mergeSort(array,start,mid);
        mergeSort(array,mid+1,end);
        //合并
        merge(array,start,mid,end);
        System.out.println(Arrays.toString(array));

    }

    public static void main(String[] args) {
        int[] array = {10,6,7,1,3,9,4,2};
        System.out.println(Arrays.toString(array));
        mergeSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
