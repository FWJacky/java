package dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test65
 * @Description TODO  数字和为sum的方法数
 * @Author L
 * @Date 2019/8/2 12:07
 * @Version 1.0
 **/
/*
 *
 *@Param
 *@return
 *  TODO    给定一个有n个正整数的数组A和一个整数sum，求选择数组A中部分数字和为sum的方案数
 *          当两种选取方案有一个数字的下标不一样，我们就认为是不同的组成方案
 **/
public class Test65 {
    private static int[] nums;
    private static int n;
    private static int count;

    // 递归会超时
    public static void count(int sum,int n) {
        if(sum == 0) {
            count++;
            return;
        }
        if(sum < 0 || (sum > 0 && n < 1)) {
            return;
        }
        count(sum-nums[n],n-1);
        count(sum,n-1);
    }

    // 动态规划
    public static long count2(int[] nums,int n,int sum) {
        long dp[] = new long[sum+1];
        dp[0] = 1;
        int i , j;
        for (i = 0; i < n; i++) {
            for(j = sum ; j >= nums[i];j--) {
                dp[j] = dp[j-nums[i]]+dp[j];
            }
        }
        return dp[sum];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            n = in.nextInt();
            int sum = in.nextInt();
            nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            System.out.println(count2(nums,n,sum));
        }
        in.close();
    }
}
