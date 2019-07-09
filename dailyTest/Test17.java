package com.github.dailyTest;

/**
 * @ClassName Test17
 * @Description TODO
 * @Author L
 * @Date 2019/7/9 11:00
 * @Version 1.0
 **/
public class Test17 {
    static int cnt = 6;
    static {
        cnt += 9;
    }

    public static void main(String[] args) {
        System.out.println("cnt = "+cnt);
    }
    static {
        cnt /= 3;
    }
}


