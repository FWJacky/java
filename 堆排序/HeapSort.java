package 堆排序;

/**
 * @ClassName HeapSort
 * @Description TODO   堆排序   写20遍   熟练掌握
 * @Author L
 * @Date 2019/4/27 15:09
 * @Version 1.0
 **/
public class HeapSort {

    //一次调整的时间复杂度为log2 n
    public static void adjust(int[] array,int start,int end) {
        int tmp = array[start];
        for (int i = 2*start+1; i <= end; i = i*2+1) {
            //找到左右孩子的最大值的下标
            if(i<end && array[i] < array[i+1]){
                i++;
            }
            if(array[i]>tmp) {
                array[start] = array[i];
                start = i;
            }else {
                break;
            }
        }
        array[start] = tmp;
    }

    //把整棵树调整为大根堆的时间复杂度为：nlog2 n
    public static void heapSort(int[] array) {
        for (int i = 0; i <(array.length-1)/2 ; i++) {
            adjust(array,i,array.length-1);
        }

        //交换/调整
        for (int j = 0; j <(array.length-1)/2 ; j++) {
            int tmp = array[array.length-1-j];
            array[j] = tmp;
            array[array.length-1-j] = array[j];
            adjust(array,0,array.length-1-j-1);
        }
    }
}
