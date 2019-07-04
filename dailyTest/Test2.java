import java.util.Arrays;
import java.util.Random;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author L
 * @Date 2019/6/30 23:26
 * @Version 1.0
 **/
public class Test2 {
    public static int findKth(int[] a, int n, int K) {
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > i; j--) {
                if (a[j] > a[i]) {
                    int tmp = a[j];
                    a[j] = a[i];
                    a[i] = tmp;
                }
            }
        }
        return a[K - 1];
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 2, 2};
        int rs = findKth(a, 5, 1);
        System.out.println(rs);
    }
}
