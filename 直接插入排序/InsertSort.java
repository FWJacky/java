package 直接插入排序;

/**
 * @ClassName InsertSort
 * @Description TODO
 * @Author L
 * @Date 2019/4/27 17:19
 * @Version 1.0
 **/
public class InsertSort {
    public static void insertSort(int[] array,int start,int end) {
        for (int i = start+1; i <= end; i++) {   //这里end传入的是 length-1；
            int tmp = array[i];
            int j = 0;
            for (j =i-1 ; j < end ; j++) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else{
                    break;
                }
            }
            array[j] = tmp;
        }
    }
}
