package com.github.FWJacky;

/**
 * @ClassName Mymath
 * @Description TODO
 * @Author L
 * @Date 2019/5/9 15:37
 * @Version 1.0
 **/
public class Mymath {

    public static int sum(int a , int b) {
        return a + b;
    }

    public static int sub(int a , int b) {
        return a - b;
    }

    public static int div(int a , int b) {
        if(b == 0) {
            throw new IllegalArgumentException("b 作为除数不能为0");
        }
        return a / b;
    }
}
