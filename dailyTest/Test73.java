package dailyTest;

/**
 * @ClassName Test73
 * @Description TODO
 * @Author L
 * @Date 2019/8/8 12:33
 * @Version 1.0
 **/
public class Test73 {
    public int countWays(int n) {
        // write code here
        int[] a = new int[n];
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n == 3) {
            return 4;
        }
        a[0] = 1;
        a[1] = 2;
        a[2] = 4;
        for (int i = 3; i < n; i++) {
            a[i] = ((a[i - 1] + a[i - 2]) % 1000000007 + a[i - 3] % 1000000007)%1000000007;
        }
        return a[n-1];
    }
}
