package dailyTest;


/**
 * @ClassName Test87
 * @Description TODO  二维数组打印
 * @Author L
 * @Date 2019/8/15 11:07
 * @Version 1.0
 **/
public class Test87 {

    public int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int[] rs = new int[n * n];
        int index = 0;
        int x = 0;
        int y = n - 1;
        while (x < n) {
            int i = x;
            int j = y;
            while (i < n && j < n) {
                rs[index++] = arr[i++][j++];
            }
            if (y > 0) {
                y--;
            } else {
                x++;
            }
        }
        return rs;
    }
}
