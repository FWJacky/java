package com.github.dailyTest;

/**
 * @ClassName Test25
 * @Description TODO
 * @Author L
 * @Date 2019/7/15 23:38
 * @Version 1.0
 **/
public class Test25 {

    public int countWays(int x,int y) {
        if(x==1||y==1) {
            return 1;
        }
        return countWays(x-1,y )+countWays(x,y-1 );
    }

    public static void main(String[] args) {
        Test25 ts = new Test25();
        System.out.println(ts.countWays(2, 2));
    }
}
