package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test91
 * @Description TODO   连续最大和
 * @Author L
 * @Date 2019/8/17 14:38
 * @Version 1.0
 **/
public class Test91 {

    public static int sumMax(int[] arr) {
        if(arr.length < 0) {
            return -1;
        }
        int sum = arr[0];
        int maxSum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum = (sum > 0) ? sum+arr[i] : arr[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int rs = sumMax(arr);
            System.out.println(rs);
        }
    }
}
