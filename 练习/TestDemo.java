package 练习;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName TestDemo
 * @Description TODO
 * @Author L
 * @Date 2019/4/20 13:34
 * @Version 1.0
 **/
public class TestDemo {
//    public static int reverse(int x) {
//        long res = 0L;
//        if(x==0) {
//            return 0;
//        }
//        //核心步骤
//        while(x!=0) {
//            res =res*10 + x%10;
//            x = x/10;
//        }
//        if(res<-2147483648||res>2147483647) {
//            return 0;
//        }
//        return (int)res;
//    }

    //直接插入排序
    public static void insertSort(int[] array) {
        int len = array.length;
        for (int i = 1; i < len; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-1; j >=0 ; j--) {
                if(array[j] > tmp) {
                    array[j+1] = array[j];
                }else {
                    break;
                }
            }
            array[j+1] = tmp;
        }
    }

    //shell排序
    public static void shell(int[] array,int gap) {
        int len = array.length;
        for (int i = gap; i < len; i++) {
            int tmp = array[i];
            int j = 0;
            for (j = i-gap; j >=0 ; j-=gap) {
                if(array[j] > tmp) {
                    array[j+gap] = array[j];
                }else {
                    break;
                }
            }
            array[j+gap] = tmp;
        }
    }

    public static void shellSort(int[] array) {
        int[] drr = {5,3,1};
        for (int i = 0; i < drr.length; i++) {
            shell(array,drr[i]);
        }
    }
    public static void main(String[] args) {
        int[] array = {3,5,8,9,12,10};
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }
//    public static void main1(String[] args) {
//        System.out.println(reverse(-1534236469));
        //123/10=12  12%10=2  12/10
//        int x = 1;
//        int a = x%10;
//        int b = x/10%10;
//        int c = x/10/10;
//        int y = a*100+10*b+c;
//        if(y<-2147483648||y>2147483647) {
//            System.out.println(0);
//        }else {
//            System.out.println(y);
//
//        }
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//    }
}
