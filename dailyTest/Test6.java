import java.util.Arrays;

/**
 * @ClassName Test6
 * @Description TODO
 * @Author L
 * @Date 2019/7/2 14:20
 * @Version 1.0
 **/
public class Test6 {

    public static int count(int[] A, int n) {
        //先找出数组中最小值所在的下标
        if (n > 5000 || n <= 0 || A.length == 0) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(A[i]>A[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] A = {0,1,2,3,4,5,6,7};
//        int[] A1 = {1,2,3,4,5,6,7,0};
        int[] A = {1,2,3,4,0,6,7,8};
        int rs = count(A, 8);
        System.out.println(rs);
    }
}
