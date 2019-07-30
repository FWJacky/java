package com.github.dailyTest;

/**
 * @ClassName Tests3
 * @Description TODO  百万富翁问题   一百万富翁与一穷人交换钱，富翁每天给他10万元，
 *                    穷人第一天给1分钱，第二天给2分钱，第三天给4分钱，问30天后，
 *                    富翁交出多少钱，穷人交出多少钱，富翁以万为单位，穷人以分为单位。
 * @Author L
 * @Date 2019/7/20 14:05
 * @Version 1.0
 **/

public class Test43 {

    public static void main(String[] args) {
        long sumRich = 0;
        long sumStranger = 0 ;
        for (int i = 1; i <= 30; i++) {
            sumRich += 10;
            sumStranger = sumStranger + (long)Math.pow(2,i-1);
        }
        System.out.println(sumRich + " " + sumStranger);
    }
}
