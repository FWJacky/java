package dailyTest;
import java.util.Scanner;

/**
 * @ClassName Test53
 * @Description TODO
 * @Author L
 * @Date 2019/7/26 15:11
 * @Version 1.0
 **/

public class Test53 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int A1 = 0;
            int A2 = 0;
            int A3 = 0;
            int A4 = 0;
            int A5 = 0;
            int count = 0;
            int count2 = 0;
            int count3 = 0;
            // A1 ：能被5整除的数字中所有偶数的和
            // A2 ：将被5整除后的余1的数字按照给出的顺序进行交错求和
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 10 == 0) {
                    A1 += arr[i];
                }
                if (arr[i] % 5 == 1) {
                    ++count2;
                    A2 += Math.pow(-1, count2 - 1) * arr[i];
                }
                if (arr[i] % 5 == 2) {
                    count++;
                    A3 = count;
                }
                if (arr[i] % 5 == 3) {
                    count3++;
                    A4 += arr[i];
                    // TODO 求平均数
                }
                if (arr[i] % 5 == 4) {
                    A5 = Math.max(A5, arr[i]);
                }
            }
            if (A1 != 0) {
                System.out.print(A1 + " ");
            } else {
                System.out.print('N' + " ");
            }
            if (A2 != 0) {
                System.out.print(A2 + " ");
            } else {
                System.out.print('N' + " ");
            }
            if (A3 != 0) {
                System.out.print(A3 + " ");
            } else {
                System.out.print('N' + " ");
            }
            if (A4 != 0) {
                System.out.print(A4 / count3 + "." + Math.round((double) A4 % count3 * 10 / count3) + " ");
            } else {
                System.out.print("N" + " ");
            }
            if (A5 != 0) {
                System.out.print(A5);
            } else {
                System.out.print("N");
            }
        }
        in.close();
    }
}
