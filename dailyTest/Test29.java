package com.github.dailyTest;

/**
 * @ClassName Test29
 * @Description TODO
 * @Author L
 * @Date 2019/7/13 12:40
 * @Version 1.0
 **/
public class Test29 {


    public static int[] exchangeAB(int[] AB) {
        // write code here
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
}
