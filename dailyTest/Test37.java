package com.github.dailyTest;

import java.util.Scanner;

/**
 * @ClassName Test37
 * @Description TODO
 * @Author L
 * @Date 2019/7/17 10:49
 * @Version 1.0
 **/
public class Test37 {

    public static int countWays (int n) {
        int count = 0;
        while (n!=0 && count <= 300000) {
            n = ((n << 1) + 1 ) % 1000000007;
            count++;
        }
        int result = (count + 2) / 3;
        return result > 100000 ? -1:result;
    }

    public static int countWays2(int n) {
        long[] f = new long[3];
        f[0] = n;
        f[1] = (4*f[0]+3)%1000000007;
        f[2] = (4*f[1]+3)%1000000007;
        int minStep = 100000;
        for (int i = 0; i < f.length; i++) {
            long cur = f[i];
            int count = i;
            while(cur != 0 && count<= minStep) {
                cur = (cur*8+7) % 1000000007;
                count ++ ;
            }
            minStep = minStep < count ? minStep : count;
        }
        if(minStep < 100000) {
            return minStep;
        }else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        if(in.hasNextLine()) {
            int n = Integer.parseInt(String.valueOf(in.nextLine()));
            System.out.println(countWays2(n));
        }
        in.close();
    }
}
